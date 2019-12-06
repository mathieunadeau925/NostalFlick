package control;

import DAO.UtilitaireClient;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employe;
import DAO.UtilitaireEmploye;
import javax.servlet.http.HttpSession;
import model.Client;

@WebServlet(name = "ControleAuthentification", urlPatterns = {"/ControleAuthentification"})
public class ControleAuthentification extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        String connectedS;
        String connectedEmp;
        HttpSession session = request.getSession();
        String connected = "false";

        try {
            if (session.getAttribute("connected") != null) {
                connectedS = (String) session.getAttribute("connected");
                if (connectedS.equals("true")) {
                    dest = "/WEB-INF/client/accueilClient.jsp";
                }
            } else {

                if (session.getAttribute("connectedEmp") != null) {
                    connectedEmp = (String) session.getAttribute("connectedEmp");
                    if (connectedEmp.equals("true")) {
                        dest = "/WEB-INF/employe/accueilEmploye.jsp";
                    }
                } else {

                    if (request.getParameter("mdp") != null && request.getParameter("selectPersonne") != null) {
                        String mdp = request.getParameter("mdp");
                        int numPersonne = Integer.parseInt(request.getParameter("selectPersonne"));
                        String userType = request.getParameter("userType");

                        if (userType != null) {
                            if (userType.equals("admin")) {
                                boolean mdpValide = UtilitaireEmploye.verifMdp(mdp, numPersonne);

                                if (mdpValide) {
                                    Employe employe = UtilitaireEmploye.getEmploye(numPersonne);
                                    session.setAttribute("employe", employe);
                                    connectedEmp = "true";
                                    session.setAttribute("connectedEmp", connectedEmp);
                                    dest = "/WEB-INF/employe/accueilEmploye.jsp";
                                } else {
                                    boolean mdpInvalide = true;
                                    request.setAttribute("mdpInvalide", mdpInvalide);
                                    dest = "/WEB-INF/accueil/pageConnexion.jsp";
                                }
                            }

                            if (userType.equals("client")) {
                                boolean mdpValide = UtilitaireClient.verifMdp(mdp, numPersonne);

                                if (mdpValide) {
                                    Client client = UtilitaireClient.getClient(numPersonne);
                                    session.setAttribute("client", client);
                                    connected = "true";
                                    session.setAttribute("connected", connected);
                                    dest = "/WEB-INF/client/accueilClient.jsp";
                                } else {
                                    boolean mdpInvalide = true;
                                    request.setAttribute("mdpInvalide", mdpInvalide);
                                    dest = "/WEB-INF/accueil/pageConnexion.jsp";
                                }
                            }
                        }
                    } else {
                        if (session.getAttribute("connected") != null) {
                            connectedS = (String) session.getAttribute("connected");
                            if (connectedS.equals("true")) {
                                if (request.getParameter("accueilClient") != null) {
                                    String accueilClient = request.getParameter("accueilClient");
                                    if (accueilClient.equals("true")) {
                                        dest = "/WEB-INF/client/accueilClient.jsp";
                                    }
                                }
                            }
                        } else if (session.getAttribute("connectedEmp") != null) {
                            connectedEmp = (String) session.getAttribute("connectedEmp");
                            if (connectedEmp.equals("true")) {
                                if (request.getParameter("accueilEmp") != null) {
                                    String accueilEmp = request.getParameter("accueilEmp");
                                    if (accueilEmp.equals("true")) {
                                        dest = "/WEB-INF/employe/accueilEmploye.jsp";
                                    }
                                }
                            } else {
                                dest = "/index.jsp";
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
