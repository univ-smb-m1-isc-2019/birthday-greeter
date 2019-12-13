import java.io.*;
import java.util.ArrayList;

public class SendListReader {

    // Read the input file and return the send list in an ArrayList
    public static ArrayList<String> getSendList(String fileName) throws IOException {
        ArrayList<String> sendList = new ArrayList<>();

        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fileLine = bufferedReader.readLine();

        while(fileLine != null){
            sendList.add(fileLine);

            fileLine = bufferedReader.readLine();
        }

        bufferedReader.close();

        return sendList;
    }

}
