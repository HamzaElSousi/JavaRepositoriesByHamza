import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAndAuthentication {
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Authentication Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.WEST;
            constraints.insets = new Insets(5, 5, 5, 5);

            panel.add(new JLabel("Username:"), constraints);

            constraints.gridy = 1;

            panel.add(new JLabel("Password:"), constraints);

            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.weightx = 1.0;
            constraints.fill = GridBagConstraints.HORIZONTAL;

            JTextField usernameField = new JTextField(15);
            panel.add(usernameField, constraints);

            constraints.gridy = 1;

            JPasswordField passwordField = new JPasswordField(15);
            panel.add(passwordField, constraints);

            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 2;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.fill = GridBagConstraints.NONE;

            JButton loginButton = new JButton("Login");
            panel.add(loginButton, constraints);

            // Add ActionListener to the Login button
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String enteredUsername = usernameField.getText();
                    char[] enteredPasswordChars = passwordField.getPassword();
                    String enteredPassword = new String(enteredPasswordChars);

                    if (isValidCredentials(enteredUsername, enteredPassword)) {
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
                        // Clear fields
                        usernameField.setText("");
                        passwordField.setText("");
                    }
                }
            });

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    private static boolean isValidCredentials(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
