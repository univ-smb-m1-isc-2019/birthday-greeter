package bday;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/****************************************************************************/
/*                  OLD VERSION                                             */
/****************************************************************************/

public class bDayGreeter {

    InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("humans.txt");
    BufferedReader br;

    ArrayList<String[]> listUser;
    List<String> res;

    String [] data;
    String [] bDayUser;
    String [] date;
    List<BirthDay> birthDays;

    public bDayGreeter() {
        listUser = new ArrayList<>();
        res = new ArrayList<>();
        date = today().split("/");
    }

    public void alarmBDay(){
        try
        {
            br = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;
            while ((line = br.readLine()) != null) {

                data = line.split(",");
                bDayUser = data[2].split("-");

                String month = bDayUser[1];
                String day = bDayUser[2];

                if (month.equals(date[0]) && day.equals(date[1])){
                    res.add(data[0] +' '+ data[1]);
                }
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        if (res.isEmpty()) {
            System.out.println("Il n'y a pas d'anniversaire à la date d'aujourd'hui.");
        }else{
            System.out.println("Joyeux anniversaire "+ res );

        }
    }

    public static String today() {
        String format = "MM/dd";
        SimpleDateFormat formater = new SimpleDateFormat( format );
        Date date = new Date();
        return  formater.format( date ) ;
    }

}
