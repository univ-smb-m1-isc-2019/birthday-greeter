import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalculation {

    public static boolean CompareTodayToBirth(String birthday){
        boolean sameDate = false ;
        Date today =  new Date();
        if(dateToString(today).equals(birthday.substring(5,10))){
            sameDate = true;
        }
        return sameDate;
    }

    public static String dateToString (Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        return formatter.format(date);
    }

}
