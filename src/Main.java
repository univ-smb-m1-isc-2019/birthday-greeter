package Anniversaire;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Personne[] listePersonne = new Personne[20];
        listePersonne = RecupInfoFichier("humans.txt");
        SouhaiteAnniversaire(listePersonne);

        Scanner sc = new Scanner(System.in);
        System.out.println("TAPER 1 : Si vous voulez la liste des employer. ");
        String str = sc.nextLine();
        if(Integer.parseInt(str) == 1){
            AfficheListePersonne(listePersonne);
        }
    }

    // Fonction qui crée une date a partir du jour mois et annee (avec des entiers)
    public static Date ConvertirDateNaissance(int annee, int mois, int jour){
        return new Date(annee,mois,jour);
    }

    // Fonction qui affiche le liste des tous les employers
    public static void AfficheListePersonne(Personne[] liste){
        int i = 0;
        while(liste[i] != null){
            liste[i].AffichePersonne();
            i++;
        }
    }

    // Fonction qui souhaite le jour d'anniversaire des empoyers
    public static void SouhaiteAnniversaire(Personne[] liste){
        Boolean sohaiter = false;
        String format = "yyyy-MM-dd";
        SimpleDateFormat formater = new SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        String[] elementDate = formater.format( date ).split("-");

        int i = 0;
        while(liste[i] != null){

            if((Integer.parseInt(elementDate[1]) == (liste[i].recupDate().getMonth() + 1)) && (Integer.parseInt(elementDate[2]) == (liste[i].recupDate().getDate()))){
                System.out.println("Joyeux anniversaire " + liste[i].recupPrenom());
            }
            i++;
        }

        if(!sohaiter){
            System.out.println("Personne est d'anniversaire aujourd'hui.");
        }
    }

    // Fonction qui recupere des infos du fichier qui contient la liste des employers
    public static Personne[] RecupInfoFichier(String monFichier){
        Personne[] liste = new Personne[30];
        try{
            InputStream flux=new FileInputStream(monFichier);
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            int i = 0;
            while ((ligne=buff.readLine())!=null){
                String[] infoPersonne = ligne.split(",");
                String[] laDate = infoPersonne[2].split("-");
                Date datePersonne = ConvertirDateNaissance(Integer.parseInt(laDate[0]) - 1900,Integer.parseInt(laDate[1]) - 1,Integer.parseInt(laDate[2]));
                liste[i] =  new Personne(infoPersonne[0],infoPersonne[1],datePersonne,infoPersonne[3]);
                i++;
            }
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return liste;
    }
}
