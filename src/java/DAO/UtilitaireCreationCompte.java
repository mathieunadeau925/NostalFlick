package DAO;

import java.sql.SQLException;
import model.Client;
import model.Employe;

public class UtilitaireCreationCompte {

    public static int insertClient(Client client, String mdp) {
        int res = 0;
        try {
            UtilConnexion.create();
            String sql = "insert into client values (client_noClient_seq.nextval,?,?,?,?,?,?, '1234123412341234')";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, client.getNom());
            UtilConnexion.pStm.setString(2, client.getPrenom());
            UtilConnexion.pStm.setString(3, client.getAdresse());
            UtilConnexion.pStm.setString(4, client.getVille());
            UtilConnexion.pStm.setString(5, client.getCodePostal());
            UtilConnexion.pStm.setString(6, mdp);
            res = UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
            return res;
        }
    }

    public static int insertEmploye(Employe employe, String mdp) {
        int res = 0;
        try {
            UtilConnexion.create();
            String sql = "insert into employe values (employe_noEmploye_seq.nextval,?,?,?)";

            UtilConnexion.pStm = UtilConnexion.con.prepareStatement(sql);
            UtilConnexion.pStm.setString(1, employe.getNom());
            UtilConnexion.pStm.setString(2, employe.getPrenom());
            UtilConnexion.pStm.setString(3, mdp);
            res = UtilConnexion.pStm.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur sql");
        } finally {
            UtilConnexion.close();
            return res;
        }
    }
}
