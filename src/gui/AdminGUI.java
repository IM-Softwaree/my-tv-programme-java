package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    public void admin()
    {
        JRadioButton choice1, choice2;
        JButton next;

        setTitle("Administrator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Select an action to proceed:");
        this.add(label1);

        // radio buttons
        choice1 = new JRadioButton("Add a new object");
        choice2 = new JRadioButton("See list of movies and series");

        next = new JButton("Next");

        this.add(choice1);
        this.add(choice2);

        this.add(next);

        ButtonGroup group = new ButtonGroup();
        group.add(choice1);
        group.add(choice2);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(choice1.isSelected())
                {
                  new AddObject().add();
                }
                /**
                else
                {

                }
                 */

            }
        });


        setVisible(true);
    }
}
