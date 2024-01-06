package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import api.*;
public class WatchListGUI extends JFrame {

    public WatchListGUI() {
        setTitle("List of movies and series");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns

        ArrayList<Video> videos = Video.returnAllVideos();
        for (Video tempVideo : videos){
            addSquare(squaresPanel, tempVideo);
        }

        JScrollPane scrollPane = new JScrollPane(squaresPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public WatchListGUI(ArrayList<Video> searchList) {
        setTitle("List of movies and series after the search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns



        for (Video tempVideo : searchList){
            addSquare(squaresPanel, tempVideo);
        }

        JScrollPane scrollPane1 = new JScrollPane(squaresPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane1, BorderLayout.SOUTH);

        // Create a button to open a new window
        JButton openNewWindowButton = new JButton("Back to search");
        openNewWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Option 1: See list of movies and series
                SwingUtilities.invokeLater(() -> {
                    SearchVideo searchVideo  = new SearchVideo();
                });
                dispose();
            }
        });
        add(openNewWindowButton, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(squaresPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addSquare(JPanel panel, Video tempVideo) {
        SquarePanel squarePanel = new SquarePanel(tempVideo);
        squarePanel.setPreferredSize(new Dimension(400, 200)); // Adjust size as needed
        panel.add(squarePanel);
    }

}
