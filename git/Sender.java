package com.company;

import java.util.Scanner;

public class Sender {
    public static void Envoyer(Scanner myReader, String mois, String jour)  throws java.io.IOException {
        String[] splitted;
        while (myReader.hasNextLine()) {
            //sépare la ligne en tableau
            splitted = myReader.nextLine().split(",");
            //affiche le nom, prénom, date
            System.out.println(splitted[0]+" "+ splitted[1]+" "+splitted[2]);
            //test le jour et le moi en fonction des paramètres
            if(splitted[2].split("-")[1].equals(mois) && splitted[2].split("-")[2].equals(jour)){
                //envoie de mail
                System.out.println("envoie de mail à : "+splitted[3]);
            }

        }

    }
}
