package fr.Birthday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MsgSender {
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static void sendMsg(ArrayList<String[]> birthdayArray) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), Calendar.NOVEMBER, 20);
		int month = DateExtractor.getMonth(cal);
		int day = DateExtractor.getDay(cal);
		
		for(String[] s: birthdayArray) {
			Date birthdayDate = simpleDateFormat.parse(s[2]);
			cal.setTime(birthdayDate);
			if(month == DateExtractor.getMonth(cal) && day == DateExtractor.getDay(cal))//si 3eme bloc de la ligne de humans.txt (date) égale à la date d'aujourd'hui
				System.out.println("Joyeux anniversaire " + s[0]);//affiche msg + prénom
		}
			
	}
}
