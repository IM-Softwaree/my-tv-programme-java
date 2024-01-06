package gui;

import javax.swing.*;
import java.awt.*;

class SquarePanel extends JPanel {
    private String squareName;

    public SquarePanel(String squareName) {
        this.squareName = squareName;
        setPreferredSize(new Dimension(400, 200)); // Set preferred size for each square
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // Add white border around each square
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


