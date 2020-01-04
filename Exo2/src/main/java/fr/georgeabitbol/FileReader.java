package fr.georgeabitbol;

import java.io.*;

public class FileReader {

    public static void fileReader() {

        boolean birthdayToday = false;
        try {

            InputStream flux = new FileInputStream("humans.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);//Stocke les donnes du fichier humans.txt dans un buffer

            String line;
            String today = TodayDate.today();

            System.out.println("Date d'aujourd'hui: " + today);
            System.out.println("------------------------------------------------------------");

            while ((line = buff.readLine()) != null) {

                if(BirthdayGreeter.senderMailBirthday(line)){
                    birthdayToday = true;
                }
            }
            if (birthdayToday == false) {
                System.out.println("Pas d'anniversaire aujourd'hui! ");
            }
            buff.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
