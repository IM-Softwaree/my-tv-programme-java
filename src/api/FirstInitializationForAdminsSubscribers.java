package api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FirstInitializationForAdminsSubscribers {


    // KENOS CONSTRUCTOR POU KALEITE THN 1H FORA GIA ARXIKOPOIHSH
    public FirstInitializationForAdminsSubscribers() {

        //Initialization of files Admins.txt and Subscribers.txt

        //File for Admins
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Admins.txt"))) {
            // Write each line to the file
            writer.write("admin1 password1");
            writer.newLine(); // Add a new line

            writer.write("admin2 password2");
            writer.newLine(); // Add a new line
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File for Subscribers
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Subscribers.txt"))) {

            // Write each line to the file
            writer.write("user1 password1 name1 surname1");
            writer.newLine(); // Add a new line

            writer.write("user2 password2 name2 surname2");
            writer.newLine(); // Add a new line

        } catch (IOException e) {
            e.printStackTrace();
        }

        // EDW DHMIOYRGW ENA FILE "Favourites.txt" KAI VAZW MESA TYXAIA FAVOURITE GIA TOUS 2 USERS (OI GRAMMES TOU FILE "Subscribers.txt" ANTISTOIXOUN ME TIS GRAMMES TOU FILE "Favourites.txt")
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Favourites.txt"))) {

            // Write each line to the file
            writer.write("Barbie , Alice in Borderland");
            writer.newLine(); // Add a new line

            writer.write("Inception , Monk");
            writer.newLine(); // Add a new line

        } catch (IOException e) {
            e.printStackTrace();
        }

        addSubscriberViaCommandLine();
    }

    public static void addSubscriberViaCommandLine(){

        String answer;

        System.out.println("Do you want to add a subscriber? (Y/N)");
        Scanner console = new Scanner(System.in);
        do {
            answer = console.next();
        } while ((!answer.equals("Y")) && (!answer.equals("N")));
        if(answer.equals("N")){
            return;
        }
        else {
            do {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Subscribers.txt", true))) {
                    String userName;
                    do {
                        //zitaei neo onoma gia subscriber
                        System.out.println("Give userName of Subscriber : ");
                        userName = console.next();
                    } while (!PersonAdderToFile.findUsername(userName));

                    System.out.println("Give password,name and surname of Subscriber : ");
                    String password, name, surName;
                    password = console.next();
                    name = console.next();
                    surName = console.next();
                    writer.write(userName + " " + password + " " + name + " " + surName);
                    writer.newLine(); // Add a new line
                    try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("Favourites.txt", true))) {

                        System.out.println("Do you want to add a favourite Movie/Series? (Y/N)");
                        do {
                            answer = console.next();
                        } while ((!answer.equals("Y")) && (!answer.equals("N")));
                        if(answer.equals("Y")){

                            // EMFANIZW TIS TAINIES KAI RWTAW POIES APO AYTES THELEI O USER NA MPOUNE STA FAVOURITES
                            ArrayList<String> tempMovies = new ArrayList<>();

                            System.out.println("\nMovies : ");
                            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

                                // Ta diabazw apo to binary file Movies

                                while (true) {  // repeat until end of file
                                    Video temp = (Video) oos.readObject();  //read obj
                                    tempMovies.add(temp.getTitle());
                                    System.out.println(temp.getTitle() + ", ");
                                }
                            } catch (EOFException end) {
                                System.out.println("none \n");
                                System.out.println("\n(Reached the end of file)\n");

                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            do {
                                System.out.println("Which one of those Movies do you want to add to favorites : ");
                                answer = console.next();
                                boolean flag = false;
                                for (String tempStr : tempMovies){
                                    if (answer.equals(tempStr)){
                                        writer2.write(answer + ", ");
                                        flag = true;
                                    }
                                }
                                if ("none".equals(answer)){
                                    flag = true;
                                }
                                if (!flag){
                                    System.out.println("Movie isn't available or movie doesn't exist");
                                }
                                System.out.println("Do you want to add another favourite Movie? (Y/N)");
                                do {
                                    answer = console.next();
                                } while ((!answer.equals("Y")) && (!answer.equals("N")));
                            }while (answer.equals("Y"));

                            // EMFANIZW TIS SEIRES KAI RWTAW POIES APO AYTES THELEI O USER NA MPOUNE STA FAVOURITES
                            ArrayList<String> tempSeries = new ArrayList<>();

                            System.out.println("\nSeries : ");
                            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

                                // Ta diabazw apo to binary file Series

                                while (true) {  // repeat until end of file
                                    Video temp = (Video) oos.readObject();  //read obj
                                    tempSeries.add(temp.getTitle());
                                    System.out.println(temp.getTitle() + ", ");
                                }
                            } catch (EOFException end) {
                                System.out.println("none \n");
                                System.out.println("\n(Reached the end of file)\n");

                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            do {
                                System.out.println("Which one of those Series do you want to add to favorites : ");
                                answer = console.next();
                                boolean flag = false;
                                for (String tempStr : tempSeries){
                                    if (answer.equals(tempStr)){
                                        writer2.write(answer + ", ");
                                        flag = true;
                                    }
                                }
                                if ("none".equals(answer)){
                                    flag = true;
                                }
                                if (!flag){
                                    System.out.println("Serie isn't available or serie doesn't exist");
                                }
                                System.out.println("Do you want to add another favourite Serie? (Y/N)");
                                do {
                                    answer = console.next();
                                } while ((!answer.equals("Y")) && (!answer.equals("N")));
                            }while (answer.equals("Y"));

                        }
                        writer2.newLine(); // Add a new line

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Do you want to add another person? (Y/N)");
                do {
                    answer = console.next();
                } while ((!answer.equals("Y")) && (!answer.equals("N")));
            } while (answer.equals("Y"));
        }
    }

}
