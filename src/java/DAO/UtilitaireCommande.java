package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Commande;
import model.ListeCommandes;

public class UtilitaireCommande {
    
    public static void insertCommande(Commande commande) {
        try {
            
            UtilConnexion.create();
            
            String sql = "insert into commande values (commande_noCommande_seq.nextval,?,?,?,?,?,?,to_date(?,'YYYY-MM-DD'),?)";
            
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            
            UtilConnexion.pStm.setInt(1, commande.getNoProduit());
            UtilConnexion.pStm.setString(2, commande.getNomProduit());
            UtilConnexion.pStm.setInt(3, commande.getNoClient());
            UtilConnexion.pStm.setString(4, commande.getNomClient());
            UtilConnexion.pStm.setString(5, commande.getPrenomClient());
            UtilConnexion.pStm.setInt(6, commande.getQuantite());
            UtilConnexion.pStm.setString(7, commande.getDateCommande());
            UtilConnexion.pStm.setDouble(8, commande.getPrixCommande());
            UtilConnexion.pStm.executeUpdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }
    
    public static void getCommandes(int noClient) {
        try {
            ListeCommandes.getListeCommandes().clear();
            UtilConnexion.create();
            
            String sql = "select noCommande,noProduit,nomProduit,noClient,nomClient,prenomClient,quantite,to_char(dateCommande,'YYYY-MM-DD'),prixCommande from commande where noClient = " + noClient;
            
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            
            while (rs.next()) {
                int noCommande = rs.getInt(1);                
                int noProduit = rs.getInt(2);
                String nomProduit = rs.getString(3);
                int numClient = rs.getInt(4);
                String nomClient = rs.getString(5);
                String prenomClient = rs.getString(6);
                int qte = rs.getInt(7);
                String dateCommande = rs.getString(8);
                double prixCommande = rs.getDouble(9);
                ListeCommandes.ajouterListe(new Commande(noCommande, noProduit, nomProduit, numClient, nomClient, prenomClient, qte, dateCommande, prixCommande));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }
    
        public static void getAllCommandes() {
        try {
            ListeCommandes.getListeCommandes().clear();
            UtilConnexion.create();
            
            String sql = "select noCommande,noProduit,nomProduit,noClient,nomClient,prenomClient,quantite,to_char(dateCommande,'YYYY-MM-DD'),prixCommande from commande";
            
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            
            while (rs.next()) {
                int noCommande = rs.getInt(1);                
                int noProduit = rs.getInt(2);
                String nomProduit = rs.getString(3);
                int numClient = rs.getInt(4);
                String nomClient = rs.getString(5);
                String prenomClient = rs.getString(6);
                int qte = rs.getInt(7);
                String dateCommande = rs.getString(8);
                double prixCommande = rs.getDouble(9);
                ListeCommandes.ajouterListe(new Commande(noCommande, noProduit, nomProduit, numClient, nomClient, prenomClient, qte, dateCommande, prixCommande));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }
}
