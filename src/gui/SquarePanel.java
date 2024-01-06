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
        detailsWindow.setSize(new Dimension(300, 150));
        detailsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        if(tempVideo instanceof Movie){     // FOR MOVIES

            // Add a label with the description
            JLabel titleLabel = new JLabel("Description: This is the details for " + squareName);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(titleLabel);

            // Add a label with the description
            JLabel descriptionLabel = new JLabel("Description: This is the details for " + squareName);
            descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(descriptionLabel);

            // Add a label with the description
            JLabel appropriatetenessLabel = new JLabel("Description: This is the details for " + squareName);
            appropriatetenessLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(appropriatetenessLabel);

            // Add a label with the description
            JLabel categoryLabel = new JLabel("Description: This is the details for " + squareName);
            categoryLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(categoryLabel);

            // Add a label with the description
            JLabel protagonistsLabel = new JLabel("Description: This is the details for " + squareName);
            protagonistsLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(protagonistsLabel);

            // Add a label with the description
            JLabel yearOfFirstAppearenceLabel = new JLabel("Description: This is the details for " + squareName);
            yearOfFirstAppearenceLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(yearOfFirstAppearenceLabel);

            // Add a label with the description
            JLabel moviedurationLabel = new JLabel("Description: This is the details for " + squareName);
            moviedurationLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(moviedurationLabel);

        }else if(tempVideo instanceof Serie){    // FOR SERIES

            // Add a label with the description
            JLabel titleLabel = new JLabel("Description: This is the details for " + squareName);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(titleLabel);

            // Add a label with the description
            JLabel descriptionLabel = new JLabel("Description: This is the details for " + squareName);
            descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(descriptionLabel);

            // Add a label with the description
            JLabel appropriatetenessLabel = new JLabel("Description: This is the details for " + squareName);
            appropriatetenessLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(appropriatetenessLabel);

            // Add a label with the description
            JLabel categoryLabel = new JLabel("Description: This is the details for " + squareName);
            categoryLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(categoryLabel);

            // Add a label with the description
            JLabel protagonistsLabel = new JLabel("Description: This is the details for " + squareName);
            protagonistsLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(protagonistsLabel);

            // Add a label with the description
            JLabel seasonsLabel = new JLabel("Description: This is the details for " + squareName);
            seasonsLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(seasonsLabel);

            // Add a label with the description
            JLabel episodesLabel = new JLabel("Description: This is the details for " + squareName);
            episodesLabel.setHorizontalAlignment(JLabel.CENTER);
            detailsWindow.add(episodesLabel);

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



