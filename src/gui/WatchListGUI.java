package gui;

import javax.swing.*;
import java.awt.*;
public class WatchListGUI extends JFrame {

    public WatchListGUI() {
        setTitle("Scrollable Black Squares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel squaresPanel = new JPanel();
        squaresPanel.setLayout(new GridLayout(0, 5)); // Set 4 columns

        // Create and add 20 black squares with different names
        for (int i = 1; i <= 100; i++) {
            addSquare(squaresPanel, "Square " + i);
        }

        JScrollPane scrollPane = new JScrollPane(squaresPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addSquare(JPanel panel, String squareName) {
        SquarePanel squarePanel = new SquarePanel(squareName);
        squarePanel.setPreferredSize(new Dimension(400, 200)); // Adjust size as needed
        panel.add(squarePanel);
    }
}
