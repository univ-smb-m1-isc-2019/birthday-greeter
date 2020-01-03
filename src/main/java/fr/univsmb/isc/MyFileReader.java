package fr.univsmb.isc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MyFileReader {

    public static ArrayList<String> readFile(String fileName)
        /*Fonction de lecture du fichier.
         * On considere que le fichier a ete rentre avec un format valide*/ {

        ArrayList<String> listPeople = new ArrayList<>();
        File file = new File(
                SendEMail.class.getClassLoader().getResource("humans.txt").getFile()
        );

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null)
                /*On prend chaque ligne du fichier qu'on ajoute dans la liste correspondante*/ {
                listPeople.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return listPeople;
    }
}
