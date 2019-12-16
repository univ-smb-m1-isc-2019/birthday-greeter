package birthday;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void goToBegin() throws IOException {
        String thisLine;

        FileReader fileReader = new FileReader( "data/humans.txt" );
        while ((thisLine = fileReader.readLine()) != null) {
        }
        fileReader.goToBegin();

        // If the file is not empty, we are not at the end of the file.
        assertTrue( ( fileReader.size == 0 && fileReader.endOfFile() ) || ( fileReader.size != 0 && !fileReader.endOfFile() ) );
    }

    @Test
    public void endOfFile() throws IOException {
        FileReader fileReader = new FileReader( "data/humans.txt" );

        // If the file is not empty, we are not at the end of the file.
        assertTrue( ( fileReader.size == 0 && fileReader.endOfFile() ) || ( fileReader.size != 0 && !fileReader.endOfFile() ) );
    }

    @Test
    public void readLine() throws IOException {
        String thisLine;

        FileReader fileReader = new FileReader( "data/humans.txt" );
        while ((thisLine = fileReader.readLine()) != null) {
        }

        // We are necessarily at the end of the file.
        assertTrue( fileReader.endOfFile() );
    }
}