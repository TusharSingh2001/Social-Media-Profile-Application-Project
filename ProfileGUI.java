import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Profile GUI
 *
 * Creates the GUI for a user looking at their own profile. The GUI contains the following features:
 *
 * Profile Area - To view Bio, Username, Real Name, Likes, Birthday, Email, Education
 * Friends List - Lists all the users current friends
 * Friend Requests - Lists all the users current incoming friend requests. There are buttons to both accept and decline a given friend request.
 * All Users Tab - Lists all the users currently on the server. You can access anyone's profile by selecting their username and pressing the "Go to profile" button underneath it.
 * Search Bar - Allows you to search for a specific user on the server. You can go to their profile by selecting their username and pressing the "Go to profile" button.
 * Logout button - Logs the user out and returns to the login GUI.
 * Refresh button - Refreshes the page to check for any incoming friend requests.
 * Edit button - Allows user to edit the information in their profile. Takes them to the ProfileEditPage GUI
 *
 * @author Shruti Goyal, Roshan Barat, Siddhant Vashishtha
 * @version 12 - 7 - 2020
 */

public class ProfileGUI extends JFrame implements ActionListener {


    //Declares the initial container and items for the GUI
    Container container = getContentPane();
    JLabel friendRequests = new JLabel("Friend Requests", SwingConstants.CENTER);
    JLabel nameLabel;
    JLabel usernameLabel;
    JLabel likesLabel;
    JLabel bioLabel;
    JLabel birthdayLabel;
    JLabel emailLabel;
    JLabel educationLabel;
    JButton refresh = new JButton("Refresh");
    JButton edit = new JButton("Edit");
    JTextField search = new JTextField("Enter Username");


    JLabel usernameTagLabel = new JLabel("Username: ");
    JLabel likesTagLabel = new JLabel("Likes: ");
    JLabel birthdayTagLabel = new JLabel("Birthday: ");
    JLabel emailTagLabel = new JLabel("Email: ");
    JLabel educationTagLabel = new JLabel("Education: ");

    JSeparator vert = new JSeparator();
    JSeparator highlight = new JSeparator();

    JLabel myFriends = new JLabel("My Friends", SwingConstants.CENTER);
    JComboBox friendsList;

    JButton goToProfileButton = new JButton("Go To Profile");

    JButton acceptFriendRequest = new JButton("Accept Request");
    JButton declineFriendRequest = new JButton("Decline Request");
    JButton logoutButton = new JButton("Logout");


    JComboBox friendRequestsList;

    JLabel allUsersLabel = new JLabel("All Users", SwingConstants.CENTER);
    JComboBox allUserList;

    //Uses a Profile object to gain access to profile variables, in order to update GUI
    Profile myProfile;


    //Constructs a ProfileGUI object
    public ProfileGUI(String username, String password, String email, String realName, String birthday, String education, String friends, String friendRequests, String bio, String likes) throws IOException {
        myProfile = new Profile(username, password, email, realName, birthday, education, friends, friendRequests, bio, likes);
        main();

        getValues(myProfile);
        container.setLayout(null);
        setLocationAndSize();
        styling();
        addComponentsToContainer();
        addAction();
    }

    public void getValues(Profile myProfile) throws IOException {
        //Retrieves values for each label in the GUI from the created profile object
        String bio = "<html><p>" + myProfile.getBio() + "</p></html>";
        nameLabel = new JLabel(myProfile.getRealName(), SwingConstants.CENTER);
        usernameLabel = new JLabel(myProfile.getUserName());
        emailLabel = new JLabel(myProfile.getEmail());
        bioLabel = new JLabel(bio);
        educationLabel = new JLabel(myProfile.getEducation());
        birthdayLabel = new JLabel(myProfile.getBirthday());
        String likes = "<html><p>" + myProfile.getLikes() + "</p></html>";
        likesLabel = new JLabel(likes);

        String[] stringOfFriends = myProfile.getFriends().toArray(new String[1]);
        friendsList = new JComboBox(stringOfFriends);
        String[] stringOfFriendRequests = myProfile.getFriendRequests().toArray(new String[1]);
        friendRequestsList = new JComboBox(stringOfFriendRequests);

        //Sends a signal to ClientHandler to build a menu using the usernames.txt file
        Client.dos.writeUTF("8");
        String allUsers = Client.dis.readUTF();
        String[] all = allUsers.split("[ ]", 0);
        allUserList = new JComboBox(all);
        allUserList.addActionListener(this);
        friendRequestsList.addActionListener(this);
        friendsList.addActionListener(this);
    }

