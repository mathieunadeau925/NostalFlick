package control.servletsEmploye;

import DAO.UtilitaireListeProduits;
import DAO.UtilitaireProduit;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ListeProduits;
import model.Produit;

@WebServlet(name = "ControleEmpProduit", urlPatterns = {"/ControleEmpProduit"})
public class ControleEmpProduit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("connectedEmp") != null) {
                String connectedEmp = (String) session.getAttribute("connectedEmp");
                if (connectedEmp.equals("true")) {

                    if (request.getParameter("action").equals("formProduit")) {
                        dest = "/WEB-INF/employe/formulaireAjouterProduit.jsp";
                    }

                    if (request.getParameter("action").equals("ajouterProduit")) {

                        String nomProduit = request.getParameter("nomProduit");
                        String lienProduit = request.getParameter("pathImg1") + request.getParameter("pathImg");
                        double prixProduit = Double.parseDouble(request.getParameter("prixProduit"));
                        String dureeProduit = request.getParameter("tempsProduit") + " minutes";
                        int qteProduit = Integer.parseInt(request.getParameter("qteProduit"));
                        Produit produit = new Produit(nomProduit, lienProduit, prixProduit, dureeProduit, qteProduit);
                        boolean produitAjoute = UtilitaireProduit.ajouterProduit(produit);
                        if (produitAjoute) {
                            request.setAttribute("produitAjoute", produitAjoute);
                            dest = "/WEB-INF/employe/formulaireAjouterProduit.jsp";
                        } else {
                            boolean produitRefuse = true;
                            request.setAttribute("produitRefuse", produitRefuse);
                            dest = "/WEB-INF/employe/formulaireAjouterProduit.jsp";
                        }
                    }

                    if (request.getParameter("action").equals("voirProduit")) {
                        int noProduit = Integer.parseInt(request.getParameter("noProduit"));
                        Produit produit = UtilitaireProduit.getProduit(noProduit);
                        if (produit != null) {
                            request.setAttribute("produit", produit);
                            dest = "/WEB-INF/employe/afficherProduit.jsp";
                        } else {
                            dest = "/WEB-INF/erreur/erreur.jsp";
                        }
                    }

                    if (request.getParameter("action").equals("modifierProduit")) {
                        int noProduit = Integer.parseInt(request.getParameter("noProduit"));
                        String nomProduit = request.getParameter("nomProduit");
                        String lienProduit = request.getParameter("pathImg");
                        double prixProduit = Double.parseDouble(request.getParameter("prixProduit"));
                        String tempsProduit = request.getParameter("tempsProduit");
                        int qteProduit = Integer.parseInt(request.getParameter("qteProduit"));
                        Produit produit = new Produit(noProduit, nomProduit, lienProduit, prixProduit, tempsProduit, qteProduit);
                        boolean produitModifie = UtilitaireProduit.updateProduit(produit);
                        if (produitModifie) {
                            request.setAttribute("produitModifie", produitModifie);
                            request.setAttribute("produit", produit);
                            dest = "/WEB-INF/employe/afficherProduit.jsp";
                        } else {
                            boolean produitRefuse = true;
                            request.setAttribute("produitRefuse", produitRefuse);
                            request.setAttribute("produit", produit);
                            dest = "WEB-INF/employe/afficherProduit.jsp";
                        }
                    }

                    if (request.getParameter("action").equals("supprimerProduit")) {
                        int noProduit = Integer.parseInt(request.getParameter("noProduit"));
                        boolean produitDelete = UtilitaireProduit.deleteProduit(noProduit);

                        if (produitDelete) {
                            ListeProduits listeProduits = UtilitaireListeProduits.getListeProduits();
                            request.setAttribute("produitDelete", produitDelete);
                            request.setAttribute("listeProduits", listeProduits);
                            dest = "/WEB-INF/employe/afficherProduits.jsp";
                        } else {
                            boolean produitRefuse = true;
                            request.setAttribute("produitRefuse", produitRefuse);
                            dest = "/WEB-INF/employe/afficherProduit.jsp";
                        }
                    }
                }
            }
        } catch (Exception e) {
            dest = "/WEB-INF/erreur/erreur.jsp";
        } finally {
            RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
            disp.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
