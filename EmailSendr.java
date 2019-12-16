package main.java;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSendr {

    public static void sendMessage(String mailto) {

        final String username = "lucasbrign@gmail.com";
        final String password = "xxxxxx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lucasbrign@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mailto)
            );
            message.setSubject("Lucas te souhaite un Joyeux Anniversaire !");
            message.setText("Joyeux anniversaire ;) !");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}