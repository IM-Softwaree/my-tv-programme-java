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
        this.setLayout(new FlowLayout());

        if(tempVideo instanceof Movie){     // FOR MOVIES

            JLabel label1 = new JLabel("Title : " + tempVideo.getTitle());
            detailsWindow.add(label1);

            JLabel label2 = new JLabel("Description : " + tempVideo.getDescription());
            detailsWindow.add(label2);

            JLabel label3 = new JLabel("Appropriateness : " + tempVideo.getAppropriateness());
            detailsWindow.add(label3);

            JLabel label4 = new JLabel("Category : " + tempVideo.getCategory());
            detailsWindow.add(label4);

            JLabel label5 = new JLabel("Protagonists : " + tempVideo.getProtagonists());
            detailsWindow.add(label5);

            JLabel label6 = new JLabel("Duration : " + ((Movie) tempVideo).getMovieDuration());
            detailsWindow.add(label6);

            JLabel label7 = new JLabel("Year Of First Appearance : " + ((Movie) tempVideo).getYearOfFirstAppearance());
            detailsWindow.add(label7);

        }else if(tempVideo instanceof Serie){    // FOR SERIES

            JLabel label1 = new JLabel("Title : " + tempVideo.getTitle());
            detailsWindow.add(label1);

            JLabel label2 = new JLabel("Description : " + tempVideo.getDescription());
            detailsWindow.add(label2);

            JLabel label3 = new JLabel("Appropriateness : " + tempVideo.getAppropriateness());
            detailsWindow.add(label3);

            JLabel label4 = new JLabel("Category : " + tempVideo.getCategory());
            detailsWindow.add(label4);

            JLabel label5 = new JLabel("Protagonists : " + tempVideo.getProtagonists());
            detailsWindow.add(label5);

            JLabel label6 = new JLabel("Seasons : " + ((Serie) tempVideo).getSeasons());
            detailsWindow.add(label6);

            JLabel label7 = new JLabel("Episodes : " );
            detailsWindow.add(label7);

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



