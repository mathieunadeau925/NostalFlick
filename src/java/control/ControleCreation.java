package control;

import DAO.UtilitaireCreationCompte;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import model.Employe;

@WebServlet(name = "ControleCreation", urlPatterns = {"/ControleCreation"})
public class ControleCreation extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/WEB-INF/accueil/homepage.jsp";
        boolean erreur;
        try {
            if (request.getParameter("action").equals("admin")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String mdp = request.getParameter("mdp");
                Employe employe = new Employe(nom, prenom);
                int reussite = UtilitaireCreationCompte.insertEmploye(employe, mdp);

                if (reussite == 1) {
                    dest = "/WEB-INF/accueil/confirmationCreation.jsp";
                } else {
                    throw new Exception();
                }

            }
            if (request.getParameter("action").equals("client")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                String ville = request.getParameter("ville");
                String codePostal = request.getParameter("codePostal");
                String mdp = request.getParameter("mdp");
                Client client = new Client(nom, prenom, adresse, ville, codePostal);
                int reussite = UtilitaireCreationCompte.insertClient(client, mdp);

                if (reussite == 1) {
                    dest = "/WEB-INF/accueil/confirmationCreation.jsp";
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            erreur = true;
            request.setAttribute("erreur", erreur);
            dest = "/WEB-INF/accueil/creationCompte.jsp";
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(dest);
            rd.forward(request, response);
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
