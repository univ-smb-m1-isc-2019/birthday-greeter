package fr.georgeabitbol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Reader {

    private File file = new File("src\\ressources\\humans.txt");
    private ArrayList<Person> listPers = new ArrayList<>();

    Reader() {
        createlistPerson();
    }

    /**
     * parcours le fichier humans.txt et construit une Person par ligne du fichier
     * puis la stocke dans listePers
     */
    private void createlistPerson() {
        BufferedReader br;
        try {
            String[] data;
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                Person p = new Person(data[1], data[0], data[2], data[3]);
                listPers.add(p);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Person> getList() {
        return listPers;
    }
}
