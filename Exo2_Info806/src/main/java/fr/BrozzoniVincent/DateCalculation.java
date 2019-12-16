import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalculation {

    public static boolean CompareTodayToBirth(String birthday){
        boolean sameDate = false ;
        Date today =  new Date();
        if(dateToString(today).equals(suppressYear(birthday))){
            sameDate = true;
        }
        return sameDate;
    }

    public static String dateToString (Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        return formatter.format(date);
    }

    public static String suppressYear(String date){
        String[]parts = date.split("-");
        return parts[1]+"-"+parts[2];
    }
}
