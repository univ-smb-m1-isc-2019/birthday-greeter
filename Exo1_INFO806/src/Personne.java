import java.util.Date;

/**
 * Interface contenant les différentes méthodes de récupération des caractéristiques d'une personne
 */
public interface Personne {
    /**
     * Méthode permettant de récupérer le prénom d'une personne
     * @return prénom d'une personne
     */
    String getPrenom();

    /**
     * Méthode permettant de récupérer le nom d'une personne
     * @return nom d'une personne
     */
    String getNom();

    /**
     * Méthode permettant de récupérer l'adresse mail d'une personne
     * @return adresse mail d'une personne
     */
    String getMail();

    /**
     * Méthode permettant de récupérer la date e naissance d'une personne
     * @return la date de naissance d'une personne
     */
    Date getDateDeNaissance();

}
