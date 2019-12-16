import java.util.Date;

/**
 * Classe permettant de définir un employé et implémentant l'interface Personne
 */
public class Employe implements Personne {

    /**
     * Prénom de l'employé
     */
    private String prenom;
    /**
     * Nom de l'employé
     */
    private String nom;
    /**
     * Mail de l'employé
     */
    private String mail;
    /**
     * Date de naissance de l'employé
     */
    private Date dateDeNaissance;

    /**
     * Constructeur de la classe employé
     * @param prenom Prénom de l'employé
     * @param nom Nom de l'employé
     * @param dateDeNaissance Date de naissance de l'employé
     * @param mail Mail de l'employé
     */
    public Employe(String prenom, String nom, Date dateDeNaissance, String mail) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.dateDeNaissance = dateDeNaissance;
    }

    /**
     * Méthode permettant de récupérer le prénom de l'employé
     * @return Prénom de l'employé
     */
    @Override
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Méthode permettant de récupérer le nom de l'employé
     * @return Nom de l'employé
     */
    @Override
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode permettant de récupérer le mail de l'employé
     * @return Mail de l'employé
     */
    @Override
    public String getMail() {
        return this.mail;
    }

    /**
     * Méthode permettant de récupérer la date de naissance de l'employé
     * @return Date de naissance de l'employé
     */
    @Override
    public Date getDateDeNaissance() {
        return this.dateDeNaissance;
    }
}