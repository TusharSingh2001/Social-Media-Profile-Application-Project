import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Creates the GUI for a user looking at another users profile. The GUI contains the following features:
 * Profile Area - To view Bio, Username, Real Name, Likes, Birthday, Email, Education
 * Back Button - To return to the ProfileGUI for the specific user
 * Send/Cancel Friend Request - Sends or cancels a friend request to a specific user. The other user will see the friend request in their ProfileGUI.
 * Remove Friend - Removes the users as friends. If the users aren't friends, does nothing.
 * @author Roshan Barat, Siddhant Vashishtha
 * @version 12 - 7 - 2020
 */

public class OtherProfileGUI extends JFrame implements ActionListener {

    String myUsername;
    String thisUsername;
    Container container = getContentPane();
    JLabel nameLabel;
    JLabel usernameLabel;
    JLabel likesLabel;
    JLabel bioLabel;
    JLabel birthdayLabel;
    JLabel emailLabel;
    JLabel educationLabel;

    JLabel usernameTagLabel = new JLabel("Username: ");
    JLabel likesTagLabel = new JLabel("Likes: ");
    JLabel birthdayTagLabel = new JLabel("Birthday: ");
    JLabel emailTagLabel = new JLabel("Email: ");
    JLabel educationTagLabel = new JLabel("Education: ");

    JSeparator vert = new JSeparator();
    JSeparator highlight = new JSeparator();

    JButton backButton = new JButton("Back");
    JButton addFriendButton = new JButton("Send Friend Request");
    JButton removeFriendButton = new JButton("Remove Friend");
    JButton cancelFriendRequestButton = new JButton("Cancel Friend Request");

    Profile thisProfile;

    public OtherProfileGUI(String username, String email, String realName, String birthday, String education, String bio, String likes, String myUsername) throws IOException {
        this.myUsername = myUsername;
        this.thisUsername = username;
        thisProfile = new Profile(username, email, realName, birthday, education, bio, likes);
        main(username);

        getValues(thisProfile);
        container.setLayout(null);
        setLocationAndSize();
        styling();
        addComponentsToContainer();
        addAction();
    }

