package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.CarteCredit;

public class UtilitaireVerifCarteCredit {

    public static boolean verifCarte(CarteCredit carte) {
        boolean carteValide = false;
        try {
            String noCarte = carte.getCarteCredit();
            UtilConnexion.create();
            String sql = "select carteCredit, to_char(dateExp, 'YYYY-MM-DD'), numVerif, typeCarte from Carte where carteCredit = " + noCarte;
            UtilConnexion.stm = UtilConnexion.con.createStatement();
            ResultSet rs = UtilConnexion.stm.executeQuery(sql);
            CarteCredit carteBd = new CarteCredit();
            while (rs.next()) {
                carteBd.setCarteCredit(rs.getString(1));
                carteBd.setDate(rs.getString(2));
                carteBd.setNumVerif(rs.getInt(3));
                carteBd.setTypeCarte(rs.getString(4));;
            }
            if (
                    carteBd.getCarteCredit().equals(carte.getCarteCredit()) &&
                    carteBd.getNumVerif() == (carte.getNumVerif()) &&
                    carteBd.getDate().equals(carte.getDate())
               ) {
                carteValide = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erreur SQL");
        } finally {
            UtilConnexion.close();
            return carteValide;
        }
    }
}
