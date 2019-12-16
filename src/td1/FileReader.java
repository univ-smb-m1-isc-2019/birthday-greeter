package td1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {

    /* Méthode "readFiles" prend un string en paramètre (le chemin vers le fichier)
    cette méthode va lire un fichier ligne par ligne et comparer les dates écrites
    dans le fichier avec "testDate", enfin elle affiche la liste des personnes
    ayant leur anniversaires aujourdh'ui
    */
    public void readFiles(String path){
        ArrayList<String> birthday = new ArrayList<String>();
        try{
            InputStream stream = new FileInputStream(path);
            InputStreamReader reader =new InputStreamReader(stream);
            BufferedReader buffer =new BufferedReader(reader);
            String line;
            String[] parsedLine;
            while ((line=buffer.readLine())!=null){
                parsedLine = line.split(",");
                // parsedLine[2] représente la date
                if (testDate(parsedLine[2])){
                    birthday.add(" Joyeux anniversaire " + parsedLine[0] + " " + parsedLine[1]);
                }
            }
            if(birthday.isEmpty()){
                birthday.add("Pas d'anniversaire aujourdhui");
            }
            showList(birthday);
            buffer.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    //Méthode "today" renvoie un string : la date d'aujourd'hui
    public String today() {
        String format = "MM/dd";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        return  formater.format( date ) ;
    }

    /*Méthode "testDate" qui prend un string en paramètre (une date)
    renvoie un boolean qui vaut true si la date est aujourdh'ui
    sinon false
    */
    private boolean testDate(String date){
        String[] parsedDate,parsedToday;
        String day,month;
        parsedToday = today().split("/");
        parsedDate = date.split("-");
        month = parsedDate[1];
        day = parsedDate[2];
        if (day.equals(parsedToday[1] ) && month.equals(parsedToday[0]) ){
            return true;
        }
        else {
            return false;
        }
    }

    //Méthode "showList" qui prend une ArrayList de string et affiche la liste
    private void showList(ArrayList<String> list){
        for (int i = 0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
