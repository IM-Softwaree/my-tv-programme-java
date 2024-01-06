package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import api.*;
public class WatchListGUI extends JFrame {

    public WatchListGUI() {
        setTitle("Scrollable Black Squares");
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

    private void addSquare(JPanel panel, Video tempVideo) {
        SquarePanel squarePanel = new SquarePanel(tempVideo);
        squarePanel.setPreferredSize(new Dimension(400, 200)); // Adjust size as needed
        panel.add(squarePanel);
    }


}
