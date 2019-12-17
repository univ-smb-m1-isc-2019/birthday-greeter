package fr.georgeabitbol;

import java.text.SimpleDateFormat;

class DateToday {

    private String[] date;

    /**
     * renvoie la date d'aujourd'hui sous le format jour/mois
     */
    DateToday() {
        String format = "dd/MM";
        SimpleDateFormat formater = new SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        this.date = formater.format(date).split("/");
    }

    String[] get_date() {
        return date;
    }
}

