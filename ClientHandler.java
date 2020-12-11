import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
/**
 * Client Handler for Social Media App
 * Accepts and processes user input from the GUI classes to manipulate the GUI and Profile classes, in order to handle the backend processing of the application.
 * The run() method in ClientHandler constantly accepts a signal from the Client class, and accepts input and procceses it according to that signal.
 * For example, the signal "1" is to register a new user, "2" is to try to login a user, "7" is to cancel a sent friend request, etc.
 * @author Siddhant Vashishtha, Roshan Barat
 * @version 12 - 7 - 2020
 */

public class ClientHandler extends Thread {
    Socket s;
    DataOutputStream dos;
    DataInputStream dis;

    public ClientHandler(Socket s, DataOutputStream dos, DataInputStream dis) {
        this.s = s;
        this.dos = dos;
        this.dis = dis;
    }

    synchronized public void run() {
        String signal = "";
        String username = "";
        String password = "";
        String email = "";

        //loop running all the time to check for every function happending

        gamer:
        while (true) {
            try {
                //accepts a signal for every function
                signal = dis.readUTF();

                //handles the registration of the user into the application
                if (signal.equals("1")) {
                    username = dis.readUTF();
                    password = dis.readUTF();
                    email = dis.readUTF();

                    //checks if username already exists
                    if (username.equals("usernames") || username.equals("default")) {
                        dos.writeUTF("UsernameisFound");
                        continue gamer;
                    }
                    FileReader fr = null;
                    try {
                        fr = new FileReader("usernames.txt");
                    } catch (FileNotFoundException e) {
                        throw new FileNotFoundException();
                    }
                    BufferedReader bfr = new BufferedReader(fr);
                    try {
                        String line = bfr.readLine();

                        while (line != null) {
                            if (line.equals(username)) {
                                dos.writeUTF("UsernameisFound");
                                continue gamer;

                            }
                            line = bfr.readLine();

                        }

                        //checks if username has a space in it
                        for (int i = 0; i < username.length(); i++) {
                            char ch = username.charAt(i);
                            if (ch == ' ') {
                                dos.writeUTF("SpaceUsername");
                                continue gamer;
                            }
                        }

                        //checks if the password is proper
                        if (password.length() < 8) {
                            dos.writeUTF("BadPassword");
                            continue gamer;
                        }
                        for (int i = 0; i < password.length(); i++) {
                            char ch = password.charAt(i);
                            if (ch == ' ') {
                                dos.writeUTF("BadPassword");
                                continue gamer;
                            }
                        }
                        int atCount = 0;
                        int dotCount = 0;
                        for (int i = 0; i < email.length(); i++) {
                            char ch = email.charAt(i);
                            if (ch == '@') {
                                atCount = i;
                            }

                            if (ch == '.') {
                                dotCount = i;
                            }
                        }

                        //checks if the email is proper
                        if (atCount < 1 || dotCount < 1 || atCount > dotCount) {
                            dos.writeUTF("BadEmail");
                            continue gamer;
                        }
                        //creates user file and updates name in usernames.txt
                        updateUsername(username);

                        File f1 = new File(username + ".txt");
                        PrintWriter pw = null;
                        try {
                            pw = new PrintWriter(f1);
                            pw.println("1 " + username);
                            pw.println("2 " + password);
                            pw.println("3 " + email);
                            pw.println("4 " + username);
                            pw.println("5 00/00/0000");
                            pw.println("6 Your School Here");
                            pw.println("7 ");
                            pw.println("8 ");
                            pw.println("9 Your bio here");
                            pw.println("10 Your likings here");


                            pw.flush();
                            pw.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        dos.writeUTF("AllGood");



                    } catch (Exception e) {

                    }

                    //handles the login of the user
                } else if (signal.equals("2")) {
                    username = dis.readUTF();
                    password = dis.readUTF();
                    FileReader fr = null;
                    try {
                        fr = new FileReader("usernames.txt");
                    } catch (FileNotFoundException e) {
                        throw new FileNotFoundException();
                    }
                    BufferedReader bfr = new BufferedReader(fr);

                    try {

                        String line = bfr.readLine();
                        boolean LoginUsernameFound = false;
                        while (line != null) {
                            if (line.equals(username)) {
                                LoginUsernameFound = true;
                                break;
                            }
                            line = bfr.readLine();
                        }
                        if (!LoginUsernameFound) {
                            dos.writeUTF("UsernameNotFound");
                        } else {
                            File userFile = new File(username + ".txt");
                            if (!userFile.exists()) {

                            }
                            try {
                                fr = new FileReader(userFile);
                            } catch (FileNotFoundException e) {
                                throw new FileNotFoundException();
                            }
                            BufferedReader userFilebfr = new BufferedReader(fr);
                            userFilebfr.readLine();
                            String filepassword = userFilebfr.readLine().substring(2);
                            if (!filepassword.equals(password)) {
                                dos.writeUTF("WrongPassword");
                            } else {
                                dos.writeUTF("AllGood");
                            }
                        }


                    } catch (Exception exception) {

                    }

                    //returns all information about a user to its respective GUI
                } else if (signal.equals("3")) {
                    username = dis.readUTF();

                    FileReader fr = null;
                    try {
                        fr = new FileReader(username + ".txt");


                    } catch (Exception e) {

                    }
                    BufferedReader bfr = new BufferedReader(fr);

                    try {
                        String line = bfr.readLine();
                        for (int i = 1; i <= 9; i++) {
                            dos.writeUTF(line.substring(line.indexOf(' ') + 1));
                            line = bfr.readLine();
                        }
                        dos.writeUTF(line.substring(line.indexOf(' ') + 1));



                    } catch (Exception e) {

                    }

                    //handles the updating and editing of a profile
                } else if (signal.equals("4")) {
                    username = dis.readUTF();
                    FileWriter fw = null;
                    BufferedWriter bw = null;
                    try {
                        fw = new FileWriter(username + ".txt");
                        bw = new BufferedWriter(fw);
                        bw.write("1 " + username);
                        bw.newLine();
                        for (int i = 1; i <= 9; i++) {
                            bw.write(dis.readUTF());
                            bw.newLine();
                        }
                        bw.close();

                    } catch (IOException e) {

                    } finally {
                        try {
                            if (bw != null)
                                bw.close();
                        } catch (IOException e) {}
                        try {
                            if (fw != null)
                                fw.close();
                        } catch (IOException e) {}
                    }

                    FileReader fr = null;
                    try {
                        fr = new FileReader(username + ".txt");


                    } catch (Exception e) {

                    }
                    BufferedReader bfr = new BufferedReader(fr);

                    try {
                        String line = bfr.readLine();
                        for (int i = 1; i <= 9; i++) {
                            dos.writeUTF(line.substring(line.indexOf(' ') + 1));
                            line = bfr.readLine();
                        }
                        dos.writeUTF(line.substring(line.indexOf(' ') + 1));



                    } catch (Exception e) {

                    }





                    //integrated with the search button. searches for a profile and sends relevant information to OtherProfileGUI class
                } else if (signal.equals("5")) {
                    username = dis.readUTF();
                    FileReader fr = null;
                    try {
                        fr = new FileReader("usernames.txt");
                    } catch (FileNotFoundException e) {
                        throw new FileNotFoundException();
                    }
                    BufferedReader bfr = new BufferedReader(fr);

                    try {

                        String line = bfr.readLine();
                        boolean LoginUsernameFound = false;
                        while (line != null) {
                            if (line.equals(username)) {
                                LoginUsernameFound = true;
                                break;
                            }
                            line = bfr.readLine();
                        }
                        if (!LoginUsernameFound) {
                            dos.writeUTF("UsernameNotFound");
                        } else {
                            dos.writeUTF("UsernameFound");
                            fr = null;
                            try {
                                fr = new FileReader(username + ".txt");


                            } catch (Exception e) {

                            }
                            bfr = new BufferedReader(fr);

                            try {
                                line = bfr.readLine();
                                for (int i = 1; i <= 9; i++) {
                                    if (i == 2 || i == 7 || i == 8) {
                                        line = bfr.readLine();
                                        continue;
                                    }
                                    dos.writeUTF(line.substring(line.indexOf(' ') + 1));
                                    line = bfr.readLine();
                                }
                                dos.writeUTF(line.substring(line.indexOf(' ') + 1));



                            } catch (Exception e) {

                            }
                        }


                    } catch (Exception exception) {

                    }


                    //adds a friend request in a users profile
                } else if (signal.equals("6")) {
                    String myUsername = dis.readUTF();
                    String theirUsername = dis.readUTF();
                    FileReader fr = null;
                    BufferedReader br = null;
                    String line = "";
                    try {
                        fr = new FileReader(theirUsername + ".txt");
                        br = new BufferedReader(fr);
                        for (int i = 0; i < 6; i++) {
                            br.readLine();
                        }
                        //check to see if a they are alredy friends
                        line = br.readLine();
                        line = line.substring(line.indexOf(' ') + 1);
                        String[] friendNames = line.split("[ ]", 0);
                        for (String s: friendNames) {
                            if (s.equals(myUsername)) {
                                dos.writeUTF("AlreadyFriend");
                                continue gamer;
                            }
                        }
                        //check to see if a friend request was already sent or not
                        line = br.readLine();
                        line = line.substring(line.indexOf(' ') + 1);
                        String[] friendRequestNames = line.split("[ ]", 0);
                        for (String s: friendRequestNames) {
                            if (s.equals(myUsername)) {
                                dos.writeUTF("AlreadyRequested");
                                continue gamer;
                            }
                        }

                        //check to see if both have sent each other a friend request. if they have automatically adds them as friends.
                        boolean check = checkFriendRequests(myUsername, theirUsername);
                        if (check) {
                            removeFriendRequest(theirUsername, myUsername);
                            addFriend(myUsername, theirUsername);
                            addFriend(theirUsername, myUsername);
                            dos.writeUTF("Friended");
                            continue gamer;
                        }

                        sendFriendRequest(myUsername, theirUsername);
                        dos.writeUTF("AllGood");

                    } catch (IOException e) {

                    }

                    //cancels a sent friend request from the user
                } else if (signal.equals("7")) {
                    String myUsername = dis.readUTF();
                    String theirUsername = dis.readUTF();
                    FileReader fr = null;
                    BufferedReader br = null;
                    String line = "";
                    try {
                        fr = new FileReader(theirUsername + ".txt");
                        br = new BufferedReader(fr);
                        for (int i = 0; i < 7; i++) {
                            br.readLine();
                        }
                        line = br.readLine();
                        line = line.substring(line.indexOf(' ') + 1);
                        String[] friendRequestNames = line.split("[ ]", 0);
                        for (String s: friendRequestNames) {
                            if (s.equals(myUsername)) {
                                removeFriendRequest(myUsername, theirUsername);
                                dos.writeUTF("AllGood");
                                continue gamer;
                            }
                        }
                        dos.writeUTF("FriendRequestNotFound");
                    } catch (IOException e) {

                    }

                    //created the all users drop down menu in the Main Profile GUI
                } else if (signal.equals("8")) {
                    FileReader fr = null;
                    try {
                        fr = new FileReader("usernames.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String line = br.readLine();
                        String allUsers = "";
                        while (line != null) {
                            allUsers = allUsers + " " + line;
                            line = br.readLine();
                        }
                        dos.writeUTF(allUsers.trim());

                    } catch (IOException e) {

                    }

                    //integrated with accept friend button. adds two users as friends
                } else if (signal.equals("9")) {
                    String myUsername = dis.readUTF();
                    String theirUsername = dis.readUTF();
                    if (theirUsername.trim().equals("")) {
                        dos.writeUTF("Empty");
                    } else {
                        removeFriendRequest(theirUsername, myUsername);
                        addFriend(myUsername, theirUsername);
                        addFriend(theirUsername, myUsername);
                        dos.writeUTF("AllGood");
                    }

                    //declines a friend request sent from a user
                } else if (signal.equals("10")) {
                    String myUsername = dis.readUTF();
                    String theirUsername = dis.readUTF();
                    if (theirUsername.trim().equals("")) {
                        dos.writeUTF("Empty");
                    } else {

                        removeFriendRequest(theirUsername, myUsername);
                        dos.writeUTF("AllGood");
                    }

                    //removes a user as friends
                } else if (signal.equals("11")) {
                    String myUsername = dis.readUTF();
                    String theirUsername = dis.readUTF();
                    boolean check = checkFriends(myUsername, theirUsername);
                    if (check) {
                        if (theirUsername.trim().equals("") || myUsername.trim().equals("")) {
                            dos.writeUTF("Empty");
                        } else {

                            removeFriend(myUsername, theirUsername);
                            removeFriend(theirUsername, myUsername);
                            dos.writeUTF("AllGood");
                        }
                    } else {
                        dos.writeUTF("Empty");
                    }

                    //deletes the entire profile
                } else if (signal.equals("12")) {
                    String myUsername = dis.readUTF();
                    deleteProfile(myUsername);
                }




            } catch (Exception e) {

            }
        }
    }

    //deletes the profile of a user
    synchronized public void deleteProfile(String myUsername) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            fr = new FileReader("usernames.txt");
            br = new BufferedReader(fr);
            String line = br.readLine();
            ArrayList < String > all = new ArrayList < > ();

            while (line != null) {
                if (line.equals(myUsername)) {
                    line = br.readLine();
                } else {
                    removeFriend(myUsername, line);
                    removeFriend(line, myUsername);
                    removeFriendRequest(myUsername, line);
                    removeFriendRequest(line, myUsername);
                    all.add(line);
                    line = br.readLine();
                }
            }

            fw = new FileWriter("usernames.txt");
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            for (String s: all) {
                pw.println(s);
            }
            pw.close();

        } catch (IOException e) {

        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {}
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {}
        }

        dos.writeUTF("AllGood");



    }

