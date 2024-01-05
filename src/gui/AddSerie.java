package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSerie extends JFrame {
    private Serie neo;

    public AddSerie()
    {
        JTextField title, description, appropriateness,category, protagonists;
        JButton save,back;
        JPanel panel,panel2,panel3,panel4,panel5;

        JFrame newWindow = new JFrame("Adding a serie");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(null);

        // Set default close operation to EXIT_ON_CLOSE
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for the new window
        newWindow.setLayout(new FlowLayout());

        setTitle("Add a new serie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(270, 420));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("    Give serie information and then click save:    ");
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


        save = new JButton("Save");
        this.add(save);

        JLabel labelA = new JLabel("    To add a season click bellow:    ");
        this.add(labelA);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();
                String d = description.getText();
                String a = appropriateness.getText();
                String c = category.getText();
                String p = protagonists.getText();

                neo = new Serie(t,d,a,c,p);

                boolean result = neo.addSerieToFile(neo);  //!!!APPEND TO BINARY FILE
                if(result)
                    JOptionPane.showMessageDialog(newWindow, "Adding a serie successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(newWindow, "Adding a serie NOT successful", "Message", JOptionPane.INFORMATION_MESSAGE);

            }
        });


        // Button to add new season
        JButton addSeasonButton = new JButton("Add Season");
        addSeasonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();

                int seasonNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter season number:"));
                int seasonYear = Integer.parseInt(JOptionPane.showInputDialog("Enter season year:"));

                Season newSeason = new Season(seasonNumber,seasonYear);

                boolean result2 = neo.addSeasonToFile(t,newSeason);
                if(result2)
                    JOptionPane.showMessageDialog(newWindow, "Adding a season successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(newWindow, "Adding a season NOT successful", "Message", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        this.add(addSeasonButton);


        JLabel labelC = new JLabel("    To add an episode click bellow:    ");
        this.add(labelC);


        // Button to add new episode
        JButton addEpisodeButton = new JButton("Add Episode");
        addEpisodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();

                int seasonNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter season number:"));

                String episodeName = JOptionPane.showInputDialog("Enter episode name:");
                int episodeDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter episode duration:"));

                Episode newEp = new Episode(episodeName,episodeDuration);

                boolean result3 = neo.addEpisodeToFile(t,seasonNumber,newEp);
                if(result3)
                    JOptionPane.showMessageDialog(newWindow, "Adding an episode successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(newWindow, "Adding an episode NOT successful", "Message", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        this.add(addEpisodeButton);


        JLabel labelB = new JLabel("                                                    ");
        this.add(labelB);

        back = new JButton("Back");
        this.add(back);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
