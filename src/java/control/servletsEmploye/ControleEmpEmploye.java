package control.servletsEmploye;

import DAO.UtilitaireEmploye;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Employe;

@WebServlet(name = "ControleEmpEmploye", urlPatterns = {"/ControleEmpEmploye"})
public class ControleEmpEmploye extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dest = "/index.jsp";
        HttpSession session = request.getSession();
        try {
            String connectedEmp = (String) session.getAttribute("connectedEmp");
            if (connectedEmp.equals("true")) {
                if (session.getAttribute("connectedEmp") != null) {
                    if (request.getParameter("action") != null) {
                        if (request.getParameter("action").equals("update")) {
                            int noEmp = Integer.parseInt(request.getParameter("numero"));
                            String nom = request.getParameter("nom");
                            String prenom = request.getParameter("prenom");
                            String mdp = request.getParameter("mdp");
                            
                            Employe employe = new Employe(noEmp,nom,prenom,mdp);
                            boolean reussite = UtilitaireEmploye.updateEmploye(employe);
                            if (reussite) {
                                request.setAttribute("reussite", reussite);
                                session.setAttribute("employe", employe);
                            } else {
                                boolean echec = true;
                                request.setAttribute("echec", echec);
                            }
                        }
                    }
                    dest = "/WEB-INF/employe/afficherEmploye.jsp";
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
                
        
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
