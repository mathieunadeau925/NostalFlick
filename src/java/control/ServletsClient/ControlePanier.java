package control.ServletsClient;

import DAO.UtilitaireListeProduits;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PanierAchat;
import model.Produit;
import utilitaire.UtilitaireCalculs;
import utilitaire.UtilitaireGetProduit;

@WebServlet(name = "ControlePanier", urlPatterns = {"/ControlePanier"})
public class ControlePanier extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Produit produit;
        String connected;
        String dest = "/index.jsp";
        double prixTotal = 0;
        double tps = 0;
        double tvq = 0;
        double prixTotalAvecTaxes = 0;
        int qtePanier = 0;
        try {
            if (session.getAttribute("connected") != null) {
                connected = (String) session.getAttribute("connected");

                if (connected.equals("true")) {

                    if (request.getParameter("action") != null) {

                        if (request.getParameter("action").equals("addCart")) {

                            if (request.getParameter("produit") != null) {
                                int noProduit = Integer.parseInt(request.getParameter("produit"));
                                produit = UtilitaireListeProduits.getProduit(noProduit);
                                PanierAchat.ajouterListe(produit);

                                request.setAttribute("produit", produit);
                                dest = "/WEB-INF/client/produitAjoute.jsp";
                            }
                        }

                        if (request.getParameter("action").equals("panier")) {
                            ArrayList<Produit> panier = PanierAchat.getPanierAchat();
                            session.setAttribute("panier", panier);
                            dest = "/WEB-INF/client/panierAchats.jsp";
                        }

                        if (request.getParameter("action").equals("delete")) {
                            int produitNo = Integer.parseInt(request.getParameter("produitNo"));
                            Produit pr = UtilitaireGetProduit.getProduit(produitNo);
                            if (pr != null) {
                                PanierAchat.supprimerListe(pr);
                                dest = "/WEB-INF/client/panierAchats.jsp";
                            }
                        }

                        if (request.getParameter("action").equals("deleteAll")) {
                            PanierAchat.getPanierAchat().clear();
                            dest = "/WEB-INF/client/panierAchats.jsp";
                        }

                        if (request.getParameter("action").equals("buy")) {
                            dest = "/WEB-INF/client/acheterPanier.jsp";
                        }
                    }
                    qtePanier = PanierAchat.getPanierAchat().size();
                    prixTotal = UtilitaireCalculs.calculerPrixTotal(prixTotal);
                    tps = UtilitaireCalculs.calculerPrixTps(prixTotal);
                    tvq = UtilitaireCalculs.calculerPrixTvq(prixTotal);
                    prixTotalAvecTaxes = UtilitaireCalculs.calculerPrixAvecTaxes(prixTotal, tps, tvq);
                    session.setAttribute("prixTotal", prixTotal);
                    session.setAttribute("prixTps", tps);
                    session.setAttribute("prixTvq", tvq);
                    session.setAttribute("prixTotalAvecTaxes", prixTotalAvecTaxes);
                    session.setAttribute("qtePanier", qtePanier);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
