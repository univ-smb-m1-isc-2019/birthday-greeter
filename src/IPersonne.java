import java.util.Date;


/**
 * Interface permettant de représentrer une personne.
 * @author Olivier LESAGE
 */
public interface IPersonne {
    /**
     * Méthode permettant de récuperer le prénom de la personne.
     * @return Le prénom de la personne.
     */
    String getFristName();

    /**
     * Méthode permettant de récuperer le nom de la personne.
     * @return Le nom de la personne.
     */
    String getLastName();

    /**
     * Méthode permettant de récuperer l'adresse mail de la personne.
     * @return L'adress mail de la personne.
     */
    String getMail();

    /**
     * Méthode permettant de récuperer la date de naissance de la perssonne.
     * @return La date de naissance de la personne.
     */
    Date getBirthday();

    /**
     * Méthode permettant de savoir si la date de naissance de la personne correspond a la date d'aujourd'hui.
     * @return Vrai si l'anniverssaire de la personne est aujourd'hui, faux sinon.
     */
    boolean isTodayBirthday();
}
