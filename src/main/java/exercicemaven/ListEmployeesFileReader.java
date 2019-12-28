package exercicemaven;

import java.io.*;
import java.util.ArrayList;

public class ListEmployeesFileReader {

    /**
     * Takes a file in input given the format below.
     *
     * Returns a list of String representing the employees information.
     *
     * Format for the file, on each line, there must be:
     * firstName,lastName,dateOfBirth,emailAddress
     *
     * dateOfBirth pattern : YYYY-MM-DD
     */
    public static ArrayList<String> getListEmployees(String fileName) throws IOException {
        ArrayList<String> listEmployees = new ArrayList<>();

        File file = new File(ListEmployeesFileReader.class.getClassLoader().getResource(fileName).getFile());

        //File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        while(line != null){
            listEmployees.add(line);

            line = bufferedReader.readLine();
        }

        return listEmployees;
    }

}
