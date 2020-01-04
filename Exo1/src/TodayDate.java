public class TodayDate {
    //Permet de récuperer la date d'aujourdhui.
    public static String today() {
        String format = "YYYY/MM/dd";
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        return  formatter.format(date) ;
    }
}
