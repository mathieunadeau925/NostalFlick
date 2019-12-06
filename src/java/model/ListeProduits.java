
package model;

import java.util.ArrayList;

public class ListeProduits extends ArrayList<Produit> {
        public void ajouterListe(Produit produit) {
        this.add(produit);
    }

    public void supprimerListe(Produit produit) {
        this.remove(produit);
    }
}
