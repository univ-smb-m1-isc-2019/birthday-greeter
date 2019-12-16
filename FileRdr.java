package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileRdr {

    String firstname;
    String name;
    Calendar birthday;
    String mail;
    String username;
    private List<Person> PersonList;

    /**
     * @return The Object containing all the Person
     */
    public List<Person> getPersonList() {
        return PersonList;
    }

    /**
     * @param pathname
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public FileRdr(String pathname) throws FileNotFoundException, ParseException {
        File file = new File(pathname);
        Scanner sc = new Scanner(file).useDelimiter(",");
        List<Person> TmpPersonList = new ArrayList<Person>();

        /* Read the file and creates a Person obj added to a List of Person for each line */
        while (sc.hasNextLine()) {

            String[] line = sc.nextLine().split(",");
            firstname = line[0];
            name = line[1];
            Date bdaydate = new SimpleDateFormat("yyyy-MM-dd").parse(line[2]);
            birthday = Calendar.getInstance();
            birthday.setTime(bdaydate);
            mail = line[3];
            username = line[4];

            TmpPersonList.add(new Person(firstname, name, birthday, mail, username));
            this.PersonList = TmpPersonList;
        }
    }


}

