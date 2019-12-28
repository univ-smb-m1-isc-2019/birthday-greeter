package exercicemaven;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    private static final String FILE_LIST_EMPLOYEES = "humans.txt";

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<String> getAllEmployees = ListEmployeesFileReader.getListEmployees(FILE_LIST_EMPLOYEES);

        BirthdayGreeter.greetEmployeesBirthday(getAllEmployees);
    }
}
