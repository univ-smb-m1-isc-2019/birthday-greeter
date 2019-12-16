import java.util.ArrayList;
import java.util.Date;

/**
 * Classe permettant de lancer le programme
 */
public class Main {

    /**
     * Liste des employés de l'entreprise
     */
    private static ArrayList<Employe> listEmploye;
    /**
     * Instance de la classe EmployeFileReader permettant d'importer la liste des employés
     */
    private static EmployeFileReader employeFileReader;
    /**
     * Instance de la classe Date reprenant la date du jour
     */
    private static Date dateDuJour;


    public static void main(String[] args) {
        employeFileReader = new EmployeFileReader();
        listEmploye = new ArrayList<>(employeFileReader.importListEmploye());
        dateDuJour = new Date();
        BirthdayEmailSender.findBirthdayEmploye(listEmploye, dateDuJour);
    }
}

