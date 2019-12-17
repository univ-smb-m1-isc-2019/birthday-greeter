package fr.georgeabitbol;

import java.util.ArrayList;

class BirthGreeter {

    private ArrayList<Person> listPerson;
    private String[] today;

    BirthGreeter() {
        Reader r = new Reader();
        listPerson = r.getList();
        DateToday d = new DateToday();
        this.today = d.get_date();
    }

    /**
     * recupère les personnes dont c'est l'anniversaire et les met dans une liste
     * cette liste est ensuite affiché, mais peut être récupéré pour envoyer des mails plus tard
     */
    void getBirthday() {

        ArrayList<Person> res = new ArrayList<>();
        int i = 0;
        while (i < listPerson.size()) {

            Person p = listPerson.get(i);
            String[] date = p.get_date();

            if (today[0].equals(date[0]) && today[1].equals(date[1])) {
                res.add(p);
            }

            i++;
        }
        if (res.isEmpty()) {
            System.out.println("Il n'y a pas d'anniversaire à la date d'aujourd'hui.");
        } else {
            for (i = 0; i < res.size(); i++)
                System.out.println("Joyeux anniversaire " + res.get(i).get_prenom() + " " + res.get(i).get_nom());
        }
    }
}

