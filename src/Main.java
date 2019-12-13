import java.text.ParseException;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

    private static final String FILE = "./res/humans.txt";

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<String> employees = SendListReader.getSendList(FILE);

        BirthdayGreeter.greetBirthday(employees);
    }
}
