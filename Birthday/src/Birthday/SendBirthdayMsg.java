package Birthday;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		sendMsg();
	}
	void sendMsg() {
		
		Calendar cal = Calendar.getInstance();
		cal.set(1997, Calendar.NOVEMBER, 20);
		Date today = cal.getTime();//set la date d'aujourd'hui au 1997-11-20
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(today/*new Date()*/);//créé un string égale à la date en format yyyy-mm-dd
		for(String[] s: birthdayArray)//pour chaque ligne
			if(s[2].equals(date))//si 3eme bloc de la ligne de humans.txt (date) égale à la date d'aujourd'hui
				System.out.println("Joyeux anniversaire " + s[0]);//affiche msg + prénom
	}
	

}
