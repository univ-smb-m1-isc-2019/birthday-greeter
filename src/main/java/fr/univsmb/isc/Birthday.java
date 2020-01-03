package fr.univsmb.isc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Birthday {

    private String[] today;/*Date du jour actuel*/

    public Birthday()
    {
        /*Recuperation de la date actuelle*/
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(now);
        today = date.split("-");
    }

    public ArrayList<String> setListBirthday(ArrayList<String> listFromFile)
        /*Procedure pour recuperer les personnes dont c'est l'anniversaire aujourd'hui*/
    {
        ArrayList<String> listBirthdayToday = new ArrayList<>();
        String[] birthday;
        for (String s : listFromFile)
            /*On parcour la liste des personnes qui etaient dans le fichier*/
        {
            birthday = (getBirthday(s)).split("-");
            if (isBirthday(birthday))
                /*Si c'est l'anniversaire de la personne alors on les ajoute a la liste*/
            {
                listBirthdayToday.add(s);
            }

        }
        return  listBirthdayToday;
    }

    private boolean isBirthday(String[] birthday)
    {
        /*Test si c'est l'anniversaire de la personne donnée en argument*/
        return (getMonth(today)).equals(getMonth(birthday)) && (getDay(today)).equals(getDay(birthday));
    }
    private String getDay(String[] date)
            /*retourne le jour de la date donnée en argument*/
    {
        return date[2];
    }

    private String getMonth(String[] date)
            /*retourne le mois de la date donnée en argument*/
    {
        return date[1];
    }


    private String getBirthday(String line) {
        /*Recupere la date d'anniversaire d'une personne selon le format du fichier*/
        String[] s = line.split(",");
        return s[2];
    }
}
