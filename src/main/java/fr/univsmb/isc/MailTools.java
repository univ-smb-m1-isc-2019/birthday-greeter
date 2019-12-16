package fr.univsmb.isc;

public class MailTools {
    //Classe qui permet d'implémenter les outils liés aux mails de façon simple à l'extérieur de cette classe, couche d'abstraction sur la gestion de mails.

    MailTools(){
    }

    boolean sendMail(String mail, String contenu){

        //Permet d'envoyer un mail, pour le moment un simple affichage.
        try{
            System.out.println("Le mail de contenu "+contenu+" a bien été envoyé à l'adresse "+mail);
            return true;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
}
