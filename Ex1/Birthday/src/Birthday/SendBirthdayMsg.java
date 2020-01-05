package Birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TimerTask;

public class SendBirthdayMsg extends TimerTask {
	
	public void run() {
		ArrayList<String[]> birthdayArray = new ArrayList<String[]>();
		
		String str;
		String[] tokens;
		BufferedReader br = Reader.read();
		try {
			while ((str = br.readLine()) != null) {
				tokens = str.split(",");//récupère les strings entre , et stock dans un tab de string
				birthdayArray.add(tokens);//ajoute ce tab à une liste
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			MsgSender.sendMsg(birthdayArray);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
