package control.servletsEmploye;

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
import model.ListeClients;

@WebServlet(name = "ControleEmpClient", urlPatterns = {"/ControleEmpClient"})
public class ControleEmpClient extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            String connectedEmp = (String) session.getAttribute("connectedEmp");
            if (connectedEmp.equals("true")) {
                if (session.getAttribute("connectedEmp") != null) {
                    if (request.getParameter("action") != null) {
                        if (request.getParameter("action").equals("supprimerClient")) {
                            int numClient = Integer.parseInt(request.getParameter("noClient"));
                            boolean clientDelete = UtilitaireClient.deleteClient(numClient);
                            ListeClients listeClients = UtilitaireClient.getListeClients();
                            if (clientDelete) {
                                request.setAttribute("clientDelete", clientDelete);
                                request.setAttribute("listeClients", listeClients);
                                dest = "/WEB-INF/employe/afficherClients.jsp";
                            } else {
                                boolean echecDelete = false;
                                request.setAttribute("echecDelete", echecDelete);
                                request.setAttribute("listeClients", listeClients);
                                dest = "/WEB-INF/employe/afficherClients.jsp";
                            }
                        }
                    }

                    if (request.getParameter("action").equals("update")) {
                        String codePostal = request.getParameter("codePostal");
                        if (codePostal.length() > 6) {
                            boolean cp = true;
                            request.setAttribute("cpErreur", cp);
                            dest = "/WEB-INF/employe/afficherClient.jsp";
                        } else {
                            String carteCredit = request.getParameter("carteCredit");
                            boolean cartePresente = UtilitaireCarte.verifCarteUnique(carteCredit);
                            if (cartePresente) {
                                int num = Integer.parseInt(request.getParameter("noClient"));
                                String nom = request.getParameter("nom");
                                String prenom = request.getParameter("prenom");
                                String adresse = request.getParameter("adresse");
                                String ville = request.getParameter("ville");
                                String mdp = request.getParameter("mdp");
                                Client client = new Client(num, nom, prenom, adresse, ville, codePostal, carteCredit);
                                UtilitaireClient.updateClient(client, mdp);
                                request.setAttribute("client", client);
                                boolean reussite = true;
                                request.setAttribute("reussite", reussite);
                                dest = "/WEB-INF/employe/afficherClient.jsp";
                            } else {
                                boolean carteInv = !cartePresente;
                                request.setAttribute("ccErreur", carteInv);
                                dest = "/WEB-INF/employe/afficherClient.jsp";
                            }
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
