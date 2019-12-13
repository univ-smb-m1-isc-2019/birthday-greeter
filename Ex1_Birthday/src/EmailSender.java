import java.util.ArrayList;

public class EmailSender {

    public static void findBirthdayInList(ArrayList<Employee> employeeArrayList){
        int i;
        for (i = 0 ; i< employeeArrayList.size(); i++){
            if(DateCalculation.CompareTodayToBirth(employeeArrayList.get(i).getBirthday())){
                sendEmail(employeeArrayList.get(i).getFirstName());
            }
        }
    }

    public static void sendEmail(String firstName){
        String message = "Happy birthday "+ firstName + "! I hope all your birthday wishes and dreams come true.";
        System.out.println(message);
    }
}