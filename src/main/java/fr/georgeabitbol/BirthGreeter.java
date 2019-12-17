package fr.georgeabitbol;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BirthGreeter {

    private ArrayList<Person> listPerson;
    private String[] today;

    public BirthGreeter() {
        Reader r = new Reader();
        listPerson = r.getList();
        this.today = today().split("/");
    }

    /**
     * recupère les personnes dont c'est l'anniversaire et les met dans une liste
     * cette liste est ensuite affiché, mais peut être récupéré pour envoyer des mails plus tard
     */
    public void getBirthday() {

        ArrayList<Person> res = new ArrayList<>();
        int i = 0;
        while (i < listPerson.size()) {

            Person p = listPerson.get(i);
            String[] date = p.get_date();

            if (today.equals(date)) {
                res.add(p);
            }

            i++;
        }
        if (res.isEmpty()) {
            System.out.println("Il n'y a pas d'anniversaire à la date d'aujourd'hui.");
        } else {
            for (i = 0; i < res.size(); i++)
                System.out.println("Joyeux anniversaire" + res.get(i).get_prenom() + " " + res.get(i).get_prenom());
        }
    }

    /**
     * renvoie la date d'aujourd'hui sous le format mois/jour
     */
    public static String today() {
        String format = "MM/dd";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        Date date = new Date();
        return formater.format(date);
    }

}

