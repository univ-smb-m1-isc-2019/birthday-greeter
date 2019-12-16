package fr.univ.smb.isc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void  main(String[] args){



        try {
            // Création de la date du jour ainsi que son format
            DateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String[] date_jour = form.format(date).split("-");

            String path = System.getProperty("user.dir");


            // Lecture dans un fichier
            InputStream flux = new FileInputStream(path + "/src/main/ressources/humans.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            while ((ligne = buff.readLine()) != null) {
                // Récuperation des données utiles
                String[] Chaine = ligne.split(",");

                String[] Birth = Chaine[2].split("-");

                // Test si le mois et le jour correspondent entre la date de naissance et la date du jour
                if (Integer.parseInt(Birth[1] ) == Integer.parseInt(date_jour[1])  && Integer.parseInt(Birth[2] ) == Integer.parseInt(date_jour[2])  ){
                    System.out.println( "Joyeux Anniversaire ! " + Chaine[0] +" "+ Chaine[1] );
                    //Mail.envoiEmail(Chaine[3]);
                    System.out.println( "Un mail à été envoyé à : " + Chaine[3] );

                }


            }
            buff.close();
        } catch (Exception e) {
        }


    }
}
