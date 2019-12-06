package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilitaireDecompte {

    public static void updateDecompte() {
        try {
            UtilConnexion.create();
            String sql = "update DECOMPTE set nombreUtilisateursTotal = nombreUtilisateursTotal + 1 where idDecompte = 1";
            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
        }
    }

    public static int obtenirDecompte() {
        int decompte = 0;
        try {
            UtilConnexion.create();
            String sql = "select nombreUtilisateursTotal from decompte where idDecompte = 1";
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            while (rs.next()) {
                decompte = rs.getInt("nombreUtilisateursTotal");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
            return decompte;
        }
    }
}
