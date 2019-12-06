package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe pour créer une connexion à une base de données.
 * @author 1995046
 */
public class UtilConnexion {

    //objet de connexion
    public static Connection con = null;
    //objet de statement, pour les querys
    public static Statement stm = null;
    //result set pour le retour des select
    public static ResultSet rs = null;
    //objet preparedStatement pour les update/delete/insert
    public static PreparedStatement pStm = null;

    public static void create() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection(
                "jdbc:oracle:thin:@144.217.163.57:1521:XE",
                "nadeau", "anypw");
    }

    /**
     * Méthode de fermeture d'une connexion à la base de données.
     */
    public static void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                /* ignored */
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                /* ignored */
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                /* ignored */
            }
        }
    }
}