    //removes two users as friends
    synchronized public void removeFriend(String myUsername, String theirUsername) {
        String username = "";
        String password = "";
        String email = "";
        String realName = "";
        String birthday = "";
        String education = "";
        String friends = "";
        String friendRequests = "";
        String bio = "";
        String likes = "";
        FileReader fr = null;
        try {
            fr = new FileReader(theirUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            username = br.readLine();
            password = br.readLine();
            email = br.readLine();
            realName = br.readLine();
            birthday = br.readLine();
            education = br.readLine();
            friends = br.readLine();
            if (friends.contains(myUsername)) {
                String tem = myUsername + " ";
                friends = friends.replaceAll(tem, "");

                tem = " " + myUsername;
                friends = friends.replaceAll(tem, "");
                friends = friends + " ";
            }
            friendRequests = br.readLine();
            bio = br.readLine();
            likes = br.readLine();


            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(theirUsername + ".txt");
                bw = new BufferedWriter(fw);
                bw.write(username);
                bw.newLine();
                bw.write(password);
                bw.newLine();
                bw.write(email);
                bw.newLine();
                bw.write(realName);
                bw.newLine();
                bw.write(birthday);
                bw.newLine();
                bw.write(education);
                bw.newLine();
                bw.write(friends);
                bw.newLine();
                bw.write(friendRequests);
                bw.newLine();
                bw.write(bio);
                bw.newLine();
                bw.write(likes);
                bw.newLine();
                bw.close();

            } catch (IOException e) {

            } finally {
                try {
                    if (bw != null)
                        bw.close();
                } catch (IOException e) {}
                try {
                    if (fw != null)
                        fw.close();
                } catch (IOException e) {}
            }


        } catch (IOException e) {

        }

    }

