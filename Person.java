package main.java;

import java.util.Calendar;
import java.util.Date;

public class Person {
    String firstname;
    String name;
    Calendar birthday;
    String mail;
    String username;

    /**
     * @return FirstName
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return BirthDate
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * @return Email
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Boolean that tell if today is the Bday of the Person
     */
    public boolean isbirthday() {
        Calendar today = Calendar.getInstance();
        if (this.getBirthday().get(Calendar.MONTH) == today.get(Calendar.MONTH) && this.getBirthday().get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else return false;
    }

    /**
     * @param firstname
     * @param name
     * @param birthday
     * @param mail
     * @param username
     */
    public Person(String firstname, String name, Calendar birthday, String mail, String username) {
        this.firstname = firstname;
        this.name = name;
        this.birthday = birthday;
        this.mail = mail;
        this.username = username;
    }
}
