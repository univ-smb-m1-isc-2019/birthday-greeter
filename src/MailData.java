import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MailData {
    private String firstName;
    private String lastName;
    private Calendar birthDate;
    private String mailAdress;


    /************** CONSTRUCTORS **************/

    MailData(String firstName, String lastName, Calendar birthDate, String mailAdress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.mailAdress = mailAdress;
    }

    MailData(String mailData) throws ParseException {
        String[] employeeData = mailData.split(",");

        this.firstName = employeeData[0];
        this.lastName = employeeData[1];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = simpleDateFormat.parse(employeeData[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        this.birthDate = calendar;

        this.mailAdress = employeeData[3];
    }


    /************** METHODS **************/

    private boolean isMatchMonth(Calendar calendarOne, Calendar calendarTwo){
        return calendarOne.get(Calendar.MONTH) == calendarTwo.get(Calendar.MONTH);
    }

    private boolean isMatchDay(Calendar calendarOne, Calendar calendarTwo){
        return calendarOne.get(Calendar.DAY_OF_MONTH) == calendarTwo.get(Calendar.DAY_OF_MONTH);
    }

    public boolean isBirthday(){
        Calendar dateToday = Calendar.getInstance();
        return isMatchMonth(dateToday, birthDate) && isMatchDay(dateToday, birthDate);
    }


    /************** ACCESSORS **************/

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Calendar getBirthDate(){
        return birthDate;
    }

    public String getMailAdress(){
        return mailAdress;
    }
}
