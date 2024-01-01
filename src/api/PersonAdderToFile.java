package api;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashSet;

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