    //adds two users as friends
    synchronized public void addFriend(String myUsername, String theirUsername) {
        String username = "";
        String password = "";
        String email = "";
        String realName = "";
        String birthday = "";
        String education = "";
        String friends = "";
        String friendRequests = "";
        String bio = "";
        String likes = "";
        FileReader fr = null;
        try {
            fr = new FileReader(theirUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            username = br.readLine();
            password = br.readLine();
            email = br.readLine();
            realName = br.readLine();
            birthday = br.readLine();
            education = br.readLine();
            friends = br.readLine();
            if (friends.charAt(friends.length() - 1) == ' ') {
                friends = friends + myUsername;
            } else {
                friends = friends + " " + myUsername;
            }
            friendRequests = br.readLine();
            bio = br.readLine();
            likes = br.readLine();


            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                fw = new FileWriter(theirUsername + ".txt");
                bw = new BufferedWriter(fw);
                bw.write(username);
                bw.newLine();
                bw.write(password);
                bw.newLine();
                bw.write(email);
                bw.newLine();
                bw.write(realName);
                bw.newLine();
                bw.write(birthday);
                bw.newLine();
                bw.write(education);
                bw.newLine();
                bw.write(friends);
                bw.newLine();
                bw.write(friendRequests);
                bw.newLine();
                bw.write(bio);
                bw.newLine();
                bw.write(likes);
                bw.newLine();
                bw.close();

            } catch (IOException e) {

            } finally {
                try {
                    if (bw != null)
                        bw.close();
                } catch (IOException e) {}
                try {
                    if (fw != null)
                        fw.close();
                } catch (IOException e) {}
            }


        } catch (IOException e) {

        }
    }

