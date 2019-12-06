package model;

public class Employe {

    private int numero;
    private String nom;
    private String prenom;
    private String mdp;

    public Employe(int noEmploye, String nom, String prenom) {
        this.numero = noEmploye;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Employe(int numero, String nom, String prenom, String mdp) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int noEmploye) {
        this.numero = noEmploye;
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

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

}
