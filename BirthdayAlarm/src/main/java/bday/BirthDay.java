package bday;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Gestion des donnees:
//un prenom, un nom, un mail, une date de naissance et un pseudo
public class BirthDay {

    public String firstName;
    public String lastName;
    public String mail;
    public String[] date;
    public String pseudo;

    //on passe en parametre une ligne contenant toutes les infos separees par une virgule
    public BirthDay (String data){
        //on separe sur les virgules
        String[] dataParsed = data.split(",");

        //on recupere les infos une par une
        firstName = dataParsed[0];
        lastName = dataParsed[1];
        date = dataParsed[2].split("-");
        mail = dataParsed[3];
        pseudo = dataParsed[4];

    }

}
