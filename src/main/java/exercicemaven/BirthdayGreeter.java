package exercicemaven;

import java.text.ParseException;
import java.util.ArrayList;

public class BirthdayGreeter {

    /**
     * For each employee in the listEmployees, if it's their birthday
     * it sends an email to wish them a 'happy birthday'
     */
    public static void greetEmployeesBirthday(ArrayList<String> listEmployees) throws ParseException {
        for(String employeeInformation: listEmployees){
            Employee employee = new Employee(employeeInformation);

            if(employee.isBirthday()){
                wishHappyBirthday(employee);
            }
        }
    }

    private static void wishHappyBirthday(Employee employee){
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String emailAddress = employee.getEmailAddress();

        /////////////////
        // Send an email to the employee with the emailAddress to wish him a happy birthday
        /////////////////

        // For this exercice, it'll just print the happy birthday in the console
        System.out.println("Happy birthday " + firstName + " " + lastName + " !");
    }
}
