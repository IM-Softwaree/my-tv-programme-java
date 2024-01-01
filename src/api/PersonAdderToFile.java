package api;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class PersonAdderToFile {

    private String filenameForAdmins;
    private String filenameForSubscribers;
    public PersonAdderToFile(String filenameForAdmins, String filenameForSubscribers) {
        this.filenameForAdmins = filenameForAdmins;
        this.filenameForSubscribers = filenameForSubscribers;

        String answer;

        System.out.println("Do you want to add a person? (Y/N)");
        Scanner console = new Scanner(System.in);
        do {
            answer = console.next();
        } while ((!answer.equals("Y")) && (!answer.equals("N")));

        do {
            if (answer.equals("Y")) {
                System.out.println("Do you want to add an admin or a subscriber? (admin/subscriber)");
                do {
                    answer = console.next();
                } while ((!answer.equals("admin")) && (!answer.equals("subscriber")));

                if (answer.equals("admin")) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForAdmins, true))) {
                        //zitaei neo onoma gia admin
                        System.out.println("Give userName and password of admin :");
                        String userName, password;
                        userName = console.next();
                        password = console.next();
                        writer.write(userName + " " + password);
                        writer.newLine(); // Add a new line
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenameForSubscribers, true))) {
                        //zitaei neo onoma gia subscriber
                        System.out.println("Give userName,password,name and surname of Subscriber :");
                        String userName, password, name, surName;
                        userName = console.next();
                        password = console.next();
                        name = console.next();
                        surName = console.next();
                        writer.write(userName + " " + password + " " + name + " " + surName);
                        writer.newLine(); // Add a new line
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else //if answer is "N"
            { return; }


            System.out.println("Do you want to add another person? (Y/N)");
            do {
                answer = console.next();
            } while ((!answer.equals("Y")) && (!answer.equals("N")));

        } while (answer.equals("Y"));
    }
}
