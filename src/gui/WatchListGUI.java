package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import api.*;
public class WatchListGUI extends JFrame {

    public WatchListGUI(String who) {
        setTitle("List of movies and series");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns

        ArrayList<Video> videos = Video.returnAllVideos();
        for (Video tempVideo : videos){
            addSquare(squaresPanel, tempVideo, who);
        }

        JScrollPane scrollPane = new JScrollPane(squaresPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public WatchListGUI(ArrayList<Video> searchList,String who) {
        setTitle("List of movies and series after the search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns



        for (Video tempVideo : searchList){
            addSquare(squaresPanel, tempVideo, who);
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
                    SearchVideo searchVideo  = new SearchVideo(who);
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

    private void addSquare(JPanel panel, Video tempVideo, String who) {
        SquarePanel squarePanel = new SquarePanel(tempVideo,who);
        squarePanel.setPreferredSize(new Dimension(400, 200)); // Adjust size as needed
        panel.add(squarePanel);
    }


    private void addSquare(JPanel panel, Video tempVideo, String who, String userName) {
        SquarePanel squarePanel = new SquarePanel(tempVideo,who, userName);
        squarePanel.setPreferredSize(new Dimension(400, 200)); // Adjust size as needed
        panel.add(squarePanel);
    }

    public WatchListGUI(String userName, boolean bool) {
        setTitle("List of Favourites for User : ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set to DISPOSE_ON_CLOSE
        setLayout(new BorderLayout());

        String favs = Favourites.getFavourites(userName);
        JLabel label = new JLabel(favs);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        add(label, BorderLayout.CENTER);

        // Set the size of the JFrame
        setSize(600, 400); // Adjust the width and height as needed

        setLocationRelativeTo(null);
        setVisible(true);

        // Add a window listener to handle window closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                // Call your function here before closing the window
                new SubscriberGUI().subscriber(userName);
            }
        });
    }

    public WatchListGUI(String who, String userName, boolean bool1 , char char2) {
        setTitle("List of movies and series");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns

        ArrayList<Video> videos = Video.returnAllVideos();
        for (Video tempVideo : videos){
            addSquare(squaresPanel, tempVideo, who, userName);
        }

        JScrollPane scrollPane = new JScrollPane(squaresPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
//