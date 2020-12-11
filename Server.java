import java.io.*;
import java.net.*;

/**
 * Handles the creation of ServerSocket , DataInputStream and DataOutputStream objects
 * for the server to communicate with a client, and creates a new thread for each client that connects to the server.
 * @author Roshan Barat, Shruti Goyal, Tushar Singh
 * @version 12 - 7 - 2020
 */

public class Server extends Thread implements Runnable {

    public static void main(String[] args) throws IOException {
        // Opens server socket on port 7777
        ServerSocket serverSocket = new ServerSocket(7777);

        // Loops while clients are accessing server
        while (true) {
            Socket socket = null;
            try {
                // Accepts client connection to server socket
                socket = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                // Opens a new thread for each new client
                Thread thread = new ClientHandler(socket, dos, dis);
                //
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}