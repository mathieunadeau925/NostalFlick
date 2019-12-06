package control.ServletsClient;

import DAO.UtilitaireCarte;
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

@WebServlet(name = "ControleCompte", urlPatterns = {"/ControleCompte"})
public class ControleCompte extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dest = "/homepage.jsp";

        try {
            if (session.getAttribute("connected") != null) {

                if (request.getParameter("action").equals("affichageCompte")) {
                    dest = "/WEB-INF/client/compteClient.jsp";

                }

                if (request.getParameter("action").equals("update")) {
                    String codePostal = request.getParameter("codePostal");
                    if (codePostal.length() > 6) {
                        boolean cp = true;
                        request.setAttribute("cpErreur", cp);
                        dest = "/WEB-INF/client/compteClient.jsp";
                    } else {
                        String carteCredit = request.getParameter("carteCredit");
                        boolean cartePresente = UtilitaireCarte.verifCarteUnique(carteCredit);
                        if (cartePresente) {
                            Client client = (Client) session.getAttribute("client");
                            String nom = request.getParameter("nom");
                            String prenom = request.getParameter("prenom");
                            String adresse = request.getParameter("adresse");
                            String ville = request.getParameter("ville");
                            String mdp = request.getParameter("mdp");
                            client.setNom(nom);
                            client.setPrenom(prenom);
                            client.setAdresse(adresse);
                            client.setVille(ville);
                            client.setCodePostal(codePostal);
                            client.setCarteCredit(carteCredit);
                            UtilitaireClient.updateClient(client, mdp);
                            session.setAttribute("client", client);
                            dest = "/WEB-INF/client/confirmationUpdate.jsp";
                        } else {
                            boolean carteInv = !cartePresente;
                        request.setAttribute("ccErreur", carteInv);
                        dest = "/WEB-INF/client/compteClient.jsp";
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
