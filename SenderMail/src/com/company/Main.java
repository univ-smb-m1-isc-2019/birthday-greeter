package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    //Permet de récuperer la date d'aujourdhui.
    public static String today() {
        String format = "YYYY/MM/dd";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        return  formatter.format(date) ;
    }


    public static void main(String[] args) {
        ArrayList mailsBirthday = new ArrayList();
        int numberBirthday = 0;
        Scanner sc = new Scanner(System.in);
        boolean quitter=true;
        while(quitter) {
            System.out.println("a.Recherche si anniversaire à souahiter aujourd'hui. \n");
            System.out.println("b.Liste des mails d'anniversaires à envoyer. \n");
            System.out.println("c.Envoie du ou des mails.");
            String str = sc.nextLine();

            switch (str) {

                case "a":
                    try {

                        InputStream flux = new FileInputStream("humans.txt");
                        InputStreamReader lecture = new InputStreamReader(flux);
                        BufferedReader buff = new BufferedReader(lecture);//Stocke les donnes du fichier humans.txt dans un buffer

                        String line;
                        String today = today();

                        System.out.println("Date d'aujourd'hui: " + today);
                        System.out.println("------------------------------------------------------------");

                        String[] arrOfToday = today.split("/");//Separe la date d'aujourdhui et la stocke dans un tableau de string.
                        String todayMonth = arrOfToday[1];
                        String todayDay = arrOfToday[2];



                        while ((line = buff.readLine()) != null) {

                            String[] arrOfStr = line.split(",");//Separe les donnes de la personne et stocke dans un tableau de string.
                            String name = arrOfStr[0];
                            String firstName = arrOfStr[1];
                            String birthdayDate = arrOfStr[2];
                            String mail = arrOfStr[3];

                            String[] arrOfBirth = birthdayDate.split("-");//Separe la date d'anniversaire de la personne et la stocke dans un tableau de string.
                            String birthdayMonth = arrOfBirth[1];
                            String birthdayDay = arrOfBirth[2];

                            //Si c'est l'anniversaire de la personne on l'ajoute dans la liste mailsBirthday
                            if (birthdayDay.equals(todayDay) && birthdayMonth.equals(todayMonth)) {
                                System.out.println("Envoyer un mail d'anniversaire à " + name + " " + firstName + "!!!!!");
                                System.out.println("------------------------------------------------------------");
                                mailsBirthday.add(mail);
                                numberBirthday++;
                            }

                        }
                        if (numberBirthday == 0) {
                            System.out.println("Il n'y a pas d'anniversaire à souhaiter aujourd'hui. Retente demain!");
                            System.out.println("------------------------------------------------------------");
                        } else{
                            System.out.println("Il y a "+ numberBirthday +" anniversaire(s) à souhaiter aujourd'hui.");
                            System.out.println("------------------------------------------------------------");
                        }
                        buff.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case "b":
                    if(mailsBirthday.size()!=0) {
                        System.out.println("Liste des mails d'anniversaires:");
                        for (int i = 0; i < mailsBirthday.size(); i++)
                            System.out.println(mailsBirthday.get(i));
                        System.out.println("------------------------------------------------------------");
                    } else {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Faite la recherche avant ou alors pas de mails a envoyer aujourd'hui!");
                        System.out.println("------------------------------------------------------------");
                    }
                    break;

                case "c":
                    if(mailsBirthday.size()!=0) {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Envoie des mails.");
                        System.out.println("------------------------------------------------------------");
                    } else {
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Pas d'anniversaires aujourd'hui.");
                        System.out.println("------------------------------------------------------------");
                    }
            }
        }

    }
}
