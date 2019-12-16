import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Classe  permettant d'importer la liste des employés
 */
public class EmployeFileReader {

    /**
     * Constructeur de la classe EmployeFileReader
     */
    public EmployeFileReader() {
    }

    /**
     * Méthode permettant de récupérer la liste des employés dans un fichier .txt et de la retourner dans une ArrayList
     * @return liste des employés
     */
    public ArrayList<Employe> importListEmploye() {
        ArrayList<Employe> listEmploye = new ArrayList<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
            File file = new File("humans.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String ligne;
            while ((ligne = bufferedReader.readLine()) !=null){
                String[] splitLigne = ligne.split(",");
                listEmploye.add(new Employe(splitLigne[0], splitLigne[1], simpleDateFormat.parse(splitLigne[2].substring(5)), splitLigne[3]));
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return listEmploye;
    }
}