    public void main() throws IOException {
        //Sets specific information of the frame
        this.setTitle("My Profile");
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(10, 10, 740, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setLocationAndSize() {

        //Sets the Bounds for all objects in the container
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

        myFriends.setBounds(10, 10, 180, 30);
        friendsList.setBounds(10, 50, 180, 100);

        friendRequests.setBounds(10, 180, 180, 30);
        friendRequestsList.setBounds(10, 220, 180, 100);

        allUsersLabel.setBounds(10, 530, 180, 30);
        allUserList.setBounds(10, 570, 180, 100);

        edit.setBounds(490, 700, 100, 30);
        search.setBounds(220, 700, 260, 30);
        goToProfileButton.setBounds(10, 700, 180, 30);
        refresh.setBounds(610, 700, 100, 30);
        logoutButton.setBounds(610, 660, 100, 30);

        acceptFriendRequest.setBounds(10, 330, 180, 30);
        declineFriendRequest.setBounds(10, 370, 180, 30);

    }

    public void styling() {
        //Adds color to the header labels, and sets other style features
        Color purdueGold = new Color(255, 215, 0);
        vert.setOrientation(SwingConstants.VERTICAL);
        highlight.setOrientation(SwingConstants.HORIZONTAL);
        highlight.setBackground(purdueGold);

        myFriends.setBackground(purdueGold);
        myFriends.setForeground(Color.BLACK);
        myFriends.setOpaque(true);
        myFriends.setFont(new Font("Serif", Font.BOLD, 18));

        friendRequests.setBackground(purdueGold);
        friendRequests.setForeground(Color.BLACK);
        friendRequests.setOpaque(true);
        friendRequests.setFont(new Font("Serif", Font.BOLD, 18));

        allUsersLabel.setBackground(purdueGold);
        allUsersLabel.setForeground(Color.BLACK);
        allUsersLabel.setOpaque(true);
        allUsersLabel.setFont(new Font("Serif", Font.BOLD, 18));

        nameLabel.setFont(new Font("Serif", Font.BOLD, 25));
        nameLabel.setBackground(purdueGold);
        nameLabel.setOpaque(true);
    }

    public void addComponentsToContainer() {

        //Adds all elements of the GUI to the main container
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
        container.add(myFriends);
        container.add(friendRequests);
        container.add(friendsList);
        container.add(goToProfileButton);
        container.add(friendRequestsList);
        container.add(refresh);
        container.add(edit);
        container.add(search);
        container.add(likesLabel);
        container.add(allUserList);
        container.add(allUsersLabel);
        container.add(declineFriendRequest);
        container.add(acceptFriendRequest);
        container.add(logoutButton);
    }

    public void addAction() {
        //Adds all buttons to an ActionListener
        edit.addActionListener(this);
        refresh.addActionListener(this);
        goToProfileButton.addActionListener(this);
        acceptFriendRequest.addActionListener(this);
        declineFriendRequest.addActionListener(this);
        logoutButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //Sets the functionality for each button using the ActionListener interface
        try {
            //Sets the text from any combobox to the search bar text
            if (e.getSource().getClass() == JComboBox.class) {

                JComboBox cb = (JComboBox) e.getSource();
                String choice = (String) cb.getSelectedItem();
                search.setText(choice);
            }

            //Opens edit GUI
            if (e.getSource() == edit) {
                this.dispose();
                ProfileEditPage pep = new ProfileEditPage(myProfile);

            } else if (e.getSource() == goToProfileButton) {
                //Finds a user profile through the searchbar text
                String searchbarText = search.getText().trim();
                if (searchbarText.equals(myProfile.getUserName())) {
                    JOptionPane.showMessageDialog(null, "You cannot search for yourself", "Just why", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Sends profile username to the server, retrieves Profile information if successful
                    Client.dos.writeUTF("5");
                    Client.dos.writeUTF(searchbarText);
                    String check = Client.dis.readUTF();
                    if (check.equals("UsernameNotFound")) {
                        JOptionPane.showMessageDialog(null, "The user you searched for was not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (check.equals("UsernameFound")) {
                        String username = Client.dis.readUTF();
                        String email = Client.dis.readUTF();
                        String realName = Client.dis.readUTF();
                        String birthday = Client.dis.readUTF();
                        String education = Client.dis.readUTF();
                        String bio = Client.dis.readUTF();
                        String likes = Client.dis.readUTF();
                        this.dispose();
                        OtherProfileGUI p = new OtherProfileGUI(username, email, realName, birthday, education, bio, likes, myProfile.getUserName());
                    }
                }


            }

            if (e.getSource() == logoutButton) {
                //Opens login page
                this.dispose();
                LoginPage lp = new LoginPage();
                lp.main();
            }

            if (e.getSource() == refresh) {
                //Re-opens ProfileGUI (Same way that someone would log-in initially)
                Client.dos.writeUTF("3");
                Client.dos.writeUTF(myProfile.getUserName());
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
            }

            if (e.getSource() == acceptFriendRequest) {
                //Sends a username to server to add them as a friend
                Client.dos.writeUTF("9");
                Client.dos.writeUTF(myProfile.getUserName());
                Client.dos.writeUTF((String) friendRequestsList.getSelectedItem());
                String check = Client.dis.readUTF();
                if (check.equals("AllGood")) {
                    JOptionPane.showMessageDialog(null, "You are now Friends!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    Client.dos.writeUTF("3");
                    Client.dos.writeUTF(myProfile.getUserName());
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

            if (e.getSource() == declineFriendRequest) {
                //Sends a username to server to remove their friend request
                Client.dos.writeUTF("10");
                Client.dos.writeUTF(myProfile.getUserName());
                Client.dos.writeUTF((String) friendRequestsList.getSelectedItem());
                String check = Client.dis.readUTF();
                if (check.equals("AllGood")) {
                    JOptionPane.showMessageDialog(null, "You have declined the friend request!", "Sad", JOptionPane.INFORMATION_MESSAGE);

                    Client.dos.writeUTF("3");
                    Client.dos.writeUTF(myProfile.getUserName());
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