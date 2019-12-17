package fr.georgeabitbol;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class BirthGreeter {

    private ArrayList<Person> listPerson;
    private String[] today;

    public BirthGreeter() {
        Reader r = new Reader();
        listPerson=r.getList();
        this.today = today().split("/");
    }

    public void getBirthday(){

        ArrayList<Person>res = new ArrayList<>();
        int i =0;
        while (i<listPerson.size()) {

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
            for ( i =0; i< res.size(); i++)
                System.out.println("Joyeux anniversaire" + res.get(i).get_prenom()+" "+ res.get(i).get_prenom());
        }
    }

    public static String today() {
        String format = "MM/dd";
        SimpleDateFormat formater = new SimpleDateFormat( format );
        Date date = new Date();
        return  formater.format( date ) ;
    }

}

