import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ChatClient{
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try{
	    //Connect to the server by instantiating a Socket object
        Socket socket = new Socket(hostName, portNumber);
	    //Set the Socket output stream to a PrintWriter object
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream()); //not sure abt this line
	    //Set the Socket input stream to a Buffered Reader 
        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));        	    
	    //Read in username from terminal
        System.out.print("Enter a username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        System.out.println("Welcome " + username + "!");
        System.out.println("To start chatting just type!");
	    //Send username string to server
        socketOut.println(username);
        socketOut.flush();
	    //Fire up a ClientReceiver thread
        ClientReceiver reciever = new ClientReceiver(socketInput);
        reciever.start();
	    //Chatting below
	    String userInput;
	    while ((userInput = in.nextLine()) != null) {
		socketOut.println(userInput);
        socketOut.flush();
            }
        } catch (Exception e) {
            System.err.println("ChatClient: " + e);
            System.exit(1);
        }
    }


}
