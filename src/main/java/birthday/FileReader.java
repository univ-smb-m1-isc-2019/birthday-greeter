package birthday;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.io.IOUtils;

/**
 * FileReader class:
 *  - Store the content of a file with a given path.
 *  - It lets you look over its content as many times as you want.
 * It is characterized by:
 *  - The content of the file it gets at its instantiation.
 *  - The size of the content (public).
 *  - A counter that will be used to scan the content.
 *
 * @author Alexandre Ascenci
 */
class FileReader {

    private List<String> content;
    int size;
    private int counter;

    /**
     * Create an instance of FileReader class by giving the path
     * of the file. Its encoding is declared as UTF-8.
     *
     * @param path The path to the file we want to access.
     * @throws IOException If an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     *
     * @see FileReader#getContent(String, Charset)
     * @see FileReader#FileReader(String, Charset)
     * @see StandardCharsets
     *
     * @author Alexandre Ascenci
     */
    FileReader(String path) throws IOException {
        this ( path, StandardCharsets.UTF_8 );
    }

    /**
     * Create an instance of FileReader class by giving the path
     * of the file and its encoding.
     *
     * @param path The path to the file we want to access.
     * @param encoding The encoding (ie. StandardCharsets.UTF_8)
     * @throws IOException If an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     *
     * @see FileReader#getContent(String, Charset)
     * @see List
     * @see FileReader#goToBegin()
     *
     * @author Alexandre Ascenci
     */
    public FileReader(String path, Charset encoding) throws IOException {
        content = getContent ( path, encoding );
        size = content.size();
        goToBegin();
    }

    /**
     * Gets the content of a file by giving the path of this
     * one and its encoding.
     *
     * @param resourcePath The path to the file we want to access.
     * @param encoding The encoding (ie. StandardCharsets.UTF_8)
     * @return A list of strings. The content.
     * @throws IOException If an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     *
     * @see Files#readAllLines(Path, Charset)
     * @see FileSystems#getDefault()
     * @see java.nio.file.FileSystem#getPath(String, String...)
     *
     * @author Alexandre Ascenci
     */
    private List getContent (String resourcePath, Charset encoding ) throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
        assert inputStream != null;
        return IOUtils.readLines(inputStream, String.valueOf(StandardCharsets.UTF_8));
    }

    /**
     * Go back to the beginning of the content.
     * It will let you explore it more than one time.
     *
     * @author Alexandre Ascenci
     */
    void goToBegin() {
        counter = 0;
    }

    /**
     * Verify if the FileReader content has been explored until its end or not.
     *
     * @return A boolean. If we are at the end of the content.
     *
     * @see FileReader#readLine()
     *
     * @author Alexandre Ascenci
     */
    boolean endOfFile() {
        return counter == size;
    }

    /**
     * Return the next line of the content.
     *
     * @return A string. The next line of the content.
     *
     * @see FileReader#endOfFile()
     * @see List#indexOf(Object)
     *
     * @author Alexandre Ascenci
     */
    String readLine() {
        if ( !endOfFile() ) {
            return content.get( counter++ );
        } else return null;
    }

}
