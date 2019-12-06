package model;

public class Client {
    private int numero;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String codePostal;
    private String carteCredit;
    private String mdp;

    public Client(int noClient, String nom, String prenom, String adresse, String ville, String codePostal, String carteCredit) {
        this.numero = noClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.carteCredit = carteCredit;
    }

    public Client(String nom, String prenom, String adresse, String ville, String codePostal) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Client(int numero, String nom, String prenom, String adresse, String ville, String codePostal, String mdp, String carteCredit) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.mdp = mdp;
        this.carteCredit = carteCredit;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int noClient) {
        this.numero = noClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(String carteCredit) {
        this.carteCredit = carteCredit;
    }
    
    
}