    //checks if a friend request was aleady sent by  user, returns appropriate value
    synchronized public boolean checkFriendRequests(String myUsername, String theirUsername) {

        String friendRequests = "";
        FileReader fr = null;
        try {
            fr = new FileReader(myUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 1; i <= 7; i++) {
                br.readLine();
            }
            friendRequests = br.readLine();

            friendRequests = friendRequests.substring(friendRequests.indexOf(' ') + 1);
            String[] friendRequestNames = friendRequests.split("[ ]", 0);
            for (String s: friendRequestNames) {
                if (s.equals(theirUsername)) {
                    return true;
                }
            }
            return false;


        } catch (IOException e) {

        }
        return false;
    }

    //checks if two people are already friends, returns appropriate value
    synchronized public boolean checkFriends(String myUsername, String theirUsername) {
        String friends = "";
        FileReader fr = null;
        try {
            fr = new FileReader(myUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 1; i <= 6; i++) {
                br.readLine();
            }
            friends = br.readLine();

            friends = friends.substring(friends.indexOf(' ') + 1);
            String[] friendRequestNames = friends.split("[ ]", 0);
            for (String s: friendRequestNames) {
                if (s.equals(theirUsername)) {
                    return true;
                }
            }
            return false;


        } catch (IOException e) {

        }
        return false;
    }

