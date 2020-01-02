import java.io.*;
import java.util.ArrayList;

public class MyFileReader {

    public MyFileReader() {
    }

    public ArrayList<Employee> ReadCreateList(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
			InputStream input = this.getClass().getResourceAsStream("/humans.txt");
			InputStreamReader streamReader = new InputStreamReader(input);
            BufferedReader br = null;
            br = new BufferedReader(streamReader);
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
