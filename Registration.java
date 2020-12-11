import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Creates a GUI allowing the user to either register a new account, or go to a new GUI to login to an existing one.
 * The registration button saves information from the GUI in a specific file for that user.
 * That file is used for persistent data storage and retrieval of data throughout the application.
 * When an account has been registered, it sends the user back to the Login GUI.
 * @author Roshan Barat, Siddhant Vashishtha, Digvijay Pawar
 * @version 12 - 7 - 2020
 */

public class Registration extends JFrame implements ActionListener {


    Container container = getContentPane();
    JLabel usernameL = new JLabel("Username");
    JLabel passwordL = new JLabel("Password");
    JLabel emailL = new JLabel("Email");

    JTextField usernameT = new JTextField();
    JPasswordField passwordT = new JPasswordField();
    JTextField emailT = new JTextField();

    JButton confirmButton = new JButton("Confirm");
    JButton loginButton = new JButton("Login Page");

    String username;
    String password;
    String email;


    @Override
    public void actionPerformed(ActionEvent e) {
        //registers user to the application with given information
        if (e.getSource() == confirmButton) {
            username = usernameT.getText();
            password = passwordT.getText();
            email = emailT.getText();
            if (username.equals("") || password.equals("") || email.equals("")) {
                JOptionPane.showMessageDialog(null, "Fields is/are empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    while (true) {
                        //sends email, password and username to server to register
                        Client.dos.writeUTF("1");
                        Client.dos.writeUTF(username);
                        Client.dos.writeUTF(password);
                        Client.dos.writeUTF(email);
                        String check = Client.dis.readUTF();
                        if (check.equals("UsernameisFound")) {
                            JOptionPane.showMessageDialog(null, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("SpaceUsername")) {
                            JOptionPane.showMessageDialog(null, "Username has a space.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("BadPassword")) {
                            JOptionPane.showMessageDialog(null, "Password is too weak. Keep it at least 8 characters long and no spaces.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("BadEmail")) {
                            JOptionPane.showMessageDialog(null, "Incorrect Format for Mail. Please use a legitimate email.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        } else if (check.equals("AllGood")) {
                            this.dispose();
                            JOptionPane.showMessageDialog(null, "Registered Successfully", "Register", JOptionPane.INFORMATION_MESSAGE);
                            LoginPage lp = new LoginPage();
                            lp.main();
                            break;
                        }


                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        //opens the Login Page GUI of the application
        if (e.getSource() == loginButton) {
            this.dispose();
            LoginPage lp = new LoginPage();
            lp.main();
        }
    }


    public void runRegistration() {

        //sets the window up
        Registration registrationForm = new Registration();

        registrationForm.setLayout(new BorderLayout());
        registrationForm.setVisible(true);

        registrationForm.setBounds(100, 100, 500, 500);

        registrationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrationForm.setResizable(true);
    }

    public Registration() {
        setComponentSize();
        addComponents();
        addAction();
    }

    public void setComponentSize() {
        //givens bounds to all components of the page
        usernameL.setBounds(100, 100, 100, 30);
        passwordL.setBounds(100, 170, 100, 30);
        emailL.setBounds(100, 240, 100, 30);
        usernameT.setBounds(170, 100, 150, 30);
        passwordT.setBounds(170, 170, 150, 30);
        emailT.setBounds(170, 240, 250, 30);
        confirmButton.setBounds(250, 290, 100, 30);
        loginButton.setBounds(100, 290, 100, 30);

    }


    public void addComponents() {

        //adds components to the page
        container.add(usernameL);
        container.add(passwordL);
        container.add(emailL);
        container.add(usernameT);
        container.add(passwordT);
        container.add(emailT);
        container.add(loginButton);
        container.add(confirmButton);
    }

    public void addAction() {

        //gives functionality to every page
        loginButton.addActionListener(this);
        confirmButton.addActionListener(this);
    }

    public void main() {
        Registration registrationForm = new Registration();
        registrationForm.runRegistration();
    }


}