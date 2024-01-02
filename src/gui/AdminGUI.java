package gui;

import javax.swing.*;
import java.awt.*;

public class AdminGUI extends JFrame {

    public void admin()
    {
        JRadioButton choice1, choice2, choice3, choice4;
        JButton next;

        setTitle("Administrator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(200, 250));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Select an action to proceed:");
        this.add(label1);

        // radio buttons
        choice1 = new JRadioButton("Add a new object");
        choice2 = new JRadioButton("Edit an existing object");
        choice3 = new JRadioButton("Delete an object");
        choice4 = new JRadioButton("Search for an object");

        next = new JButton("Next");

        this.add(choice1);
        this.add(choice2);
        this.add(choice3);
        this.add(choice4);
        this.add(next);

        ButtonGroup group = new ButtonGroup();
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);
        group.add(choice4);



        setVisible(true);
    }
}
