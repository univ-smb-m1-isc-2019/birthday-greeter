package pack;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BirthdayGreeting {
    //Classe qui embarque tout le nécéssaire pour souhaiter un anniversaire depuis un fichier contenant les informations.

    private MailTools mailtool;//Utilistaire pour gérer les mails
    private ArrayList<String[]> list; //Liste de tableau d'elements pour chaque user
    private Date today ;
    private ArrayList<String[]> birthdaysToWish;//Liste des utilisateurs dont on doit souhaiter l'anniversaire

    BirthdayGreeting(){//Initialisations des variables lors de la construction
        this.mailtool= new MailTools();
        this.list=new ArrayList<>();
        this.today = new Date();
        this.birthdaysToWish= new ArrayList<>();
    }

    public void sendMailToBirthdays(){
        //Check si il y a des anniversaires puis envoie les mails
        checkBirthdays();
        sendMails();
    }


    public void checkBirthdays() {
        try{
            readUserList();//Stock la lecture du fichier dans l'attribut list.
            String currentUserDate;
            for (int i = 0; i< list.size(); i++){//Pour chaque utilisateur
                currentUserDate = list.get(i)[2];
                if(isBirthday(currentUserDate.split("-"))){//Si c'est l'anniversaire de quelqu'un
                    birthdaysToWish.add(list.get(i));//On ajoute les info de cet utilisateur à la liste des anniv à souhaiter
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }


    private void readUserList() throws FileNotFoundException {
        String[] content;//Contiendra la liste des elements de la ligne, séparés par une virgule
        try {
            BufferedReader br = new BufferedReader(new FileReader("humans.txt"));
            String line;
            //Chaque ligne du fichier est de la forme Prenom,Nom,DateNaissance,Mail,PseudoGit

            while ((line = br.readLine()) != null) {//Pour chaque ligne du fichier
                content = line.split(",");//On sépare les elements aux virgules
                list.add(content.clone()); //On ajoute a la liste des elements de chaque ligne, la ligne courante par copie
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    private boolean isBirthday(String[] date){
        //Retourne si le mois et le jour actuel correspondent a la date fournie
        return (today.getMonth()==Integer.parseInt(date[1]) && today.getDay()==Integer.parseInt(date[2]));
    }

    private void sendMails() {
        for(int i = 0; i<birthdaysToWish.size();i++){//Pour chacune des personnes dont c'est l'anniversaire, on envoie le mail
            mailtool.sendMail(birthdaysToWish.get(i)[3],"Bon anniv");
        }
    }
}
