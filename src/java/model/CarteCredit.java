package model;

public class CarteCredit {

    private String carteCredit;
    private String date;
    private int numVerif;
    private String typeCarte;
    private int noClient;
    private String prenom;
    private String nom;

    public CarteCredit(String carteCredit, String date, int numVerif, String typeCarte, String prenom, String nom) {
        this.carteCredit = carteCredit;
        this.date = date;
        this.numVerif = numVerif;
        this.typeCarte = typeCarte;
        this.prenom = prenom;
        this.nom = nom;
    }

    
    
    public CarteCredit() {
    }

    public String getCarteCredit() {
        return carteCredit;
    }

    public void setCarteCredit(String carteCredit) {
        this.carteCredit = carteCredit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumVerif() {
        return numVerif;
    }

    public void setNumVerif(int numVerif) {
        this.numVerif = numVerif;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }

    public int getNoClient() {
        return noClient;
    }

    public void setNoClient(int noClient) {
        this.noClient = noClient;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CarteCredit(String carteCredit, String date, int numVerif, String typeCarte) {
        this.carteCredit = carteCredit;
        this.date = date;
        this.numVerif = numVerif;
        this.typeCarte = typeCarte;
        this.noClient = 0;
    }

    
        public CarteCredit(String carteCredit, int noClient, String date, int numVerif, String typeCarte) {
        this.carteCredit = carteCredit;
        this.date = date;
        this.numVerif = numVerif;
        this.typeCarte = typeCarte;
        this.noClient = noClient;
    }
        
    public CarteCredit(String carteCredit, int noClient, String date, int numVerif, String typeCarte, String prenom, String nom) {
        this.carteCredit = carteCredit;
        this.date = date;
        this.numVerif = numVerif;
        this.typeCarte = typeCarte;
        this.noClient = noClient;
        this.prenom = prenom;
        this.nom = nom;
    }

}
