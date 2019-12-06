package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CarteCredit;
import model.ListeCartesCredit;
import model.Produit;

public class UtilitaireProduit {

    public static void updateInventaire(int noProduit) {
        try {

            UtilConnexion.create();

            String sql = "update produit  set qteProduit = qteProduit - 1 where noProduit = ?";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);

            UtilConnexion.pStm.setInt(1, noProduit);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }

    public static boolean updateProduit(Produit produit) {
        boolean succes = true;
        try {

            UtilConnexion.create();
            String sql = "update produit  set nomProduit = ?, lienProduit = ?, prixProduit = ?, dureeProduit = ?, qteProduit = ? where noProduit = ?";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, produit.getNomProduit());
            UtilConnexion.pStm.setString(2, produit.getLienProduit());
            UtilConnexion.pStm.setDouble(3, produit.getPrixProduit());
            UtilConnexion.pStm.setString(4, produit.getDureeProduit());
            UtilConnexion.pStm.setInt(5, produit.getQteProduit());
            UtilConnexion.pStm.setInt(6, produit.getNoProduit());
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            succes = false;
        } finally {
            UtilConnexion.close();
            return succes;
        }
    }

    public static boolean ajouterProduit(Produit produit) {
        boolean succes = true;
        try {
            UtilConnexion.create();
            String sql = "insert into produit values(produit_noProduit_seq.nextval,?,?,?,?,?)";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, produit.getNomProduit());
            UtilConnexion.pStm.setString(2, produit.getLienProduit());
            UtilConnexion.pStm.setDouble(3, produit.getPrixProduit());
            UtilConnexion.pStm.setString(4, produit.getDureeProduit());
            UtilConnexion.pStm.setInt(5, produit.getQteProduit());
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            succes = false;
        } finally {
            UtilConnexion.close();
            return succes;
        }
    }

    public static boolean deleteProduit(int noProduit) {
        boolean succes = true;
        try {
            UtilConnexion.create();
            String sql = "delete from produit where noProduit = ?";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setInt(1, noProduit);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            succes = false;
        } finally {
            UtilConnexion.close();
            return succes;
        }
    }

    public static Produit getProduit(int noProduit) {
        Produit produit = null;
        try {

            UtilConnexion.create();
            String sql = "select noProduit,nomProduit,lienProduit,prixProduit,dureeProduit,qteProduit from produit where noProduit = " + noProduit;
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            while (rs.next()) {
                int num = rs.getInt(1);
                String nomProduit = rs.getString(2);
                String lienProduit = rs.getString(3);
                double prixProduit = rs.getDouble(4);
                String dureeProduit = rs.getString(5);
                int qteProduit = rs.getInt(6);
                produit = new Produit(num, nomProduit, lienProduit, prixProduit, dureeProduit, qteProduit);
            }
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            UtilConnexion.close();
            return produit;
        }
    }
}
