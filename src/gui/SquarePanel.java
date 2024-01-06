package gui;

import api.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.*;

class SquarePanel extends JPanel {
    private String squareName;

    public SquarePanel(Video tempVideo) {
        this.squareName = tempVideo.getTitle();
        setPreferredSize(new Dimension(400, 200));
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        JButton detailsButton = new JButton("See Details");
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetails(tempVideo);
            }
        });

        setLayout(new BorderLayout());
        add(detailsButton, BorderLayout.SOUTH);
    }

    private void showDetails(Video tempVideo) {

        // Create and configure a new JFrame for the details window
        JFrame detailsWindow = new JFrame(squareName + " Details");
        detailsWindow.setSize(new Dimension(700, 200));
        detailsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

       // JButton edit;

        if(tempVideo instanceof Movie){     // FOR MOVIES

            // Create a JPanel to hold the labels
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel label1 = new JLabel("Title : " + tempVideo.getTitle());
            panel.add(label1);

            JLabel label2 = new JLabel("Description : " + tempVideo.getDescription());
            panel.add(label2);

            JLabel label3 = new JLabel("Appropriateness : " + tempVideo.getAppropriateness());
            panel.add(label3);

            JLabel label4 = new JLabel("Category : " + tempVideo.getCategory());
            panel.add(label4);

            JLabel label5 = new JLabel("Protagonists : " + tempVideo.getProtagonists());
            panel.add(label5);

            JLabel label6 = new JLabel("Duration : " + ((Movie) tempVideo).getMovieDuration());
            panel.add(label6);

            JLabel label7 = new JLabel("Year Of First Appearance : " + ((Movie) tempVideo).getYearOfFirstAppearance());
            panel.add(label7);

            JLabel labelA = new JLabel("Number of assessments: " + tempVideo.getAssessments().size());
            panel.add(labelA);

            JLabel labelB = new JLabel("Average rating: " + tempVideo.findAverageRating());
            panel.add(labelB);

            int i=1;
            for (Assessment assessment : tempVideo.getAssessments()) {
                JLabel labelC = new JLabel("Assessment " +i);
                panel.add(labelC);

                JLabel labelG = new JLabel("Date: " + assessment.getDate());
                panel.add(labelG);

                JLabel labelD = new JLabel("User's name: " + assessment.getUsername());
                panel.add(labelD);

                JLabel labelE = new JLabel("Comments: " + assessment.getText());
                panel.add(labelE);

                JLabel labelF = new JLabel("Rating: " + assessment.getRating());
                panel.add(labelF);

                i++;
            }

            /**
            edit = new JButton("Edit");
            panel.add(edit);
            edit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
             */

            detailsWindow.add(panel);

        }else if(tempVideo instanceof Serie){    // FOR SERIES

            // Create a JPanel to hold the labels
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel label1 = new JLabel("Title : " + tempVideo.getTitle());
            panel.add(label1);

            JLabel label2 = new JLabel("Description : " + tempVideo.getDescription());
            panel.add(label2);

            JLabel label3 = new JLabel("Appropriateness : " + tempVideo.getAppropriateness());
            panel.add(label3);

            JLabel label4 = new JLabel("Category : " + tempVideo.getCategory());
            panel.add(label4);

            JLabel label5 = new JLabel("Protagonists : " + tempVideo.getProtagonists());
            panel.add(label5);

            for (Season season : ((Serie) tempVideo).getSeasons()) {
                JLabel label6 = new JLabel("Season : " + season.getNumber());
                panel.add(label6);
                JLabel label7 = new JLabel("Season's year: " + season.getYear());
                panel.add(label7);

                for (Episode episode : season.getEpisodes()) {
                    JLabel label8 = new JLabel("Episode's name: " + episode.getName());
                    panel.add(label8);
                    JLabel label9 = new JLabel("Episode's duration: " + episode.getDuration());
                    panel.add(label9);

                }
            }

            JLabel labelA = new JLabel("Number of assessments: " + tempVideo.getAssessments().size());
            panel.add(labelA);

            JLabel labelB = new JLabel("Average rating: " + tempVideo.findAverageRating());
            panel.add(labelB);

            int i=1;
            for (Assessment assessment : tempVideo.getAssessments()) {
                JLabel labelC = new JLabel("Assessment " +i);
                panel.add(labelC);

                JLabel labelG = new JLabel("Date: " + assessment.getDate());
                panel.add(labelG);

                JLabel labelD = new JLabel("User's name: " + assessment.getUsername());
                panel.add(labelD);

                JLabel labelE = new JLabel("Comments: " + assessment.getText());
                panel.add(labelE);

                JLabel labelF = new JLabel("Rating: " + assessment.getRating());
                panel.add(labelF);

                i++;
            }

            detailsWindow.add(panel);

        }

        // Make the details window visible
        detailsWindow.setLocationRelativeTo(null);
        detailsWindow.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawString(squareName, 10, 20);
    }
}



