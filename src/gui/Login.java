import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public void start() {
        setTitle("NEXTFLIX");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(1000, 500));
        setResizable(true);

        // Set layout manager to center the components vertically
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));

        // Create a blue button
        JButton loginButton = new JButton("Log In");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE); // Set text color to white for better visibility

        // Set the preferred size of the button
        loginButton.setPreferredSize(new Dimension(200, 100));

        // Add ActionListener to the "Log In" button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when the "Log In" button is clicked
                openNewWindow();

                // Dispose of the current JFrame (make it disappear)
                dispose();
            }
        });

        // Add the button to the frame
        add(loginButton);

        // Make the frame visible
        setVisible(true);
    }

    private void openNewWindow() {
        // Create and configure a new JFrame for the new window
        JFrame newWindow = new JFrame("Nextflix Log-In");
        newWindow.setSize(new Dimension(400, 300));
        newWindow.setLocationRelativeTo(this);

        // Add components or customize the new window as needed
        JLabel welcomeLabel = new JLabel("Welcome to Nextflix!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        newWindow.add(welcomeLabel);

        // Make the new window visible
        newWindow.setVisible(true);
    }

}
