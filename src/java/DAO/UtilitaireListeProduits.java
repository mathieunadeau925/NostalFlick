package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.ListeProduits;
import model.Produit;

public class UtilitaireListeProduits {

    public static ListeProduits listeProduits;
    public static Produit produit;

    public static ListeProduits getListeProduits() {
        listeProduits = new ListeProduits();
        try {
            UtilConnexion.create();

            String sql = "select * from produit";

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noProduit = rs.getInt(1);
                String nomProduit = rs.getString(2);
                String lienProduit = rs.getString(3);
                double prixProduit = rs.getDouble(4);
                String dureeProduit = rs.getString(5);
                int qteProduit = rs.getInt(6);
                listeProduits.add(new Produit(noProduit, nomProduit, lienProduit, prixProduit, dureeProduit, qteProduit));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeProduits;

        }
    }

    public static ListeProduits getListeRecherche(String nom) {
        listeProduits = new ListeProduits();
        try {
            UtilConnexion.create();

            String sql = "select * from produit where upper(nomProduit) like upper('%" + nom + "%')";

            UtilConnexion.stm = UtilConnexion.con.prepareStatement(sql);
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noProduit = rs.getInt(1);
                String nomProduit = rs.getString(2);
                String lienProduit = rs.getString(3);
                double prixProduit = rs.getDouble(4);
                String dureeProduit = rs.getString(5);
                int qteProduit = rs.getInt(6);
                listeProduits.add(new Produit(noProduit, nomProduit, lienProduit, prixProduit, dureeProduit, qteProduit));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return listeProduits;

        }
    }

    public static Produit getProduit(int no) {
        try {
            UtilConnexion.create();

            String sql = "select * from produit where noProduit = " + no;

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {
                int noProduit = rs.getInt(1);
                String nomProduit = rs.getString(2);
                String lienProduit = rs.getString(3);
                double prixProduit = rs.getDouble(4);
                String dureeProduit = rs.getString(5);
                int qteProduit = rs.getInt(6);
                produit = new Produit(noProduit, nomProduit, lienProduit, prixProduit, dureeProduit, qteProduit);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return produit;

        }
    }
}
