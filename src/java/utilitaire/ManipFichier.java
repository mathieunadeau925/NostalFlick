package utilitaire;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.CarteCredit;

public class ManipFichier {

    private static BufferedWriter bw = null;

    public static void ecrireFichier(String fichier, CarteCredit carte) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {

            fw = new FileWriter(fichier, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            String ligne = formerLigneCSV(carte);
            out.println(ligne);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static String formerLigneCSV(CarteCredit carte) {
        return carte.getPrenom() + "|" + carte.getNom() + "|" + carte.getCarteCredit() + "|" + carte.getDate() + "|"
                + carte.getTypeCarte() + "|" + carte.getNumVerif() + "\n";
    }
}
