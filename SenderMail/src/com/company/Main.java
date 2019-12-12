package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static String today() {
        String format = "YYYY/MM/dd";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        return  formatter.format(date) ;
    }


    public static void main(String[] args) {
        ArrayList mailsBirthday = new ArrayList();
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
                        BufferedReader buff = new BufferedReader(lecture);

                        String line;
                        String today = today();

                        System.out.println("Date d'aujourd'hui: " + today);
                        System.out.println("------------------------------------------------------------");

                        String[] arrOfToday = today.split("/");
                        String todayMonth = arrOfToday[1];
                        String todayDay = arrOfToday[2];

                        int numberBirthday = 0;

                        while ((line = buff.readLine()) != null) {

                            String[] arrOfStr = line.split(",");
                            String name = arrOfStr[0];
                            String firstName = arrOfStr[1];
                            String birthdayDate = arrOfStr[2];
                            String mail = arrOfStr[3];

                            String[] arrOfBirth = birthdayDate.split("-");
                            String birthdayMonth = arrOfBirth[1];
                            String birthdayDay = arrOfBirth[2];


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
