package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSeason extends JFrame {
    private Serie neo = new Serie() ;
    public AddSeason()
    {
        JTextField title;
        JButton back;
        JPanel panel;

        setTitle("Add a new season");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(400, 200));
        this.setResizable(true);
        this.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Give the name of the serie you want to add seasons and episodes:");
        this.add(label1);

        panel = new JPanel();
        JLabel label2 = new JLabel("Title:");
        title = new JTextField();
        title.setPreferredSize(new Dimension(100, title.getPreferredSize().height));
        panel.add(label2);
        panel.add(title);
        this.add(panel);


        // Button to add new season
        JButton addSeasonButton = new JButton("Add Season");
        addSeasonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = title.getText();

                int seasonNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter season number:"));
                int seasonYear = Integer.parseInt(JOptionPane.showInputDialog("Enter season year:"));

                Season newSeason = new Season(seasonNumber,seasonYear);

                neo.addSeasonToFile(t,newSeason);  //!!!APPEND TO BINARY FILE

            }
        });

        this.add(addSeasonButton);


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

                neo.addEpisodeToFile(t,seasonNumber,newEp);  //!!!APPEND TO BINARY FILE

            }
        });

        this.add(addEpisodeButton);

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
