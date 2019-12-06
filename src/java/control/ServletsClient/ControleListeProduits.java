package control.ServletsClient;

import DAO.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ListeProduits;

@WebServlet(name = "ControleListeProduits", urlPatterns = {"/ControleListeProduits"})
public class ControleListeProduits extends HttpServlet {
    private ListeProduits listeProduits;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("connected") != null) {
                String connected = (String) session.getAttribute("connected");
                if (connected.equals("true")) {
                    if (request.getParameter("action") != null) {
                        String action = request.getParameter("action");

                        if (action.equals("getListeProduits")) {
                            listeProduits = UtilitaireListeProduits.getListeProduits();
                            if (!listeProduits.isEmpty()) {
                                dest = "/WEB-INF/client/affichageListeProduits.jsp";
                                request.setAttribute("listeProduits", listeProduits);
                            }
                        }

                        if (action.equals("rechercheFilm")) {
                            dest = "/WEB-INF/client/clientRechercherFilm.jsp";
                        }

                        if (action.equals("recherche")) {
                            if (request.getParameter("txtRecherche") != null) {
                                String recherche = request.getParameter("txtRecherche");
                                listeProduits = UtilitaireListeProduits.getListeRecherche(recherche);
                                dest = "/WEB-INF/client/clientRechercherFilm.jsp";
                                request.setAttribute("listeProduits", listeProduits);
                            }
                        }
                    }

                }
            } else {
                dest = "/index.jsp";
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
