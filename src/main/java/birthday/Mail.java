package birthday;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

final class Mail {

    // send a mail to a receiver, are given the title and the content of the mail.
    static void sendMail(User receiver, String title, String content) {

        // default sender... could be replaced by something more sophisticated.
        User sender = new User("Alexandre", "Ascenci", new Date("1998-03-24"), "nerah.master41@gmail.com");
        final String password = "23Bisphen0l";

        // mail properties.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // create a new session to connect as sender
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender.mail, password);
                    }
                });

        // last adjustments and send the mail
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender.mail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(receiver.mail)
            );
            message.setSubject(title);
            message.setText(content); // mail content

            // send
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}