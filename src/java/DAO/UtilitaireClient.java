package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Client;
import model.ListeClients;

public class UtilitaireClient {

    public static boolean verifMdp(String mdp, int numClient) {
        boolean bonMdp = false;
        try {
            UtilConnexion.create();
            String sql = "select RTRIM(mdp) from Client where noClient = " + numClient;
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            String mdpBd = "";
            while (rs.next()) {
                mdpBd = rs.getString(1);
            }
            if (mdp.equals(mdpBd)) {
                bonMdp = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return bonMdp;
        }
    }

    public static Client getClient(int numClient) {
        Client client = null;
        try {
            UtilConnexion.create();

            String sql = "select noClient,nom,prenom,adresse,ville,codePostal,carteCredit from Client where noClient = " + numClient;

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
                client = new Client(noClient, nom, prenom, adresse, ville, codePostal, carteCredit);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return client;
        }
    }
    
        public static Client getClientAdmin(int numClient) {
        Client client = null;
        try {
            UtilConnexion.create();

            String sql = "select noClient,nom,prenom,adresse,ville,codePostal,mdp,carteCredit from Client where noClient = " + numClient;

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noClient = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String adresse = rs.getString(4);
                String ville = rs.getString(5);
                String codePostal = rs.getString(6);
                String mdp = rs.getString(7);
                String carteCredit = rs.getString(8);
                client = new Client(noClient, nom, prenom, adresse, ville, codePostal, mdp, carteCredit);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return client;
        }
    }

    public static ListeClients getListeClients() {
        ListeClients listeClients = null;
        try {
            listeClients = new ListeClients();
            UtilConnexion.create();

            String sql = "select noClient,nom,prenom,adresse,ville,codePostal,mdp,carteCredit from Client";

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noClient = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String adresse = rs.getString(4);
                String ville = rs.getString(5);
                String codePostal = rs.getString(6);
                String mdp = rs.getString(7);
                String carteCredit = rs.getString(8);
                Client client = new Client(noClient, nom, prenom, adresse, ville, codePostal, mdp, carteCredit);
                listeClients.add(client);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeClients;
        }
    }

    public static ListeClients getListeRechercheClients(String nomClient) {
        ListeClients listeClients = null;
        try {
            listeClients = new ListeClients();
            UtilConnexion.create();

            String sql = "select noClient,nom,prenom,adresse,ville,codePostal,mdp,carteCredit from Client where upper(nom) like upper('%" + nomClient + "%')";

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noClient = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String adresse = rs.getString(4);
                String ville = rs.getString(5);
                String codePostal = rs.getString(6);
                String mdp = rs.getString(7);
                String carteCredit = rs.getString(8);
                Client client = new Client(noClient, nom, prenom, adresse, ville, codePostal, mdp, carteCredit);
                listeClients.add(client);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeClients;
        }
    }

    public static void updateClient(Client client, String mdp) {
        try {
            UtilConnexion.create();
            String sql = "update client set "
                    + "nom = ?,"
                    + "prenom = ?,"
                    + "adresse = ?,"
                    + "ville = ?,"
                    + "codePostal = ?,"
                    + "mdp = ?,"
                    + "carteCredit = ?"
                    + " where noClient = ?";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, client.getNom());
            UtilConnexion.pStm.setString(2, client.getPrenom());
            UtilConnexion.pStm.setString(3, client.getAdresse());
            UtilConnexion.pStm.setString(4, client.getVille());
            UtilConnexion.pStm.setString(5, client.getCodePostal());
            UtilConnexion.pStm.setString(6, mdp);
            UtilConnexion.pStm.setString(7, client.getCarteCredit());
            UtilConnexion.pStm.setInt(8, client.getNumero());
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }

    public static boolean deleteClient(int numClient) {
        boolean clientDelete = true;
        try {
            UtilitaireCarte.deleteCarte(numClient);
            UtilConnexion.create();
            String sql = "delete from client where noClient = ?";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setInt(1, numClient);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
            ex.printStackTrace();
            clientDelete = false;
        } finally {
            UtilConnexion.close();
            return clientDelete;
        }
    }

    public static boolean verifClient(int noClient) {
        boolean clientValide = false;
        try {
            UtilConnexion.create();

            String sql = "select noClient from Client where noClient = " + noClient;
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            while (rs.next()) {
                clientValide = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return clientValide;
        }
    }
}
