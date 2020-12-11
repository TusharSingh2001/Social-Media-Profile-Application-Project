import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Creates a GUI allowing the user to either login to an existing account, or go to a new GUI to register an account.
 * The Login button sends information from the GUI to the server to check the username and password, allowing the user to login.
 * When a user logs in, it sends them to the Profile GUI.
 * Login Page for Social Media App
 * @author Siddhant Vashishtha
 * @version 11 - 23 -2020
 */

public class LoginPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel usernameLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField usernameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("REGISTER");
    JCheckBox showPassword = new JCheckBox("Show Password");

    String username;
    String password;



    public void main() {
        //creates the window
        LoginPage page = new LoginPage();
        page.setTitle("Login Page");
        page.setVisible(true);
        page.setBounds(10, 10, 370, 400);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setResizable(true);
    }

    public LoginPage() {
        //sets the bounds for every single button, label and textfield
        usernameLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 170, 100, 30);
        usernameText.setBounds(150, 100, 150, 30);
        passwordText.setBounds(150, 170, 150, 30);
        showPassword.setBounds(150, 200, 150, 30);
        loginButton.setBounds(50, 250, 100, 30);
        registerButton.setBounds(200, 250, 100, 30);
        container.setLayout(null);
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameText);
        container.add(passwordText);
        container.add(showPassword);
        container.add(loginButton);
        container.add(registerButton);

        //adds functionality to the buttons
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        showPassword.addActionListener(this);

    }


    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            //put checking for login
            username = usernameText.getText();
            password = passwordText.getText();
            if (username.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Fields is/are empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    while (true) {

                        Client.dos.writeUTF("2");
                        Client.dos.writeUTF(username);
                        Client.dos.writeUTF(password);

                        String check = Client.dis.readUTF();
                        if (check.equals("UsernameNotFound")) {
                            JOptionPane.showMessageDialog(null, "Username was not found!", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("WrongPassword")) {
                            JOptionPane.showMessageDialog(null, "The password you entered was invalid!", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("AllGood")) {
                            this.dispose();
                            //accepts all values from server and creates ProfileGUI
                            Client.dos.writeUTF("3");
                            Client.dos.writeUTF(username);
                            username = Client.dis.readUTF();
                            String password = Client.dis.readUTF();
                            String email = Client.dis.readUTF();
                            String realName = Client.dis.readUTF();
                            String birthday = Client.dis.readUTF();
                            String education = Client.dis.readUTF();
                            String friends = Client.dis.readUTF();
                            String friendRequests = Client.dis.readUTF();
                            String bio = Client.dis.readUTF();
                            String likes = Client.dis.readUTF();
                            JOptionPane.showMessageDialog(null, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                            ProfileGUI p = new ProfileGUI(username, password, email, realName, birthday, education, friends, friendRequests, bio, likes);
                            break;
                        }
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }

        }

        //takes users to the registration page
        if (e.getSource() == registerButton) {
            Registration r = new Registration();
            r.main();
            this.dispose();
        }

        //shows the password in the text field
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordText.setEchoChar((char) 0);
            } else {
                passwordText.setEchoChar('*');
            }

        }
    }


}