package model;

import java.util.ArrayList;

public class ListeCommandes {

    private static ArrayList<Commande> listeCommandes = new ArrayList<>();

    public static void ajouterListe(Commande commande) {
        listeCommandes.add(commande);
    }

    public static void supprimerListe(Commande commande) {
        listeCommandes.remove(commande);
    }
    
    public static ArrayList<Commande> getListeCommandes() {
        return listeCommandes;
    }
}
