package control.servletsEmploye;

import DAO.UtilitaireClient;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.ListeClients;

@WebServlet(name = "ControleEmpListeClients", urlPatterns = {"/ControleEmpListeClients"})
public class ControleEmpListeClients extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        ListeClients listeClients;
        HttpSession session = request.getSession();
        try {
            String connectedEmp = (String) session.getAttribute("connectedEmp");
            if (connectedEmp.equals("true")) {
                if (session.getAttribute("connectedEmp") != null) {
                    if (request.getParameter("action") != null) {

                        if (request.getParameter("action").equals("modifier")) {
                            int noClient = Integer.parseInt(request.getParameter("noClient"));
                            Client client = UtilitaireClient.getClientAdmin(noClient);
                            request.setAttribute("client", client);
                            dest = "/WEB-INF/employe/afficherClient.jsp";
                        }

                        if (request.getParameter("action").equals("rechercheClient")) {
                            String nomClient = request.getParameter("txtRecherche");
                            listeClients = UtilitaireClient.getListeRechercheClients(nomClient);
                            request.setAttribute("listeClients", listeClients);
                            dest = "/WEB-INF/employe/afficherClients.jsp";
                        }
                    } else {
                        listeClients = UtilitaireClient.getListeClients();
                        request.setAttribute("listeClients", listeClients);
                        dest = "/WEB-INF/employe/afficherClients.jsp";

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
