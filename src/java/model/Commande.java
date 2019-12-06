package model;

public class Commande {

    private int noCommande;
    private int noProduit;
    private String nomProduit;
    private int noClient;
    private String nomClient;
    private String prenomClient;
    private int quantite;
    private String dateCommande;
    private double prixCommande;

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public int getNoProduit() {
        return noProduit;
    }

    public void setNoProduit(int noProduit) {
        this.noProduit = noProduit;
    }

    public int getNoClient() {
        return noClient;
    }

    public void setNoClient(int noClient) {
        this.noClient = noClient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public double getPrixCommande() {
        return prixCommande;
    }

    public void setPrixCommande(double prixCommande) {
        this.prixCommande = prixCommande;
    }

    public Commande(int noProduit, String nomProduit, int noClient, String nomClient, String prenomClient, int quantite, String dateCommande, double prixCommande) {
        this.noProduit = noProduit;
        this.nomProduit = nomProduit;
        this.noClient = noClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
        this.prixCommande = prixCommande;
    }

    public Commande(int noCommande, int noProduit, String nomProduit, int noClient, String nomClient, String prenomClient, int quantite, String dateCommande, double prixCommande) {
        this.noCommande = noCommande;
        this.noProduit = noProduit;
        this.nomProduit = nomProduit;
        this.noClient = noClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
        this.prixCommande = prixCommande;
    }

}
