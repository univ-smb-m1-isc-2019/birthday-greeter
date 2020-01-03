package fr.univsmb.isc;


import java.util.ArrayList;



public class SendEMail
{

    /*mvn exec:java -Dexec.mainClass="fr.univsmb.isc.SendEMail"*/

    private ArrayList<String> listToSend;/*Liste des personnes dont c'est l'anniversaire aujourd'hui*/
    private String fileName;/*Nom du fichier dans lequel sont stoquees les informations*/



    public SendEMail()
    {
        fileName = "humans.txt";/*Le fichier dans le dossier ressource du projet*/
        ArrayList<String> listFromFile = new ArrayList<>();
        listFromFile = MyFileReader.readFile(fileName);/*On recupere les informations du fichier*/
        Birthday birthday = new Birthday();
        listToSend = birthday.setListBirthday(listFromFile);/*On charge la liste des personne dont c'est l'anniversaire aujourd'hui*/

    }

    public void sendMails()
        /*Procedure d'envoie de mail à toutes les personnes dont c'est l'anneversaire aujourd'hui*/
    {
        String[] info;
        for(String s : listToSend)
            /*On envoie un mail a chacune de ces personnes*/
        {
            info = s.split(",");
            System.out.println("Bon anniversaire " + info[0] + " " + info[1]);/*Envoie de mail simule par un print*/
        }
    }
}
