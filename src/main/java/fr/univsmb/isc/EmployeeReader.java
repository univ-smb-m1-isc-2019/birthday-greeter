package fr.univsmb.isc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class EmployeeReader {
    private ArrayList<Employee> list; //Liste de tableau d'elements pour chaque user

    EmployeeReader(){
        this.list=new ArrayList<>();
    }

    public ArrayList<Employee> readUserList() throws FileNotFoundException {
        String[] content;//Contiendra la liste des elements de la ligne, séparés par une virgule
        Employee employeeTemp;
        try {
            String currentDirectory = System.getProperty("user.dir");
            BufferedReader br = new BufferedReader(new FileReader(currentDirectory+"/src/main/resources/humans.txt"));


            String line;
            //Chaque ligne du fichier est de la forme Prenom,Nom,DateNaissance,Mail,PseudoGit

            while ((line = br.readLine()) != null) {//Pour chaque ligne du fichier

                content = line.split(",");//On sépare les elements aux virgules
                System.out.println(content[0]);
                employeeTemp=new Employee(content[0], content[1], content[2], content[3], content[4]);
                list.add(employeeTemp); //On ajoute a la liste des elements de chaque ligne, la ligne courante par copie
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("ça a coincé");
            System.out.println(e.toString());
        }
        return list;
    }

}
