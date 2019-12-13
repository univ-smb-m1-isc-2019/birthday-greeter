import java.text.ParseException;
import java.util.ArrayList;

public class BirthdayGreeter {

    private static void sendHappyBirthday(MailData mailData){
        String firstName = mailData.getFirstName();
        String lastName = mailData.getLastName();
        String mailAdress = mailData.getMailAdress();

        // Greatings are printed in the console instead of being sent by mail
        System.out.println("Happy birthday " + firstName + " " + lastName + " !");
    }

    public static void greetBirthday(ArrayList<String> greetingList) throws ParseException {
        for(String employeeData: greetingList){
            MailData mailData = new MailData(employeeData);

            if(mailData.isBirthday()){
                sendHappyBirthday(mailData);
            }
        }
    }

}