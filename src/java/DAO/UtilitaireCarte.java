package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CarteCredit;
import model.ListeCartesCredit;

public class UtilitaireCarte {

    public static boolean verifCarteUnique(String noCarte) {
        boolean carteValide = false;
        try {
            UtilConnexion.create();
            String sql = "select carteCredit from carte where carteCredit = " + noCarte;
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            while (rs.next()) {
                carteValide = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
            return carteValide;
        }
    }

    public static void updateCarte(String noCarte, int numero) {
        try {
            UtilConnexion.create();
            String sql = "update carte set carteCredit = ? where noClient = ?";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, noCarte);
            UtilConnexion.pStm.setInt(2, numero);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }

    public static void ajouterCarte(CarteCredit carte) {
        try {
            UtilConnexion.create();
            String sql = "insert into carte values(?,?,to_date(?, 'YYYY-MM-DD'),?,?)";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, carte.getCarteCredit());
            UtilConnexion.pStm.setInt(2, carte.getNoClient());
            UtilConnexion.pStm.setString(3, carte.getDate());
            UtilConnexion.pStm.setInt(4, carte.getNumVerif());
            UtilConnexion.pStm.setString(5, carte.getTypeCarte());
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            UtilConnexion.close();
        }
    }
    
        public static void deleteCarte(int noCarte) {
        try {
            UtilConnexion.create();
            String sql = "delete from carte where noClient = ?";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setInt(1, noCarte);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            UtilConnexion.close();
        }
    }

    public static void getCartes() {
        try {
            UtilConnexion.create();
            if (ListeCartesCredit.getListeCartesCredit().size() > 0) {
                ListeCartesCredit.getListeCartesCredit().clear();
            }
            String sql = "select ca.carteCredit, ca.noClient, to_char(ca.dateExp, 'MM-DD-YYYY'),ca.numVerif,ca.typeCarte, c.prenom, c.nom "
                    + "from carte ca "
                    + "join client c on ca.noClient = c.noClient";
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            while (rs.next()) {
                String carteCredit = rs.getString(1);
                int noClient = rs.getInt(2);
                String dateExp = rs.getString(3);
                int numVerif = rs.getInt(4);
                String typeCarte = rs.getString(5);
                String prenom = rs.getString(6);
                String nom = rs.getString(7);
                ListeCartesCredit.ajouterListe(new CarteCredit(carteCredit, noClient, dateExp, numVerif, typeCarte, prenom, nom));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }
}
