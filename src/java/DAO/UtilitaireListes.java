
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Employe;
import model.ListeEmployes;
import model.ListeClients;
import model.Client;

public class UtilitaireListes {

    public static ListeEmployes getListeEmployes() {
        ListeEmployes listeEmployes = new ListeEmployes();
        try {

            UtilConnexion.create();

            String sql = "select noEmploye, nom, prenom from Employe";

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {

                int noEmploye = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                listeEmployes.add(new Employe(noEmploye, nom, prenom));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeEmployes;

        }
    }

    public static ListeClients getListeClients() {
        ListeClients listeClients = new ListeClients();
        try {

            UtilConnexion.create();

            String sql = "select noClient, nom, prenom, adresse, ville, codePostal, carteCredit  from Client";

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {

                int noClient = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String adresse = rs.getString(4);
                String ville = rs.getString(5);
                String codePostal = rs.getString(6);
                String carteCredit = rs.getString(7);
                listeClients.add(new Client(noClient, nom, prenom, adresse, ville, codePostal, carteCredit));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeClients;
        }
    }
}
