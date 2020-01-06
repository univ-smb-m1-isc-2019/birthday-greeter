package fr.univsmb.isc;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BirthdayGreeting {
    //Classe qui embarque tout le nécéssaire pour souhaiter un anniversaire depuis un fichier contenant les informations.

    private MailTools mailtool;//Utilitaire pour gérer les mails
    private ArrayList<Employee> listEmployee; //Liste de tableau d'elements pour chaque user

    private ArrayList<Employee> birthdaysToWish;//Liste des utilisateurs dont on doit souhaiter l'anniversaire
    private EmployeeReader employeeReader;


    BirthdayGreeting() {//Initialisations des variables lors de la construction
        this.mailtool = new MailTools();
        this.listEmployee = new ArrayList<>();
        this.employeeReader = new EmployeeReader();
        this.birthdaysToWish = new ArrayList<>();
    }

    public void sendMailToEmployeesIfBirthday() {
        //Check si il y a des anniversaires puis envoie les mails
        try {
            listEmployee = employeeReader.readUserList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        checkBirthdays();
        sendMailsToEmployees();
    }


    private void checkBirthdays() {
        //Regarde, pour chaque employé, si c'est son anniversaire. L'ajoute a la liste des anniversaires à souhaiter si c'est le cas
        for (Employee employee : listEmployee) {
            if (employee.isBirthday()) {
                birthdaysToWish.add(employee);
            }
        }
    }

    private void sendMailsToEmployees(){
        //Envoies les mails aux employés dont c'est l'anniversaire
        for (Employee employee : birthdaysToWish){
            mailtool.sendMail(employee.getEMail()," Bon anniversaire  "+ employee.getPrenom());
        }
    }
}






