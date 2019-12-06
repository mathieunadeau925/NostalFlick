package utilitaire;

import model.PanierAchat;
import model.Produit;


public class UtilitaireGetProduit {
    public static Produit getProduit(int noProduit) {
        Produit produit = null;
        for (Produit pr : PanierAchat.getPanierAchat()) {
            if (pr.getNoProduit() == noProduit) {
                return pr;
            }
        }
        return produit;
    }
}