    public void main(String username) throws IOException {
        //creates default window
        this.setTitle(username + "'s Profile");
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(10, 10, 740, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getValues(Profile myProfile) {

        //sets the values for every single label
        String bio = "<html><p>" + myProfile.getBio() + "</p></html>";
        nameLabel = new JLabel(myProfile.getRealName(), SwingConstants.CENTER);
        usernameLabel = new JLabel(myProfile.getUserName());
        emailLabel = new JLabel(myProfile.getEmail());
        bioLabel = new JLabel(bio);
        educationLabel = new JLabel(myProfile.getEducation());
        birthdayLabel = new JLabel(myProfile.getBirthday());
        likesLabel = new JLabel(myProfile.getLikes());
        String likes = "<html><p>" + myProfile.getLikes() + "</p></html>";
        likesLabel = new JLabel(likes);
    }

    public void setLocationAndSize() {

        //sets the location of every button and label

        nameLabel.setBounds(220, 10, 490, 60);

        bioLabel.setBounds(240, 60, 470, 200);
        usernameTagLabel.setBounds(250, 265, 140, 40);
        usernameLabel.setBounds(250, 280, 140, 40);
        emailTagLabel.setBounds(500, 265, 140, 40);
        emailLabel.setBounds(500, 280, 140, 40);
        birthdayTagLabel.setBounds(250, 325, 140, 40);
        birthdayLabel.setBounds(250, 340, 140, 40);
        educationTagLabel.setBounds(500, 325, 140, 40);
        educationLabel.setBounds(500, 340, 140, 40);
        likesTagLabel.setBounds(250, 385, 140, 40);
        likesLabel.setBounds(250, 410, 470, 200);



        vert.setBounds(200, 10, 5, 800);
        highlight.setBounds(10, 10, 740, 500);

        backButton.setBounds(10, 10, 190, 75);
        addFriendButton.setBounds(10, 95, 190, 75);
        removeFriendButton.setBounds(10, 180, 190, 75);
        cancelFriendRequestButton.setBounds(10, 265, 190, 75);

    }

    public void addComponentsToContainer() {

        //adds all features to the container

        container.add(nameLabel);
        container.add(emailLabel);
        container.add(bioLabel);
        container.add(usernameLabel);
        container.add(educationLabel);
        container.add(birthdayLabel);
        container.add(vert);
        container.add(highlight);
        container.add(usernameTagLabel);
        container.add(emailTagLabel);
        container.add(educationTagLabel);
        container.add(likesTagLabel);
        container.add(birthdayTagLabel);
        container.add(addFriendButton);
        container.add(backButton);
        container.add(removeFriendButton);
        container.add(likesLabel);
        container.add(cancelFriendRequestButton);
    }

    public void styling() {
        //makes everything look better
        Color purdueGold = new Color(255, 215, 0);
        vert.setOrientation(SwingConstants.VERTICAL);
        highlight.setOrientation(SwingConstants.HORIZONTAL);
        highlight.setBackground(purdueGold);

        nameLabel.setFont(new Font("Serif", Font.BOLD, 25));
        nameLabel.setBackground(purdueGold);
        nameLabel.setOpaque(true);
    }

    public void addAction() {

        //adds action to every button
        backButton.addActionListener(this);
        addFriendButton.addActionListener(this);
        removeFriendButton.addActionListener(this);
        cancelFriendRequestButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            //takes you back to your profile
            if (e.getSource() == backButton) {
                Client.dos.writeUTF("3");
                Client.dos.writeUTF(myUsername);
                String username = Client.dis.readUTF();
                String password = Client.dis.readUTF();
                String email = Client.dis.readUTF();
                String realName = Client.dis.readUTF();
                String birthday = Client.dis.readUTF();
                String education = Client.dis.readUTF();
                String friends = Client.dis.readUTF();
                String friendRequests = Client.dis.readUTF();
                String bio = Client.dis.readUTF();
                String likes = Client.dis.readUTF();
                this.dispose();
                ProfileGUI p = new ProfileGUI(username, password, email, realName, birthday, education, friends, friendRequests, bio, likes);

                //sends a friends requests to the other user
            } else if (e.getSource() == addFriendButton) {
                Client.dos.writeUTF("6");
                Client.dos.writeUTF(myUsername);
                Client.dos.writeUTF(thisUsername);
                String check = Client.dis.readUTF();
                if (check.equals("AlreadyFriend")) {
                    JOptionPane.showMessageDialog(null, "You are already friends with " + thisUsername + "!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (check.equals("AlreadyRequested")) {
                    JOptionPane.showMessageDialog(null, "You have already sent a request to " + thisUsername + "!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (check.equals("AllGood")) {
                    JOptionPane.showMessageDialog(null, "Friend Request Sent!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (check.equals("Friended")) {
                    JOptionPane.showMessageDialog(null, "You guys are now friends!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                //cancels any sent friend request to the user
            } else if (e.getSource() == cancelFriendRequestButton) {
                Client.dos.writeUTF("7");
                Client.dos.writeUTF(myUsername);
                Client.dos.writeUTF(thisUsername);
                String check = Client.dis.readUTF();
                if (check.equals("AllGood")) {
                    JOptionPane.showMessageDialog(null, "You have cancelled your friend request with " + thisUsername + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else if (check.equals("FriendRequestNotFound")) {
                    JOptionPane.showMessageDialog(null, "You have not sent a friend request to " + thisUsername + "!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //removes both of the users as friends
            } else if (e.getSource() == removeFriendButton) {

                Client.dos.writeUTF("11");
                Client.dos.writeUTF(myUsername);
                Client.dos.writeUTF(thisUsername);
                String check = Client.dis.readUTF();
                if (check.equals("AllGood")) {
                    JOptionPane.showMessageDialog(null, "You are no longer friends with " + thisUsername + "!", "Sad", JOptionPane.INFORMATION_MESSAGE);
                    Client.dos.writeUTF("3");
                    Client.dos.writeUTF(myUsername);
                    String username = Client.dis.readUTF();
                    String password = Client.dis.readUTF();
                    String email = Client.dis.readUTF();
                    String realName = Client.dis.readUTF();
                    String birthday = Client.dis.readUTF();
                    String education = Client.dis.readUTF();
                    String friends = Client.dis.readUTF();
                    String friendRequests = Client.dis.readUTF();
                    String bio = Client.dis.readUTF();
                    String likes = Client.dis.readUTF();
                    this.dispose();
                    ProfileGUI p = new ProfileGUI(username, password, email, realName, birthday, education, friends, friendRequests, bio, likes);
                } else if (check.equals("Empty")) {

                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}