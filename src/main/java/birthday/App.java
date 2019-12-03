package birthday;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String thisLine;

        FileReader fileReader = new FileReader( "humans.txt" );
        while ((thisLine = fileReader.readLine()) != null) {
            System.out.println(thisLine);
        }
    }
}
