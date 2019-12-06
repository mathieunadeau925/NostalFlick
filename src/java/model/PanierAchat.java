package model;

import java.util.ArrayList;


public class PanierAchat {
    private static ArrayList<Produit> panierAchat = new ArrayList<>();

    public static void ajouterListe(Produit produit) {
        panierAchat.add(produit);
    }

    public static void supprimerListe(Produit produit) {
        panierAchat.remove(produit);
    }
    
    public static ArrayList<Produit> getPanierAchat() {
        return panierAchat;
    }
}
