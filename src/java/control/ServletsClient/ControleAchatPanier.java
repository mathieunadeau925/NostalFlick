package control.ServletsClient;

import DAO.UtilitaireCommande;
import DAO.UtilitaireProduit;
import DAO.UtilitaireVerifCarteCredit;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CarteCredit;
import model.Client;
import model.Commande;
import model.ListeCommandes;
import model.PanierAchat;
import model.Produit;
import utilitaire.ManipFichier;
import utilitaire.UtilitaireCalculs;

@WebServlet(name = "ControleAchatPanier", urlPatterns = {"/ControleAchatPanier"})
public class ControleAchatPanier extends HttpServlet {

    private Client client;
    private CarteCredit carte;
    private String numCarte = "";
    private String dateExpCarte ="";
    private int numVerifCarte = 0;
    private String typeCarte = "";

    private String dest;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean carteValide = false;
        boolean carteInvalide = false;
        try {
                client = (Client) session.getAttribute("client");
                numCarte = request.getParameter("carteCredit");
                typeCarte = request.getParameter("typeCarte");
                dateExpCarte = request.getParameter("dateExpiration");
                numVerifCarte = Integer.parseInt(request.getParameter("codeSecurite"));
                carte = new CarteCredit(numCarte, dateExpCarte, numVerifCarte, typeCarte);
                
                //verif de la carte de credit
                carteValide = UtilitaireVerifCarteCredit.verifCarte(carte);

            if (carteValide) {
                ListeCommandes.getListeCommandes().clear();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String date = df.format(new Date());
                for (Produit pr : PanierAchat.getPanierAchat()) {
                    double prixTotal = UtilitaireCalculs.calculerPrixAvecTaxes(pr.getPrixProduit());
                    Commande commande = new Commande(
                            pr.getNoProduit(),
                            pr.getNomProduit(),
                            client.getNumero(),
                            client.getNom(),
                            client.getPrenom(),
                            1, //TODO acheter plusieurs produits identiques
                            date,
                            prixTotal
                    );
                    ListeCommandes.ajouterListe(commande);
                    UtilitaireCommande.insertCommande(commande);
                    UtilitaireProduit.updateInventaire(pr.getNoProduit());
                }
                request.setAttribute("commandes", ListeCommandes.getListeCommandes());
                PanierAchat.getPanierAchat().clear();
                session.removeAttribute("prixTotal");
                session.removeAttribute("prixTps");
                session.removeAttribute("prixTvq");
                session.removeAttribute("prixTotalAvecTaxes");
                session.removeAttribute("qtePanier");
                dest = "/WEB-INF/client/achatTermine.jsp";
            } else {
                carteInvalide = true;
                request.setAttribute("carteInvalide", carteInvalide);
                dest = "/WEB-INF/client/acheterPanier.jsp";
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
