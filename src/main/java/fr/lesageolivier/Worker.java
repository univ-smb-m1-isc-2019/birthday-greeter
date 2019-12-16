import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe représentant un employé.
 *
 * @see IPersonne
 *
 * @author Olivier LESAGE
 */
public class Worker implements IPersonne {
    /**
     * Prénom du Worker.
     */
    protected String firstName;

    /**
     * Nom du Worker.
     */
    protected String lastName;

    /**
     * Adresse mail du Worker.
     */
    protected String mail;

    /**
     * Date de naissance du Worker.
     */
    protected Date birthday;


    /**
     * Constructeur.
     *
     * @param firstName Prénom du Worker.
     * @param lastName Nom du Worker.
     * @param mail Adresse mail du Worker.
     * @param birthday Date de naissance du Worker, doit respecter le format "yyyy-MM-dd".
     *
     * @throws ParseException Exception levé si la date de naissance ne respecte pas le format "yyyy-MM-dd".
     */
    public Worker(String firstName, String lastName, String mail, String birthday) throws ParseException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;

        // Transformation de la chaine de caractère contenant la date en un objet Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.birthday = simpleDateFormat.parse(birthday);
    }

    @Override
    public boolean isTodayBirthday() {
        // Création d'objet Calendar à partir des dates
        // Cela permet de récuperer le jours et le mois des dates
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(this.birthday);

        // Vérifie si les deux mois et les deux jours correspondent
        boolean sameMonth = calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
        boolean sameDay = calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);

        return (sameDay && sameMonth);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.birthday + " " + this.mail;
    }

    @Override
    public String getFristName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

    @Override
    public Date getBirthday() {
        return this.birthday;
    }
}
