package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscriberGUI extends JFrame {

    public void subscriber(){

        Object[] options = {"See list of movies and series", "Search bar"};

        int result = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Select Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (result == JOptionPane.CLOSED_OPTION) {
            // User closed the dialog
            System.out.println("Dialog closed");
        } else {
            // User made a selection
            System.out.println("Selected: " + options[result]);
        }
    }
}
