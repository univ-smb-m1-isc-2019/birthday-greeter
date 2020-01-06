package fr.univsmb.isc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){

        //System.out.println("The current working directory is " + currentDirectory);//
    //Le main embarque la fonctionnalité pour souhaiter des anniversaires. On pourrait faires d'autres actions ensuite, si on le voulait.
        BirthdayGreeting bg = new BirthdayGreeting();
        bg.sendMailToEmployeesIfBirthday();
    }
}
