package model;

import java.util.ArrayList;

public class ListeClients extends ArrayList<Client> {

    public void ajouterListe(Client client) {
        this.add(client);
    }

    public void supprimerListe(Client client) {
        this.remove(client);
    }
}
