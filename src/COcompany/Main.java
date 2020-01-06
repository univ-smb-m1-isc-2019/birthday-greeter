package COcompany;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Anniv> anniv;
    public static void main(String[] args) {
        anniv= new ArrayList<>();
        String file= "humans.txt";
        try {
            InputStream flux = new FileInputStream(file);
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            while ((ligne = buff.readLine()) != null) {
                anniv.add(new Anniv(ligne));
            }

            buff.close();


        } catch (Exception e) {
        }
        for(int i=0;i<anniv.size();i++) {
            if (Tester.isToday(anniv.get(i))) {
                Notif.notif(anniv.get(i));
            }
        }
    }

}
