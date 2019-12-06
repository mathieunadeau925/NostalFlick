package model;

import java.util.ArrayList;

public class ListeCartesCredit {

    private static ArrayList<CarteCredit> listeCartesCredit = new ArrayList<>();

    public static void ajouterListe(CarteCredit carte) {
        listeCartesCredit.add(carte);
    }

    public static void supprimerListe(CarteCredit carte) {
        listeCartesCredit.remove(carte);
    }
    
    public static ArrayList<CarteCredit> getListeCartesCredit() {
        return listeCartesCredit;
    }
}