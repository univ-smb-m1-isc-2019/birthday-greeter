import java.util.ArrayList;

public class Main {
    private static MyFileReader fileReader;
    private static ArrayList<Employee> employeeArrayList;

    public static void main (String[] args){
        fileReader = new MyFileReader();
        employeeArrayList = new ArrayList<>(fileReader.ReadCreateList());
        System.out.println("Today's birthday :");
        EmailSender.findBirthdayInList(employeeArrayList);
    }
}