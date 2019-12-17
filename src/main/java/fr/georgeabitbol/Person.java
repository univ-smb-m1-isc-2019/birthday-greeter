package fr.georgeabitbol;

public class Person {

    /**
     * Une personne est définie par son nom, prénom, date de naissance et date d'anniversaire
     */
    private String nom;
    private String prenom;
    private String[] date = new String[2];
    private String mail;


    public Person(String nom, String prenom, String date, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.date[0] = date.split("-")[1];
        this.date[1] = date.split("-")[2];
        this.mail = mail;
    }

    public String get_nom() {
        return this.nom;
    }

    public String get_prenom() {
        return this.prenom;
    }

    public String[] get_date() {
        return this.date;
    }

    public String get_mail() {
        return this.mail;
    }


}