    //removes a sent friend request from a user
    synchronized public void removeFriendRequest(String myUsername, String theirUsername) {
        String username = "";
        String password = "";
        String email = "";
        String realName = "";
        String birthday = "";
        String education = "";
        String friends = "";
        String friendRequests = "";
        String bio = "";
        String likes = "";
        FileReader fr = null;
        try {
            fr = new FileReader(theirUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            username = br.readLine();
            password = br.readLine();
            email = br.readLine();
            realName = br.readLine();
            birthday = br.readLine();
            education = br.readLine();
            friends = br.readLine();
            friendRequests = br.readLine();
            if (friendRequests.contains(myUsername)) {
                String tem = myUsername + " ";
                friendRequests = friendRequests.replaceAll(tem, "");

                tem = " " + myUsername;
                friendRequests = friendRequests.replaceAll(tem, "");
                friendRequests = friendRequests + " ";
            }
            bio = br.readLine();
            likes = br.readLine();


        } catch (IOException e) {

        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(theirUsername + ".txt");
            bw = new BufferedWriter(fw);
            bw.write(username);
            bw.newLine();
            bw.write(password);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(realName);
            bw.newLine();
            bw.write(birthday);
            bw.newLine();
            bw.write(education);
            bw.newLine();
            bw.write(friends);
            bw.newLine();
            bw.write(friendRequests);
            bw.newLine();
            bw.write(bio);
            bw.newLine();
            bw.write(likes);
            bw.newLine();
            bw.close();

        } catch (IOException e) {

        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {}
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {}
        }
    }

    //sends a friend request from one user to the other
    synchronized public void sendFriendRequest(String myUsername, String theirUsername) {
        String username = "";
        String password = "";
        String email = "";
        String realName = "";
        String birthday = "";
        String education = "";
        String friends = "";
        String friendRequests = "";
        String bio = "";
        String likes = "";
        FileReader fr = null;
        try {
            fr = new FileReader(theirUsername + ".txt");
            BufferedReader br = new BufferedReader(fr);
            username = br.readLine();
            password = br.readLine();
            email = br.readLine();
            realName = br.readLine();
            birthday = br.readLine();
            education = br.readLine();
            friends = br.readLine();
            friendRequests = br.readLine();
            if (friendRequests.charAt(friendRequests.length() - 1) == ' ') {
                friendRequests = friendRequests + myUsername;
            } else {
                friendRequests = friendRequests + " " + myUsername;
            }
            bio = br.readLine();
            likes = br.readLine();


        } catch (IOException e) {

        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(theirUsername + ".txt");
            bw = new BufferedWriter(fw);
            bw.write(username);
            bw.newLine();
            bw.write(password);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(realName);
            bw.newLine();
            bw.write(birthday);
            bw.newLine();
            bw.write(education);
            bw.newLine();
            bw.write(friends);
            bw.newLine();
            bw.write(friendRequests);
            bw.newLine();
            bw.write(bio);
            bw.newLine();
            bw.write(likes);
            bw.newLine();
            bw.close();

        } catch (IOException e) {

        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {}
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {}
        }
    }


    //updates the main usernames.txt file to adds users
    synchronized public void updateUsername(String s) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("usernames.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(s);
            pw.close();

        } catch (IOException e) {

        } finally {
            if (pw != null)
                pw.close();
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {}
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {}
        }
    }
}