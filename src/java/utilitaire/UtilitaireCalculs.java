package utilitaire;

//import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import model.PanierAchat;
import model.Produit;

public class UtilitaireCalculs {

    private static final double TPS = 0.05;
    private static final double TVQ = 0.09975;

    public static double calculerPrixTotal(double prix) {
        prix = 0;
        if (PanierAchat.getPanierAchat().size() != 0) {
            for (Produit pr : PanierAchat.getPanierAchat()) {
                prix += pr.getPrixProduit();
            }
        }
        BigDecimal bd = new BigDecimal(prix).setScale(2, RoundingMode.HALF_UP);
        double prixArrondi = bd.doubleValue();
        return prixArrondi;
    }

    public static double calculerPrixTps(double prix) {
        double tps = 0;
        tps = prix * TPS;
        BigDecimal bd = new BigDecimal(tps).setScale(2, RoundingMode.HALF_UP);
        double tpsArrondi = bd.doubleValue();
        return tpsArrondi;
    }

    public static double calculerPrixTvq(double prix) {
        double tvq = 0;
        tvq = prix * TVQ;
        BigDecimal bd = new BigDecimal(tvq).setScale(2, RoundingMode.HALF_UP);
        double tvqArrondi = bd.doubleValue();
        return tvqArrondi;
    }

    public static double calculerPrixAvecTaxes(double prix, double tps, double tvq) {
        prix = prix + tps + tvq;
        BigDecimal bd = new BigDecimal(prix).setScale(2, RoundingMode.HALF_UP);
        double prixArrondi = bd.doubleValue();
        return prixArrondi;
    }

    public static double calculerPrixAvecTaxes(double prix) {
        double tvq = prix * TVQ;
        double tps = prix * TPS;
        prix = prix + tps + tvq;
        BigDecimal bd = new BigDecimal(prix).setScale(2, RoundingMode.HALF_UP);
        double prixArrondi = bd.doubleValue();
        return prixArrondi;
    }
}
