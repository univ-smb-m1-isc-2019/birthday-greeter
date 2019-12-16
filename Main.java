package main.java;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        System.out.println("Bienvenue dans le BirthdayGreeter !");
        boolean todayisbday = false;
        FileRdr data = new FileRdr(args[0]);

        for (Person var : data.getPersonList()) {
            if (var.isbirthday()) {
                System.out.println("Joyeux Anniversaire " + var.getFirstname() + " !");
                todayisbday = true;
                //!\\ Does not work //!\\
                //EmailSendr.sendMessage(var.getMail());
            }
        }
        if (!todayisbday) {
            System.out.println("Il n'y a pas d'anniversaire à souhaiter aujourd'hui !");
        }
    }
}
