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
    private String[] today;/*Date du jour actuel*/

    public SendEMail()
    {
        fileName = "humans.txt";/*Le fichier est à la racine du projet*/

        listToSend = new ArrayList<>();
        listFromFile = new ArrayList<>();
        readFile(fileName);/*On recupere les informations du fichier*/

        /*Recuperation de la date actuelle*/
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(now);
        today = date.split("-");
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
        setListBirthday();/*On charge la liste des personne dont c'est l'anniversaire aujourd'hui*/
        for(String s : listToSend)
            /*On envoie un mail a chacune de ces personnes*/
        {
            info = s.split(",");
            System.out.println("Bon anniversaire " + info[0] + " " + info[1]);/*Envoie de mail simule par un print*/
        }
    }

    private void setListBirthday()
        /*Procedure pour recuperer les personnes dont c'est l'anniversaire aujourd'hui*/
    {
        String[] birthday;
        for (String s : listFromFile)
            /*On parcour la liste des personnes qui etaient dans le fichier*/
        {
            birthday = (getBirthday(s)).split("-");
            if (isBirthday(birthday))
                /*Si le mois et le jour de leur anniversaire correspondent au mois et au jour actuel alors on les ajoute a la liste*/
            {
                listToSend.add(s);
            }

        }
    }

    private boolean isBirthday(String[] birthday) {
        return today[1].equals(birthday[1]) && today[2].equals(birthday[2]);
    }


    private String getBirthday(String line) {
        /*Recupere la date d'anniversaire d'une personne selon le format du fichier*/
        String[] s = line.split(",");
        return s[2];
    }




}
