package gui;

import javax.swing.*;

public class SubscriberGUI extends JFrame {
    private String who= "subscriber";

    public void subscriber(String userName) {

        Object[] options = {"See list of movies and series", "Search bar", "See list of favourites"};

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
            handleSelection(result, userName);
        }

    }

    private void handleSelection(int optionIndex, String userName) {
        switch (optionIndex) {
            case 0:
                // Option 1: See list of movies and series
                SwingUtilities.invokeLater(() -> {
                    WatchListGUI watchListGUI = new WatchListGUI(who, userName, true, 'a');
                });
                break;
            case 1:
                SwingUtilities.invokeLater(() -> {
                    SearchVideo searchVideo  = new SearchVideo(who);
                });
                break;
            case 2:
                // Option 3: See list of Favourites
                SwingUtilities.invokeLater(() -> {
                    WatchListGUI watchListGUI = new WatchListGUI(userName, true);
                });
                break;
            default:
                // Handle unexpected option
                JOptionPane.showMessageDialog(null, "Unexpected option selected.");
                break;
        }
    }

}

/**
 *
 */