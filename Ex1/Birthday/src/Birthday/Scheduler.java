package Birthday;

import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Scheduler {

	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		//set l'heure d'aujourd'hui � 00h00m00s
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		//cr�e un planificateur qui appel la m�thode SendBirthdayMsg(), la premi�re fois aujourd'hui, puis chaque 24h
		timer.schedule(new SendBirthdayMsg(), date.getTime(), TimeUnit.HOURS.toMillis(24));
	}
}
