package bday;

import java.text.SimpleDateFormat;
import java.util.Date;

//on donne les infos d'une personne et on teste si c'est son anniversaire
public class BirthDayTester {
    public static boolean isToday(BirthDay b) {
        String[] dateToday = today().split("/"); //date actuelle
        return b.date[1].equals(dateToday[0]) && b.date[2].equals(dateToday[1]);

    }

    //recuperation de la date du jour et formatage
    public static String today() {
        String format = "MM/dd";
        SimpleDateFormat formater = new SimpleDateFormat( format );
        Date date = new Date();
        return  formater.format( date ) ;
    }
}
