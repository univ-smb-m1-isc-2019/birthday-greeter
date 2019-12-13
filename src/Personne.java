package Anniversaire;

import java.util.Date;

public class Personne {

    // INSTANCE
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String mail;

    // CONSTRUCTEUR
    public Personne(String prenom, String nom, Date dateNaissance, String mail){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.mail = mail;
    }

    // METHODE
    public String recupNom(){
        return this.nom;
    }
    public String recupPrenom(){
        return this.prenom;
    }
    public Date recupDate(){
        return this.dateNaissance;
    }
    public String recupMail(){
        return this.mail;
    }


    public void AffichePersonne(){
        System.out.println("Nom : " + this.nom + " | Prenom : " + this.prenom + " | Date de naissance : " + this.dateNaissance + " | Adresse mail : " + this.mail);
    }


}
