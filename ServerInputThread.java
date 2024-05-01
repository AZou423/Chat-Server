import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerInputThread extends Thread{
	Socket clientSocket;
	BufferedReader reader;
	String input;
    public void run(){
	try{
	    //Read in a line representing the username
	    //Set the username field
		String username = reader.readLine();
		System.out.println(username + " has joined the chat");
	    //Add a new socket to the static connection list
		synchronized(ChatServer.connections){
			ChatServer.connections.add(clientSocket);
		}
	    //Continually read input from the client socket
		while(true){
			if((input = reader.readLine()) != null){
				synchronized (ChatServer.messages){
					System.out.println("Message added");
					ChatServer.messages.add(username + ": " + input);
				}
			}
		}
	    //Add that input to the messages list with the username infront "JR: lorum ipsum"
	}catch(Exception e){
	    System.out.println("ServerInputThread (run): " + e);
	    System.exit(1);
	}
    }

    public ServerInputThread(Socket clientSocket){
	try{
	    this.clientSocket = clientSocket; 
		this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}catch(Exception e){
	    System.out.println("ServerInputThread (Constructor)"+e);
	    System.exit(1);
	}
    }
}
