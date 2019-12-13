package com.company;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        //récupération de mois
        DateFormat month = new SimpleDateFormat("MM");
        //récupération du jour
        DateFormat day = new SimpleDateFormat("dd");
        Date date = new Date();

        //lecture
        Scanner file = FileReader.Lire("test.txt"); //spécifier l'url du fichier human.txt

        //traitement
        Sender.Envoyer(file, month.format(date), day.format(date));


    }
}
