package AnniversaireEmployé;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class Mail {

    public static void envoiEmail(String email) {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.domaine.com");

        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");



        final String myEmail = "email@domaine.com";
        final String myPassword = "MyPassword";



        Session sess = Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(myEmail, myPassword);
                    }
                });
        try {

            Message mess = new MimeMessage(sess);
            mess.setFrom(new InternetAddress("from@domaine.com"));
            mess.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );

            mess.setSubject("Objet du Mail");
            mess.setText("Nous vous souhaitons un joyeux anniversaire !!");

            Transport.send(mess);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}





