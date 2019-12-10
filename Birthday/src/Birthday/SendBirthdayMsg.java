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
	
	static File file = new File("F:\\M1\\infoIDE\\m1-isc-2019\\humans.txt");
	static ArrayList<String[]> birthdayArray = new ArrayList<String[]>();
	public void run() {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str;
		String[] tokens;
		try {
			while ((str = br.readLine()) != null) {
				tokens = str.split(",");
				birthdayArray.add(tokens);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendMsg();
	}
	void sendMsg() {
		Calendar cal = Calendar.getInstance();
		cal.set(1997, Calendar.NOVEMBER, 20);
		Date today = cal.getTime();
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(today/*new Date()*/);
		for(String[] s: birthdayArray)
			if(s[2].equals(date))
				System.out.println("Joyeux anniversaire " + s[0]);
	}
	

}
