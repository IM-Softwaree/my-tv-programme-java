package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscriberGUI extends JFrame {
    private String who= "subscriber";

    public void subscriber() {

        Object[] options = {"See list of movies and series", "Search bar"};

        int result = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Select Option",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (result != JOptionPane.CLOSED_OPTION) {
            handleSelection(result);
        }

    }

    private void handleSelection(int optionIndex) {
        switch (optionIndex) {
            case 0:
                // Option 1: See list of movies and series
                SwingUtilities.invokeLater(() -> {
                    WatchListGUI watchListGUI = new WatchListGUI(who);
                });
                break;
            case 1:
                SwingUtilities.invokeLater(() -> {
                    SearchVideo searchVideo  = new SearchVideo(who);
                });
                break;
            default:
                // Handle unexpected option
                JOptionPane.showMessageDialog(null, "Unexpected option selected.");
                break;
        }
    }

}
