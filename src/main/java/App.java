/**
 * @author org.example
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {

        File f = new File("src/main/java/humans.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        String data[];
        while ((line = br.readLine()) != null) {

            data = line.split(",");

            for (int i = 0; i < data.length; i++) {
                if (isBirthday(data[2]) && data[i] == data[2]) {
                    System.out.println("Envoi du mail à " + data[i + 1] +
                            " \nEmail content : " + data[i - 2] + "!  Joyeux Anniversaire ! ^ ^");
                }
            }
        }
        br.close();
    }

    public static Boolean isBirthday(String date) {
        String[] tabDate, tabToday;
        String day, month;

        tabDate = date.split("-");
        tabToday = today().split("/");
        month = tabDate[1];
        day = tabDate[2];
        if (day.equals(tabToday[1]) && month.equals(tabToday[0])) {
            return true;
        } else {
            return false;
        }
    }

    public static String today() {
        String format = "MM/dd";
        java.text.SimpleDateFormat SDFormat = new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        return SDFormat.format(date);
    }
}
