package birthday;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

final class Mail {

    // send a mail to a receiver, are given the title and the content of the mail.
    static void sendMail(User receiver, String title, String content) throws IOException {
        String thisLine;
        User sender = null;
        String password = "";

        // sender configuration from file
        FileReader fileReader = new FileReader( "mail_sender.conf.txt" );

        // 1ère ligne => on récupère les données associées à l'utilisateur
        if ((thisLine = fileReader.readLine()) != null) {
            sender = new User(thisLine);

            // 2ème ligne => on récupère le mot de passe
            if ((thisLine = fileReader.readLine()) != null) {
                password = thisLine;
            }
        }

        // mail properties.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        // Corrects warning "Variable is accessed within inner class. Needs to be declared final."
        User finalSender = sender;
        String finalPassword = password;

        // create a new session to connect as sender
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        assert finalSender != null;
                        return new PasswordAuthentication(finalSender.mail, finalPassword);
                    }
                });

        // last adjustments and send the mail
        try {

            Message message = new MimeMessage(session);
            assert sender != null;
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