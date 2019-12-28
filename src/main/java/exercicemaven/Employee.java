package exercicemaven;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private Calendar dateOfBirth;
    private String emailAddress;

    /////////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////////

    Employee(String firstName, String lastName, Calendar dateOfBirth, String emailAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }

    Employee(String employeeInformation) throws ParseException {
        String[] employee = employeeInformation.split(",");

        this.firstName = employee[0];
        this.lastName = employee[1];

        // Parse the string representing a date to a Date object with the pattern given by the SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(employee[2]);

        // Set the Calendar time with the Date Object for the dateOfBirth attribute
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.dateOfBirth = calendar;

        this.emailAddress = employee[3];
    }


    /////////////////////////////////////////////////////////
    // Methods
    /////////////////////////////////////////////////////////

    public boolean isBirthday(){
        Calendar dateOfToday = Calendar.getInstance();
        return compareMonth(dateOfToday, dateOfBirth) && compareDay(dateOfToday, dateOfBirth);
    }

    private boolean compareMonth(Calendar calendar1, Calendar calendar2){
        return calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
    }

    private boolean compareDay(Calendar calendar1, Calendar calendar2){
        return calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }


    /////////////////////////////////////////////////////////
    // Accessors
    /////////////////////////////////////////////////////////

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Calendar getDateOfBirth(){
        return dateOfBirth;
    }

    public String getEmailAddress(){
        return emailAddress;
    }



}
