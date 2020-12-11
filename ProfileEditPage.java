import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Creates the GUI for the edit page for a profile. Allows users to enter their information into the specified fields for each item, and includes a "Confirm" button that saves the changes made.
 * Also includes a "Delete profile" button, which will remove the profile from the server, and remove any friends/friend requests the profile had with other users.
 * @author Siddhant Vashishtha, Tushar Singh
 * @version 12 - 7 - 2020
 */

public class ProfileEditPage extends JFrame implements ActionListener {

    //Edit contact information field such as email and phone number
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailText = new JTextField();
    JLabel birthdayLabel = new JLabel("Birthday");
    JTextField birthdayText = new JTextField();
    JButton confirmButton = new JButton("Confirm");
    JButton deleteButton = new JButton("Delete Account");

    


    JFrame frame;

    Profile myProfile;

    public ProfileEditPage(Profile myProfile) {
        this.myProfile = myProfile;
        nameText = new JTextField(myProfile.getRealName());
        emailText = new JTextField(myProfile.getEmail());
        birthdayText = new JTextField(myProfile.getBirthday());
        bioText = new JTextField(myProfile.getBio());
        educationText = new JTextField(myProfile.getEducation());
        likesText = new JTextField(myProfile.getLikes());
        main();
    }


    //Edit bio field
    JLabel bioLabel = new JLabel("Bio:");
    JTextField bioText = new JTextField();

    //Edit education field
    JLabel educationLabel = new JLabel("Education:");
    JTextField educationText = new JTextField();

    //Edit likes field
    JLabel likesLabel = new JLabel("Likes:");
    JTextField likesText = new JTextField();

    //Edit places visited field
    JLabel nameLabel = new JLabel("Name:");
    JTextField nameText = new JTextField();

    public void main() {
        works();
    }

    public void works() {

        frame = new JFrame("Edit Profile");
        Container content = frame.getContentPane();
        content.setLayout(null);
        frame.setSize(900, 900);


        //Adds all the labels to the frame
        content.add(emailLabel);
        content.add(birthdayLabel);
        content.add(bioLabel);
        content.add(educationLabel);
        content.add(likesLabel);
        content.add(nameLabel);


        //Adds all the text fields to the frame
        content.add(emailText);
        content.add(birthdayText);
        content.add(bioText);
        content.add(educationText);
        content.add(likesText);
        content.add(nameText);

        //add all buttons to the frame
        content.add(confirmButton);
        content.add(deleteButton);


        //Sets bounds for all the labels
        nameLabel.setBounds(100, 100, 100, 30);
        birthdayLabel.setBounds(100, 200, 100, 30);
        bioLabel.setBounds(100, 300, 100, 30);
        educationLabel.setBounds(100, 400, 100, 30);
        likesLabel.setBounds(100, 500, 100, 30);
        emailLabel.setBounds(100, 600, 100, 30);


        //Sets bounds for all the text fields
        emailText.setBounds(260, 600, 400, 30);
        birthdayText.setBounds(260, 200, 400, 30);
        bioText.setBounds(260, 300, 400, 30);
        educationText.setBounds(260, 400, 400, 30);
        likesText.setBounds(260, 500, 400, 30);
        nameText.setBounds(260, 100, 400, 30);

        //set bounds for all buttons
        confirmButton.setBounds(700, 620, 100, 30);
        deleteButton.setBounds(350, 750, 200, 50);



        //Sets the tool tip for text fields when cursor lingers over the component
        emailText.setToolTipText("Enter email id here");
        birthdayText.setToolTipText("Enter birthday(MM/DD/YYYY)");
        bioText.setToolTipText("Enter bio here");
        educationText.setToolTipText("Enter education here");
        likesText.setToolTipText("Enter likes here");
        nameLabel.setToolTipText("Enter your name");


        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        //give functionallity to all buttons
        confirmButton.addActionListener(this);
        deleteButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //saves changes to textfile made by user with some restrictions
        if (e.getSource() == confirmButton) {
            int counter = 0;
            for (int i = 0; i < birthdayText.getText().length(); i++) {
                char ch = birthdayText.getText().charAt(i);
                if (ch == '/') {
                    counter++;
                }
            }

            int atCount = 0;
            int dotCount = 0;
            for (int i = 0; i < emailText.getText().length(); i++) {
                char ch = emailText.getText().charAt(i);
                if (ch == '@') {
                    atCount = i;
                }

                if (ch == '.') {
                    dotCount = i;
                }
            }

            if (atCount < 1 || dotCount < 1 || atCount > dotCount) {
                JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (counter != 2) {
                JOptionPane.showMessageDialog(null, "Date Incorrect Format(Correct Format - MM/DD/YYYY)", "Error", JOptionPane.ERROR_MESSAGE);

            } else if (nameText.getText().trim().equals("") || bioText.getText().trim().equals("") || likesText.getText().trim().equals("") || emailLabel.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Field is empty", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {

                    //sending information to the server to update
                    Client.dos.writeUTF("4");
                    Client.dos.writeUTF(myProfile.getUserName());
                    Client.dos.writeUTF("2 " + myProfile.getPassword());
                    Client.dos.writeUTF("3 " + emailText.getText());
                    Client.dos.writeUTF("4 " + nameText.getText());
                    Client.dos.writeUTF("5 " + birthdayText.getText());
                    Client.dos.writeUTF("6 " + educationText.getText());
                    String friends = "";
                    for (String s: myProfile.getFriends()) {
                        friends = friends + s + " ";
                    }
                    friends = friends.trim();
                    Client.dos.writeUTF("7 " + friends);
                    String friendRequest = "";
                    for (String s: myProfile.getFriendRequests()) {
                        friendRequest = friendRequest + s + " ";
                    }
                    friendRequest = friendRequest.trim();

                    Client.dos.writeUTF("8 " + friendRequest);
                    Client.dos.writeUTF("9 " + bioText.getText());
                    Client.dos.writeUTF("10 " + likesText.getText());

                    frame.dispose();


                    String username = Client.dis.readUTF();
                    String password = Client.dis.readUTF();
                    String email = Client.dis.readUTF();
                    String realName = Client.dis.readUTF();
                    String birthday = Client.dis.readUTF();
                    String education = Client.dis.readUTF();
                    String friends1 = Client.dis.readUTF();
                    String friendRequests = Client.dis.readUTF();
                    String bio = Client.dis.readUTF();
                    String likes = Client.dis.readUTF();
                    JOptionPane.showMessageDialog(null, "Changes Saved", "Edit", JOptionPane.INFORMATION_MESSAGE);
                    ProfileGUI p = new ProfileGUI(username, password, email, realName, birthday, education, friends1, friendRequests, bio, likes);


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            //deletes the profile of the user
        } else if (e.getSource() == deleteButton) {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your profile?", "Wow", JOptionPane.YES_NO_CANCEL_OPTION);
            if (input == 0) {
                String check = "";
                try {
                    Client.dos.writeUTF("12");
                    Client.dos.writeUTF(myProfile.getUserName());
                    check = Client.dis.readUTF();
                    if (check.equals("AllGood")) {
                        JOptionPane.showMessageDialog(null, "You have successfully deleted your profile", "Bye", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                        LoginPage lp = new LoginPage();
                        lp.main();
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }


        }

    }
}