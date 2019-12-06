package control.servletsEmploye;

import DAO.UtilitaireCommande;
import DAO.UtilitaireListes;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ListeClients;
import model.ListeCommandes;

@WebServlet(name = "ControleEmpListeCommandes", urlPatterns = {"/ControleEmpListeCommandes"})
public class ControleEmpListeCommandes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("connectedEmp") != null) {
                String connectedEmp = (String) session.getAttribute("connectedEmp");
                if (connectedEmp.equals("true")) {
                    if (request.getParameter("action") != null) {
                        if (request.getParameter("action").equals("filter")) {
                            int numero = Integer.parseInt(request.getParameter("selectPersonne"));
                            if (numero == 0) {
                                UtilitaireCommande.getAllCommandes();
                            } else {
                                UtilitaireCommande.getCommandes(numero);
                            }
                        }
                    } else {
                        UtilitaireCommande.getAllCommandes();
                    }
                    ListeClients listeClients = UtilitaireListes.getListeClients();
                    request.setAttribute("listeClients", listeClients);
                    if (ListeCommandes.getListeCommandes().size() == 0) {
                        boolean vide = true;
                        request.setAttribute("vide", vide);
                    } else {
                        request.setAttribute("listeCommandes", ListeCommandes.getListeCommandes());
                    }
                    dest = "/WEB-INF/employe/afficherCommandes.jsp";

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
