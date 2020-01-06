package bday;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {


        FileLineReader file = new FileLineReader();

/*        on lance la lecture du fichier pour recuperer une liste
        on transforme la liste en flux que l'on filtre en fonction
        de si c'est l'anniversaire ou non
        enfin on notifie les personnes retenues
*/

        file.read()
                .stream()
                .filter(b -> BirthDayTester.isToday(b))
                .forEach(b -> Notifier.notify(b));




    }
}
