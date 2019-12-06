package control.ServletsClient;

import DAO.UtilitaireCommande;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.ListeCommandes;

@WebServlet(name = "ControleAffichageCommandes", urlPatterns = {"/ControleAffichageCommandes"})
public class ControleAffichageCommandes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        boolean commandePresente;
        try {
            if (session.getAttribute("connected") != null) {
                String connected = (String) session.getAttribute("connected");
                if (connected.equals("true")) {
                    Client client = (Client)session.getAttribute("client");
                    dest = "/WEB-INF/client/afficherCommandesClient.jsp";
                    UtilitaireCommande.getCommandes(client.getNumero());
                    if (ListeCommandes.getListeCommandes().size() == 0) {
                        commandePresente = false;
                    } else {
                        commandePresente = true;
                        request.setAttribute("listeCommandes", ListeCommandes.getListeCommandes());
                        request.setAttribute("commandePresente", commandePresente);
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
