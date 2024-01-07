/**
 * Το πρόγραμμά σας πρέπει να έχει μόνο μία main, η οποία πρέπει να είναι η παρακάτω.
 * <p>
 * <p>
 * ************* ΜΗ ΣΒΗΣΕΤΕ ΑΥΤΗ ΤΗΝ ΚΛΑΣΗ ************
 */

import gui.*;
import javax.swing.*;

public class Main {
    /**
     * We call the constructor of class "LoginGUI" using the parameter "loginGUI" and the GUI of the programme starts
     * @param args arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start();
        });
    }
}
