package bday;

//Notification si un anniversaire a ete valide
public class Notifier {
    public static void notify(BirthDay b) {
        System.out.println("Joyeux anniversaire "+ b.firstName);
        System.out.println("PS: Send mail to "+ b.mail);
    }
}
