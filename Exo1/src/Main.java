import java.io.*;



public class Main {



    public static void main(String[] args) {

        int numberBirthday = 0;

                    try {

                        InputStream flux = new FileInputStream("humans.txt");
                        InputStreamReader lecture = new InputStreamReader(flux);
                        BufferedReader buff = new BufferedReader(lecture);//Stocke les donnes du fichier humans.txt dans un buffer

                        String line;
                        String today = TodayDate.today();

                        System.out.println("Date d'aujourd'hui: " + today);
                        System.out.println("------------------------------------------------------------");

                        String[] arrOfToday = today.split("/");//Separe la date d'aujourdhui et la stocke dans un tableau de string.
                        String todayMonth = arrOfToday[1];
                        String todayDay = arrOfToday[2];



                        while ((line = buff.readLine()) != null) {

                            String[] arrOfStr = line.split(",");//Separe les donnes de la personne et stocke dans un tableau de string.
                            String name = arrOfStr[0];
                            String firstName = arrOfStr[1];
                            String birthdayDate = arrOfStr[2];
                            String mail = arrOfStr[3];

                            String[] arrOfBirth = birthdayDate.split("-");//Separe la date d'anniversaire de la personne et la stocke dans un tableau de string.
                            String birthdayMonth = arrOfBirth[1];
                            String birthdayDay = arrOfBirth[2];

                            //Si c'est l'anniversaire de la personne on lui envoie un mail, simuler ici en print
                            if (birthdayDay.equals(todayDay) && birthdayMonth.equals(todayMonth)) {
                                System.out.println("Envoie du mail d'anniversaire à " + name + " " + firstName + "!!!!!");
                                System.out.println("------------------------------------------------------------");
                                numberBirthday++;
                            }

                        }
                        if (numberBirthday == 0 ){
                            System.out.println("Pas d'anniversaires aujourd'hui");
                        }

                        buff.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



            }
        }



