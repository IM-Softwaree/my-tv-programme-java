package gui;
import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovie extends JFrame{

    public void addMovie()
    {
        JTextField title, description, appropriateness,category, protagonists, year, duration;
        JButton save,back;
        JPanel panel,panel2,panel3,panel4,panel5,panel6,panel7;

        setTitle("Add a new movie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(300, 380));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("        Give movie information and click save:     ");
        this.add(label1);

        panel = new JPanel();
        JLabel label2 = new JLabel("Title:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);

        panel2 = new JPanel();
        JLabel label3 = new JLabel("Description:");
        description = new JTextField();
        description.setPreferredSize(new Dimension(100, description.getPreferredSize().height));
        panel2.add(label3);
        panel2.add(description);
        this.add(panel2);

        panel3 = new JPanel();
        JLabel label4 = new JLabel("Appropriateness:");
        appropriateness = new JTextField();
        appropriateness.setPreferredSize(new Dimension(100, appropriateness.getPreferredSize().height));
        panel3.add(label4);
        panel3.add(appropriateness);
        this.add(panel3);

        panel4 = new JPanel();
        JLabel label5 = new JLabel("Category:");
        category = new JTextField();
        category.setPreferredSize(new Dimension(100, category.getPreferredSize().height));
        panel4.add(label5);
        panel4.add(category);
        this.add(panel4);

        panel5 = new JPanel();
        JLabel label6 = new JLabel("Protagonists:");
        protagonists = new JTextField();
        protagonists.setPreferredSize(new Dimension(100, protagonists.getPreferredSize().height));
        panel5.add(label6);
        panel5.add(protagonists);
        this.add(panel5);

        panel6 = new JPanel();
        JLabel label7 = new JLabel("Year of first appearance:");
        year = new JTextField();
        year.setPreferredSize(new Dimension(100, year.getPreferredSize().height));
        panel6.add(label7);
        panel6.add(year);
        this.add(panel6);

        panel7 = new JPanel();
        JLabel label8 = new JLabel("Movie duration:");
        duration = new JTextField();
        duration.setPreferredSize(new Dimension(100, duration.getPreferredSize().height));
        panel7.add(label8);
        panel7.add(duration);
        this.add(panel7);

        JLabel labelB = new JLabel("                                                    ");
        this.add(labelB);

        save = new JButton("Save");

        this.add(save);
        //AAA
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                String a = appropriateness.getText();
                String c = category.getText();
                String p = protagonists.getText();
                int y = Integer.parseInt(year.getText());
                int dur = Integer.parseInt(duration.getText());

                Movie neo = new Movie(t,d,a,c,p,y,dur);

                neo.addMovieToFile();
            }
        });

        back = new JButton("Back");
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }


    /* private void openNewWindowError() {

        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("ADDING A MOVIE NOT SUCCESSFUL");
        newWindow.setSize(new Dimension(300, 200));
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button on the bottom
        JButton actionButton2 = new JButton("PRESS HERE TO CONTINUE");
        actionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "PRESS HERE TO CONTINUE" button is clicked
                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
            }
        });

        // Show the message dialog
        JOptionPane.showMessageDialog(newWindow, "ADDING A MOVIE NOT SUCCESSFUL!!!", "Message", JOptionPane.INFORMATION_MESSAGE);

        // Add the button and label to the frame
        newWindow.setLayout(new BorderLayout());
        newWindow.add(actionButton2, BorderLayout.SOUTH);

        // Make the new window visible
        newWindow.setVisible(true);
    }

    private void openNewWindowSuccess() {

        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("ADDING A MOVIE SUCCESSFUL");
        newWindow.setSize(new Dimension(300, 200));
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button on the bottom
        JButton actionButton2 = new JButton("PRESS HERE TO CONTINUE");
        actionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "PRESS HERE TO CONTINUE" button is clicked
                // Dispose of the current JFrame (make it disappear)
                newWindow.dispose();
            }
        });

        // Show the message dialog
        JOptionPane.showMessageDialog(newWindow, "ADDING A MOVIE SUCCESSFUL!!!", "Message", JOptionPane.INFORMATION_MESSAGE);

        // Add the button and label to the frame
        newWindow.setLayout(new BorderLayout());
        newWindow.add(actionButton2, BorderLayout.SOUTH);

        // Make the new window visible
        newWindow.setVisible(true);
    } */

}
