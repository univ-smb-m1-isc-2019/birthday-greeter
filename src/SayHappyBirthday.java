
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
//cette classe permet de créer une liste d'utilisateurs dont c'est l'anniversaire et de le leurs souhaiter
=======

>>>>>>> d0977710016580426eda65edaf7b9440223943c5
public class SayHappyBirthday  {
    public  String[] tabPersonne;

    ArrayList<String[]> UserList;
<<<<<<< HEAD
    //précision du format de la date utilisé pour les tests
    DateFormat getFormat ;
    //représentera la date actuelle
=======
    DateFormat getFormat ;
>>>>>>> d0977710016580426eda65edaf7b9440223943c5
    Date thatdate ;


    //Initialisations
    SayHappyBirthday(){
<<<<<<< HEAD
        //le format de la date précisé permet de la vérification du mois et du jour uniquement pendant les tests
=======
>>>>>>> d0977710016580426eda65edaf7b9440223943c5
        this.getFormat = new SimpleDateFormat( "MM/dd");
        this.thatdate = new Date();
        getFormat.format(thatdate) ;
        this.UserList=new  ArrayList<String[]>();

    }

<<<<<<< HEAD
  //cette méthode permet de récupérer la liste de tous les utlisateurs dont c'est l'anniversaire
    public void getPeople()  {
        //récupération du fichier contenant la liste de tous les utilisateurs avec leurs date d'anniversaire
=======

    public void getPeople()  {
>>>>>>> d0977710016580426eda65edaf7b9440223943c5
        File F= new File("./humans.txt");

        try {
            BufferedReader buff = new BufferedReader(new FileReader(F));
            String line;
            //lecture de chaque ligne du fichier
            while ((line = buff.readLine()) != null) {
                //séparation des chaines de caractères par une virgule
                tabPersonne = line.split(",");

                for (int i = 0; i < tabPersonne.length; i++)
                {
                    //récupération de la liste des personnes à qui on doit souhaiter Ze happy birkhsday
<<<<<<< HEAD
                    //en comparant la date d'aujourd'hui avec toute les date se trouvant dans le fichier humans.txt
=======
>>>>>>> d0977710016580426eda65edaf7b9440223943c5
                    if(isEqualDate(tabPersonne[2]) && tabPersonne[i] == tabPersonne[2]) {
                       UserList.add(tabPersonne);
                    }
                }
            }
            buff.close();
        }
        catch (Exception error) {
            System.out.println(error.toString());
        }

    }


    public boolean isEqualDate(String date){

        String[] UserBirthdayDate,CurrentDate;
        String day,month;

        UserBirthdayDate = date.split("-");
        CurrentDate = thatdate.toString().split("/");

        //date d'anniversaire de l'utilisateur jour/mois
        month = UserBirthdayDate[1];
        day =  UserBirthdayDate[2];

        //vérifier si c'est l'anniversaire de l'utilisateur
        if (day.equals(CurrentDate[1] ) && month.equals(CurrentDate[0]) ){
            return true;
        } else {
            return false;
        }

    }


     public void HappyBirthday(){
<<<<<<< HEAD
         //envoyer un mail à tous les utilisateurs dont c'est l'anniversaire
=======
         //envoyer un mail à tous les utilisateurs
>>>>>>> d0977710016580426eda65edaf7b9440223943c5

         for(int i = 0; i<UserList.size();i++){
             String mail = UserList.get(i)[3];
             String nom = UserList.get(i)[0];
             String prenom = UserList.get(i)[1];
            System.out.println("Envoi de mail ...."+mail+"Happy BirthDay "+nom+" "+prenom+"!");
         }
     }
     }





