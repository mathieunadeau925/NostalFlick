package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleLangue", urlPatterns = {"/ControleLangue"})
public class ControleLangue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dest = "WEB-INF/erreur/erreur.jsp";
        if (request.getParameter("langue") != null) {
            String langue = request.getParameter("langue");
            session.setAttribute("langue", langue);
        }

        if (session.getAttribute("connected") != null) {
            String connectedClient = (String) session.getAttribute("connected");
            if (connectedClient.equals("true")) {
                dest = "/WEB-INF/client/accueilClient.jsp";
                RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
                disp.forward(request, response);
            }
        }

        if (session.getAttribute("connectedEmp") != null) {
            String connectedEmploye = (String) session.getAttribute("connectedEmp");
            if (connectedEmploye.equals("true")) {
                dest = "/WEB-INF/employe/accueilEmploye.jsp";
                RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
                disp.forward(request, response);
            }
        }
        response.sendRedirect(request.getHeader("Referer"));
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
