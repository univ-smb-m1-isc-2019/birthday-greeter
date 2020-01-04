package fr.georgeabitbol;

public class BirthdayTest {

    private static String today = TodayDate.today();
    private static String[] arrOfToday = today.split("/");//Separe la date d'aujourdhui et la stocke dans un tableau de string.
    private static String todayMonth = arrOfToday[1];
    private static String todayDay = arrOfToday[2];


    public static boolean isBirthday(String day, String month, String name, String firstName){
        if (day.equals(todayDay) && month.equals(todayMonth)) {
            return true;
        }
        else {return false;}
    }
}
