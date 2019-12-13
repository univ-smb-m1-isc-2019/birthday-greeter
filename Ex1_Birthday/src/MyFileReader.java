import java.io.*;
import java.util.ArrayList;

public class MyFileReader {

    public MyFileReader() {
    }

    public ArrayList<Employee> ReadCreateList(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            File file = new File("humans.txt");

            BufferedReader br = null;
            br = new BufferedReader(new FileReader(file));
            String st ;
            while ((st = br.readLine()) != null) {
                String[] parts = st.split(",");
                Employee employee = new Employee(parts[0] , parts[1] , parts[3] ,parts[2] );
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}