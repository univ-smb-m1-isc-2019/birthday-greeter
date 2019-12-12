package birthday;

import java.util.Arrays;
import java.util.List;

class User {
    // Instances variables
    String firstName, lastName, mail;
    Date birthday;

    User(String firstName, String lastName, Date birthday, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.birthday = birthday;
    }

    // format => Guillaume,Jambet,1975-11-01,guillaume.jambet@gmail.com,gjambet
    User(String str) {
        // convert a str to a list, splitting str  on a delimiter zero or more whitespace,
        // literal comma, zero or more whitespace.
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));

        // We suppose the format is respected.
        // We generate a user with the data.
        this.firstName = items.get(0);
        this.lastName = items.get(1);
        this.birthday = new Date(items.get(2));
        this.mail = items.get(3);

    }

    /* Today is the same date as his birthday? */
    boolean isBirthday() {
        return this.birthday.isSameDay();
    }

}
