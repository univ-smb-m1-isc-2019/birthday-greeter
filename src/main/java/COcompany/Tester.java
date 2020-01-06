package COcompany;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tester {
    public static boolean isToday (Anniv A){
    String[] today=Aujourdhui();
    return A.date[1].equals(today[1]) && A.date[2].equals(today[2]);

}

    public static String[] Aujourdhui(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String[] date_act=format.format(date).split("-");
        return date_act;
    }
}
