package fr.univsmb.isc;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class SendEMail
{

    /*mvn exec:java -Dexec.mainClass="fr.univsmb.isc.SendEMail"*/
    /*git rebase puis faire le refactoring
    *
    * */




    private ArrayList<String> listToSend;/*Liste des personnes dont c'est l'anniversaire aujourd'hui*/
    private ArrayList<String> listFromFile;/*Liste de toutes les personnes du fichier*/
    private String fileName;/*Nom du fichier dans lequel sont stoquees les informations*/
    private Birthday birthday;


    public SendEMail()
    {
        fileName = "humans.txt";/*Le fichier dans le src du projet*/

        listToSend = new ArrayList<>();
        listFromFile = new ArrayList<>();

        readFile(fileName);/*On recupere les informations du fichier*/

        birthday = new Birthday();

    }

    private void readFile(String fileName)
        /*Fonction de lecture du fichier.
         * On considere que le fichier a ete rentre avec un format valide*/
    {
        File file = new File(
                SendEMail.class.getClassLoader().getResource("humans.txt").getFile()
        );

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line = br.readLine()) != null)
                /*On prend chaque ligne du fichier qu'on ajoute dans la liste correspondante*/
            {
                listFromFile.add(line);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendMails()
        /*Procedure d'envoie de mail a toutes les personnes dont c'est l'anneversaire aujourd'hui*/
    {
        String[] info;
        listToSend = birthday.setListBirthday(listFromFile);/*On charge la liste des personne dont c'est l'anniversaire aujourd'hui*/
        for(String s : listToSend)
            /*On envoie un mail a chacune de ces personnes*/
        {
            info = s.split(",");
            System.out.println("Bon anniversaire " + info[0] + " " + info[1]);/*Envoie de mail simule par un print*/
        }
    }








}
