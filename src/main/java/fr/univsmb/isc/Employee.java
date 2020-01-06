package fr.univsmb.isc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private String prenom;
    private String nom;
    private String dateBirthday;
    private String [] dateBirthdayInArray;
    private String eMail;
    private String pseudo;

    private Date today; //Aujourd'hui au format date yyyy-mm-dd
    private String[] todayInArray; //Aujourd'hui qui contiendra la date après le split

    Employee(String prenom, String nom, String date, String eMail, String pseudo){
        this.prenom = prenom;
        this.nom = nom;
        this.dateBirthday=date;
        this.eMail=eMail;
        this.pseudo=pseudo;

        this.today = new Date();

        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String datetmp = dateformat.format(today);
        todayInArray = datetmp.split("-");
        dateBirthdayInArray= this.getDate().split("-");

    }

    public String getPrenom(){
        return this.prenom;
    }
    public String getNom(){
        return this.nom;
    }
    public String getEMail(){
        return this.eMail;
    }
    public String getPseudo(){
        return this.pseudo;
    }

    public boolean isBirthday(){
        //System.out.println(todayInArray[1] + " mois   " + dateBirthdayInArray[1]);
        //System.out.println(todayInArray[2] + " jours   " + dateBirthdayInArray[2]);
        return (Integer.parseInt(todayInArray[1])==Integer.parseInt(dateBirthdayInArray[1]) && Integer.parseInt(todayInArray[2])==Integer.parseInt(dateBirthdayInArray[2]));
    }

    public String getDate() {
        return this.dateBirthday;
    }
}
