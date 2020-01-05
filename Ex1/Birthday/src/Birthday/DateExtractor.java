package Birthday;

import java.text.ParseException;
import java.util.Calendar;

public class DateExtractor {
	public static int getMonth(Calendar cal) throws ParseException {
	
		return cal.get(Calendar.MONTH);
	}
	public static int getDay(Calendar cal) throws ParseException {
		return cal.get(Calendar.DAY_OF_MONTH);
	}
}
