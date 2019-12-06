package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Employe;

public class UtilitaireEmploye {

    public static boolean verifMdp(String mdp, int numEmploye) {
        boolean bonMdp = false;
        try {
            UtilConnexion.create();
            String sql = "select RTRIM(mdp) from Employe where noEmploye = " + numEmploye;
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
    
    public static Employe getEmploye(int numEmploye) {
        Employe employe = null;
        try {

            UtilConnexion.create();

            String sql = "select noEmploye,nom,prenom from Employe where noEmploye = " + numEmploye;

            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);

            while (rs.next()) {

                int noEmploye = rs.getInt(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                employe = new Employe(noEmploye, nom, prenom);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return employe;
        }
    }
    
        public static boolean updateEmploye(Employe employe) {
            boolean reussite = true;
        try {
            UtilConnexion.create();
            String sql = "update Employe set "
                    + "nom = ?,"
                    + "prenom = ?,"
                    + "mdp = ?"
                    + " where noEmploye = ?";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, employe.getNom());
            UtilConnexion.pStm.setString(2, employe.getPrenom());
            UtilConnexion.pStm.setString(3, employe.getMdp());
            UtilConnexion.pStm.setInt(4, employe.getNumero());
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
            reussite = false;
        } finally {
            UtilConnexion.close();
            return reussite;
        }
    }
}
