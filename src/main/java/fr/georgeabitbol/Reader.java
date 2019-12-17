package fr.georgeabitbol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {

    private File file = new File("src\\ressources\\humans.txt");
    private BufferedReader br;

    private ArrayList<Person> listPers = new ArrayList<>();


    public Reader (){
        createlistPerson();
    }

    public void createlistPerson(){
        try
        {
            String[] data;
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                Person p = new Person(data[1], data[0], data[2], data[3]);
                listPers.add(p);
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getList(){
        return listPers;
    }
}
