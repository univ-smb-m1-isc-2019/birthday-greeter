package bday;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Lecture d'un fichier ligne par ligne
public class FileLineReader {
    //on lit un fichier dans lequel on recupere les infos
    //de chaque personne presente (1 ligne = 1 personne)
    //et on cree une liste de personne avec toutes les infos
    private static BufferedReader br;
    static InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("humans.txt");
    public static List<BirthDay> bDayUser;

    public FileLineReader(){
        bDayUser = new ArrayList<>();
    }

    //a chaque ligne on ajoute un nouvel objet BirthDay (une personne et ses infos) dans une liste
    public static List<BirthDay> read() throws IOException {
        try{
            br = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;
            while( (line = br.readLine()) != null) {
               bDayUser.add(new BirthDay(line));
                          }
        } catch(IOException e) {
            e.printStackTrace();
        }
        br.close();
        return bDayUser;
    }
}
