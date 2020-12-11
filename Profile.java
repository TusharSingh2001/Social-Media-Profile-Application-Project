import java.util.*;

/**
 * Saves all the information for each profile in a class in order to get/set the values from that class.
 * Also processes information from user file to the application to handle formatting.
 * Profile class
 * @author Roshan Barat, Shruti Goyal, Tushar Singh
 * @version 12 - 7 - 2020
 */

public class Profile {
    //constructor used to create ProfileGUI
    private String userName;
    private String realName;
    private String likes;
    private String password;
    private ArrayList < String > friends = new ArrayList < > ();
    private String bio;
    private String birthday;
    private String email;
    private String education;
    private ArrayList < String > friendRequests = new ArrayList < > ();

    public Profile(String userName, String password, String email, String realName, String birthday, String education, String friends, String friendRequests, String bio, String likes) {
        this.userName = userName;
        this.realName = realName;
        this.email = email;
        this.birthday = birthday;
        this.education = education;
        this.bio = bio;
        this.likes = likes;
        this.password = password;
        try {

            String[] splited = friends.split("[ ]", 0);
            Collections.addAll(this.friends, splited);


            splited = friendRequests.split("[ ]", 0);
            Collections.addAll(this.friendRequests, splited);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Profile(String username, String email, String realName, String birthday, String education, String bio, String likes) {
        //constructor used to create OtherProfileGUI
        this.userName = username;
        this.realName = realName;
        this.email = email;
        this.birthday = birthday;
        this.education = education;
        this.bio = bio;
        this.likes = likes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public ArrayList < String > getFriends() {
        return friends;
    }

    public void setFriends(ArrayList < String > friends) {
        this.friends = friends;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public ArrayList < String > getFriendRequests() {
        return friendRequests;
    }

    public void setFriendRequests(ArrayList < String > friendRequests) {
        this.friendRequests = friendRequests;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}