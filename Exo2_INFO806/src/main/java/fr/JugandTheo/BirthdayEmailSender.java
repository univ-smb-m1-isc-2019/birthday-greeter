import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Classe permettant de gérer l'envoi d'un mail pour l'anniversaire d'un employe
 */
public class BirthdayEmailSender {

    /**
     * Méthode permettant de récupérer l'employé et de lui envoyer un mail pour son anniversaire
     * @param listEmploye liste des employés
     * @param dateDuJour date du jour
     */
    public static void findBirthdayEmploye(ArrayList<Employe> listEmploye, Date dateDuJour) {
        Iterator<Employe> employeIterator = listEmploye.iterator();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        while (employeIterator.hasNext()) {
            Employe employe = employeIterator.next();
            if (simpleDateFormat.format(employe.getDateDeNaissance()).equals(simpleDateFormat.format(dateDuJour))) {
                sendBirthdayEmail(employe.getPrenom(),employe.getNom());
            }
        }
    }

    /**
     * Méthode permettant de définir le message du mail
     * @param prenom prenom de l'employé
     * @param nom nom de l'employé
     */
    public static void sendBirthdayEmail(String prenom, String nom) {
        String emailMessage = "";
        emailMessage += "Salut " + prenom + " " + nom + "\n";
        emailMessage += "Toute l'équipe te souhaite un joyeux anniversaire !\n";
        emailMessage += "A bientot";
        System.out.println(emailMessage);
    }
}