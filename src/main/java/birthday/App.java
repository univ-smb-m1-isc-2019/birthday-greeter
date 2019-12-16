package birthday;

import java.io.IOException;

/**
 * Verify every time if there is a birthday.
 * If it's the case, send mail to those concerned.
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String thisLine;
        User user;

        // get all users
        FileReader fileReader = new FileReader( "data/humans.txt" );
        while ((thisLine = fileReader.readLine()) != null) {
            // for each user
            user = new User(thisLine);
            // is it his birthday?
            if (user.isBirthday()) {
                // send mail
                Mail.sendMail(user, "Anniversaire.", "Joyeux anniversaire! Des gros bisous baveux....");
            } else {
                //
                System.out.println(user.firstName + " " + user.lastName + " : Not his birthday today.");
            }
        }
    }
}
