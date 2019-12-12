package Birthday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main (String[] args) throws IOException {

        File f = new File("C:\\Users\\maxvi\\Documents\\M1\\INFO806\\ExoMail\\humans.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        String donnee[];
        while ((line = br.readLine()) != null) {

            donnee = line.split(",");

            for (int i = 0; i < donnee.length; i++)
            {
                /** Envoi du email si c'est la date d'anniversaire **/
                if(isBirthday(donnee[2]) && donnee[i] == donnee[2]) {
                    System.out.println("Envoi du mail à " + donnee[i+1] +
                            " : Toute l'équipe vous souhaite un joyeux anniversaire !");
                }
            }
        }
        br.close();
    }

    /** Retourne la date d'aujourd'hui en format MM/dd **/
    public static String today() {
        String format = "MM/dd";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        return  formater.format( date ) ;
    }

    /** Retourne si la date passée en paramètre est la date d'aujourd'hui **/
    public static Boolean isBirthday(String date){
        String[] tabDate,tabToday;
        String day,month;

        tabDate = date.split("-");
        tabToday = today().split("/");
        month = tabDate[1];
        day = tabDate[2];
        if (day.equals(tabToday[1] ) && month.equals(tabToday[0]) ){
            return true;
        } else {
            return false;
        }
    }
}
