package api;

import java.io.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class PersonAdderToFile {
    private String filenameForSubscribers;
    public PersonAdderToFile(String filenameForSubscribers) {
        this.filenameForSubscribers = filenameForSubscribers;
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
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForSubscribers, true))) {
                    String userName;
                    do {
                        //zitaei neo onoma gia subscriber
                        System.out.println("Give userName of Subscriber : ");
                        userName = console.next();
                    } while (!findUsername(userName));

                    System.out.println("Give password,name and surname of Subscriber : ");
                    String password, name, surName;
                    password = console.next();
                    name = console.next();
                    surName = console.next();
                    writer.write(userName + " " + password + " " + name + " " + surName);
                    writer.newLine(); // Add a new line
                    try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("Favourites.txt"))) {

                        System.out.println("Do you want to add a favourite Movie/Series? (Y/N)");
                        do {
                            answer = console.next();
                        } while ((!answer.equals("Y")) && (!answer.equals("N")));
                        if(answer.equals("Y")){

                            // EMFANIZW TIS TAINIES KAI RWTAW POIES APO AYTES THELEI O USER NA MPOUNE STA FAVOURITES
                            ArrayList<String> tempMovies = new ArrayList<>();

                            System.out.println("Movies : ");
                            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Movies.dat"))) {

                                // Ta diabazw apo to binary file Movies

                                while (true) {  // repeat until end of file
                                    Video temp = (Video) oos.readObject();  //read obj
                                    tempMovies.add(temp.getTitle());
                                    System.out.println(temp.getTitle() + ", ");
                                }
                            } catch (EOFException end) {
                                System.out.println("Reached the end of file");

                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            do {
                                System.out.println("Which of those Movies do you want : ");
                                answer = console.next();
                                for (String tempStr : tempMovies){
                                    if (answer.equals(tempStr)){
                                        writer2.write(answer + ", ");
                                    }
                                }
                                System.out.println("Do you want to add another favourite Movie? (Y/N)");
                                do {
                                    answer = console.next();
                                } while ((!answer.equals("Y")) && (!answer.equals("N")));
                            }while (answer.equals("Y"));

                            // EMFANIZW TIS SEIRES KAI RWTAW POIES APO AYTES THELEI O USER NA MPOUNE STA FAVOURITES
                            ArrayList<String> tempSeries = new ArrayList<>();

                            System.out.println("Series : ");
                            try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Series.dat"))) {

                                // Ta diabazw apo to binary file Series

                                while (true) {  // repeat until end of file
                                    Video temp = (Video) oos.readObject();  //read obj
                                    tempSeries.add(temp.getTitle());
                                    System.out.println(temp.getTitle() + ", ");
                                }
                            } catch (EOFException end) {
                                System.out.println("Reached the end of file");

                            } catch (IOException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            do {
                                System.out.println("Which of those Movies do you want : ");
                                answer = console.next();
                                for (String tempStr : tempSeries){
                                    if (answer.equals(tempStr)){
                                        writer2.write(answer + ", ");
                                    }
                                }
                                System.out.println("Do you want to add another favourite Movie? (Y/N)");
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

    private boolean findUsername(String username){
        HashSet<String> allUsernames = api.FileReaderForPersons.getAdminSubscriberUsernames(); // Static Method
        for (String tempUsername : allUsernames) {
            if (tempUsername.equals(username)){
                System.out.println("Username already exists");
                return false;
            }
        }
        return true;
    }

}

