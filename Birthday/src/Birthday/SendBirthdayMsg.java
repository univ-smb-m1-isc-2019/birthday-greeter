package Birthday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class SendBirthdayMsg extends TimerTask {
	
	static File file = new File("../humans.txt");
	static ArrayList<String[]> birthdayArray = new ArrayList<String[]>();
	public void run() {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String str;
		String[] tokens;
		try {
			while ((str = br.readLine()) != null) {
				tokens = str.split(",");//récupère les strings entre , et stock dans un tab de string
				birthdayArray.add(tokens);//ajoute ce tab à une liste
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			sendMsg();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void sendMsg() throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), Calendar.NOVEMBER, 20);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		for(String[] s: birthdayArray) {
			Date birthdayDate = simpleDateFormat.parse(s[2]);
			cal.setTime(birthdayDate);
			int birthdayMonth = cal.get(Calendar.MONTH);
			int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
			if(month == birthdayMonth && day == birthdayDay)//si 3eme bloc de la ligne de humans.txt (date) égale à la date d'aujourd'hui
				System.out.println("Joyeux anniversaire " + s[0]);//affiche msg + prénom
		}
			
	}
	

}
