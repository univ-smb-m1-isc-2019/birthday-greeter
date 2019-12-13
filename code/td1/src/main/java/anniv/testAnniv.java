package anniv;

import java.io.*;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class testAnniv {

    public static boolean testDateAjd(String date) {
        final Date dateAjd = new Date();
        String testDate = new SimpleDateFormat("MM-dd").format(dateAjd);
        return testDate.equals(date);
    }

    public static ArrayList<String> getAnniv (String fichier) throws IOException {
        ArrayList<String> res = new ArrayList<String>(); // Create an ArrayList object
        InputStream flux = new FileInputStream(fichier);
        InputStreamReader lecture = new InputStreamReader(flux);
        BufferedReader buff = new BufferedReader(lecture);
        String ligne;
        String  testDate;
        while ((ligne = buff.readLine()) != null) {

            String[] maChaine = ligne.split(",");

            String[] anniv = maChaine[2].split("-");
            String jour = anniv[2];
            String mois = anniv[1];

            testDate = mois +"-"+ jour;
            //System.out.println(testDate);

            if (testDateAjd(testDate)){
                res.add(maChaine[3]);
            }

        }
        return res;

    }
}
