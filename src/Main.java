import java.io.*;
import java.text.ParseException;
import java.util.List;

/**
 * Classe Main contenant le programme principal.
 */
public class Main {
    /**
     * Fonction lain.
     * @param args Argument passer au programme. (inutile)
     */
    public static void main(String[] args) {
        // On ouvre le fichier contenant les informations des Worker
        File file = new File("humans.txt");
        try {
            // On créer un BufferedReader à partir du fichier
            FileReader reader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(reader);

            // On importe les worker à partir du buffer
            List<IPersonne> list = WorkerImporter.importWorker(bufferReader);

            // Pour chaque personne ...
            for(IPersonne personne: list) {
                // Si c'est l'anniverssaire de la personne ...
                if (personne.isTodayBirthday()) {
                    // Alors on lui envoie un mail
                    sendBirthdayMailTo(personne);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WorkerSyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode static permettant d'envoyer un mail
     * @param personne La personne à qui le mail va être envoyé.
     */
    public static void sendBirthdayMailTo(IPersonne personne) {
        System.out.println("c'est l'anniversaire de : " + personne);
    }
}
