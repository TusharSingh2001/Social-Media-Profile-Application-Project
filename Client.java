import java.io.*;
import java.net.*;

/**
 * Creates Socket, DataInputStream and DataOutputStream objects in order for the client machine to communicate with the server.
 * Then, starts the application GUI by displaying the login screen.
 * @author Roshan Barat, Siddhant Vashishtha
 * @version 12 - 7 - 2020
 */

public class Client {

    public static DataInputStream dis;
    public static DataOutputStream dos;

    public static void main(String[] args) throws IOException {
        //connects to the server
        Socket socket = new Socket("localhost", 7777);

        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        //opens up the loginpageGUI

        LoginPage lp = new LoginPage();
        lp.main();
    }


}