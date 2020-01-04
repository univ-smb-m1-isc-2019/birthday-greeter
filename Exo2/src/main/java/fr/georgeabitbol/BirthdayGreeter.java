package fr.georgeabitbol;



public class BirthdayGreeter {

    public static boolean senderMailBirthday(String line) {

        String[] arrOfStr = line.split(",");//Separe les donnes de la personne et stocke dans un tableau de string.
        String name = arrOfStr[0];
        String firstName = arrOfStr[1];
        String birthdayDate = arrOfStr[2];
        String mail = arrOfStr[3];

        String[] arrOfBirth = birthdayDate.split("-");//Separe la date d'anniversaire de la personne et la stocke dans un tableau de string.
        String birthdayMonth = arrOfBirth[1];
        String birthdayDay = arrOfBirth[2];

        //Si c'est l'anniversaire de la personne on lui envoie un mail, simuler ici en print
        if (TestBirthdayToday.isBirthday(birthdayDay, birthdayMonth, name, firstName)) {
            System.out.println("Envoie du mail d'anniversaire à " + name + " " + firstName + "!!!!!");
            System.out.println("------------------------------------------------------------");
            return true;

        } else {
            return false;
        }


    }





}
