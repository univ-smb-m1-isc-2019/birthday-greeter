import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe peremettant d'importer des Worker.
 */
public class WorkerImporter {
    /**
     * Méthode static permettant de créer une liste de Worker à partir d'une BufferedReader.
     *
     * Cela permet de créer une liste de Worker à partir d'un fichier par exemple.
     * Le fichier doit contenir sur chaque ligne les informations d'un Worker.
     * La {@link #createWorkerFromString(String) méthode createWorkerFromString} seras appelée sur chaque ligne lu dans le buffer.
     *
     * @see Worker
     * @see BufferedReader
     *
     * @param buffer Buffer à partir du quel les informations des Worker vont être récuerées.
     * @return Une liste contenant tous les Worker contenues dans le buffer.
     * @throws IOException Exception levé si il y'a une erreur lors de la lecture du biffer.
     * @throws WorkerSyntaxException Exception lever par la {@link #createWorkerFromString(String) méthode createWorkerFromString}.
     * @throws ParseException Exception lever par la {@link #createWorkerFromString(String) méthode createWorkerFromString}.
     * 
     * @see #createWorkerFromString(String)
     */
    public static List<IPersonne> importWorker(BufferedReader buffer) throws IOException, WorkerSyntaxException, ParseException {
        List<IPersonne> list = new ArrayList<>(0);

        // Pour chaque ligne du buffer ...
        String line;
        while ((line = buffer.readLine()) != null)
            // On créer un Worker
            list.add(WorkerImporter.createWorkerFromString(line));

        return list;
    }

    /**
     * Méthode static permettande de créer un Worker depuis une String.
     * La String doit respecter le format suivant :
     * <br><prénom>,<nom>,<date de naissance>,<mail>,<pseudo github></br>
     *
     * @param text La String contenant les informations du Worker.
     * @return Un Worker correspondant aux informations contenu dans la String.
     * @throws ParseException Excpetion levé par la {@link Worker class Worker}.
     * @throws WorkerSyntaxException Exception levé si la la String est mal formée.
     */
    public static Worker createWorkerFromString(String text) throws ParseException, WorkerSyntaxException {
        // Découpe la ligne aux niveau de chaque virgule
        // Cela permet de récuperer chaque informations.
        String attrs[] = text.split(",");

        // Si il y'a au moins quatre informations ...
        if (attrs.length >= 4)
            return new Worker(attrs[0], attrs[1], attrs[3], attrs[2]);
        // Sinon lève une exception car la ligne est mal formée
        else
            throw new WorkerSyntaxException();
    }
}
