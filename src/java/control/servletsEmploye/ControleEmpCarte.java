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
import model.CarteCredit;
import model.ListeCartesCredit;

@WebServlet(name = "ControleEmpCarte", urlPatterns = {"/ControleEmpCarte"})
public class ControleEmpCarte extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("connectedEmp") != null) {
                String connectedEmp = (String) session.getAttribute("connectedEmp");
                if (connectedEmp.equals("true")) {

                    if (request.getParameter("action").equals("formCarte")) {
                        dest = "/WEB-INF/employe/formulaireAjouterCarte.jsp";
                    }
                    if (request.getParameter("action").equals("ajouterCarte")) {
                        //todo code
                        String noCarte = request.getParameter("carteCredit");
                        boolean carteUnique = UtilitaireCarte.verifCarteUnique(noCarte);
                        if (carteUnique) {
                            boolean carteInvalide = true;
                            request.setAttribute("carteInvalide", carteInvalide);
                            dest = "/WEB-INF/employe/formulaireAjouterCarte.jsp";
                        } else {
                            int noClient = Integer.parseInt(request.getParameter("noClient"));
                            boolean clientExistant = UtilitaireClient.verifClient(noClient);
                            if (!clientExistant) {
                                boolean noClientInvalide = true;
                                request.setAttribute("noClientInvalide", noClientInvalide);
                                dest = "/WEB-INF/employe/formulaireAjouterCarte.jsp";
                            } else {
                                        String typeCarte = request.getParameter("typeCarte");
                                        String dateExp = request.getParameter("dateExpiration");
                                        int noVerif = Integer.parseInt(request.getParameter("numVerif"));
                                        UtilitaireCarte.ajouterCarte(new CarteCredit(noCarte, noClient, dateExp, noVerif, typeCarte));
                                        UtilitaireCarte.getCartes();
                                        boolean carteAjoutee = true;
                                        request.setAttribute("carteAjoutee", carteAjoutee);
                                        request.setAttribute("listeCartes",ListeCartesCredit.getListeCartesCredit());
                                        dest = "/WEB-INF/employe/afficherCartes.jsp";
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
