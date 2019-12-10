package Birthday;

import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Scheduler {

	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		timer.schedule(new SendBirthdayMsg(), date.getTime(), TimeUnit.HOURS.toMillis(24));
	}
}
