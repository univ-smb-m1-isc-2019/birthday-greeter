package anniv;

import java.io.*;
import java.util.ArrayList;


public class Main {

        public static void main( String[] args ) throws IOException {
            String fichier = "humans.txt";
            ArrayList<String> tabAdressee = testAnniv.getAnniv(fichier);
            if (tabAdressee.isEmpty()) {
                System.out.println("pas d'anniversaire aujourd'hui");
            }
            else{
                for (String mail : tabAdressee) {
                    System.out.println(mail);
                    SendEmailTLS.sendMessage(mail);

                }
             }



        }
}
