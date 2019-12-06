package model;

import java.util.ArrayList;

public class ListeEmployes extends ArrayList<Employe> {

    public void ajouterListe(Employe employe) {
        this.add(employe);
    }

    public void supprimerListe(Employe employe) {
        this.remove(employe);
    }
}
