package exercicemaven;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class ListEmployeesFileReader {

    /**
     * Takes a file in input, representing the employee
     * information, given the format below.
     *
     * Returns a list of Employee.
     *
     * Format for the file, on each line, there must be:
     * firstName,lastName,dateOfBirth,emailAddress
     *
     * dateOfBirth pattern : YYYY-MM-DD
     */
    public static ArrayList<Employee> getListEmployees(String fileName) throws IOException, ParseException {
        ArrayList<Employee> listEmployees = new ArrayList<>();

        File file = new File(ListEmployeesFileReader.class.getClassLoader().getResource(fileName).getFile());

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        while(line != null){
            Employee employee = new Employee(line);
            listEmployees.add(employee);

            line = bufferedReader.readLine();
        }

        return listEmployees;
    }

}
