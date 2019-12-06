package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListeClients;
import model.ListeEmployes;
import DAO.UtilitaireListes;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleListe", urlPatterns = {"/ControleListe"})
public class ControleListe extends HttpServlet {

    private ListeClients listeClients;
    private ListeEmployes listeEmployes;
    private boolean isEmploye;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dest = "/index.jsp";
        try {
            String action = request.getParameter("action");
            if (action.equals("employe")) {
                listeEmployes = UtilitaireListes.getListeEmployes();
                if (!listeEmployes.isEmpty()) {
                    dest = "/WEB-INF/accueil/pageConnexion.jsp";
                    isEmploye = true;
                    session.setAttribute("liste", listeEmployes);
                    session.setAttribute("isEmploye", isEmploye);
                }
            }

            if (action.equals("client")) {
                listeClients = UtilitaireListes.getListeClients();
                if (!listeClients.isEmpty()) {
                    isEmploye = false;
                    dest = "/WEB-INF/accueil/pageConnexion.jsp";
                    session.setAttribute("liste", listeClients);
                    session.setAttribute("isEmploye", isEmploye);
                }
            }

            if (action.equals("nouveauClient")) {
                dest = "/WEB-INF/accueil/creationCompte.jsp";
            }
            if (action.equals("accueil")) {
                dest = "/index.jsp";
            }

            RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
            disp.forward(request, response);

        } catch (Exception e) {
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
