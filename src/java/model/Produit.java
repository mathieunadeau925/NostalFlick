package model;

public class Produit {
    private int noProduit;
    private String nomProduit;
    private String lienProduit;
    private double prixProduit;
    private String dureeProduit;
    private int qteProduit;

    public Produit(int noProduit, String nomProduit, String lienProduit, double prixProduit, String dureeProduit, int qteProduit) {
        this.noProduit = noProduit;
        this.nomProduit = nomProduit;
        this.lienProduit = lienProduit;
        this.prixProduit = prixProduit;
        this.dureeProduit = dureeProduit;
        this.qteProduit = qteProduit;
    }

    public Produit(String nomProduit, String lienProduit, double prixProduit, String dureeProduit, int qteProduit) {
        this.nomProduit = nomProduit;
        this.lienProduit = lienProduit;
        this.prixProduit = prixProduit;
        this.dureeProduit = dureeProduit;
        this.qteProduit = qteProduit;
    }

    
    
    public String getLienProduit() {
        return lienProduit;
    }

    public void setLienProduit(String lienProduit) {
        this.lienProduit = lienProduit;
    }

    
    public int getNoProduit() {
        return noProduit;
    }

    public void setNoProduit(int noProduit) {
        this.noProduit = noProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getDureeProduit() {
        return dureeProduit;
    }

    public void setDureeProduit(String dureeProduit) {
        this.dureeProduit = dureeProduit;
    }

    public int getQteProduit() {
        return qteProduit;
    }

    public void setQteProduit(int qteProduit) {
        this.qteProduit = qteProduit;
    }

    @Override
    public String toString() {
        return  nomProduit + ", Prix:" + prixProduit + ", duree :" + dureeProduit + ", Quantité en stock:" + qteProduit;
    }
    
    
    
    
}
