import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ChatServer{
    public static volatile ArrayList<Socket> connections = new ArrayList<>();
    public static volatile LinkedList<String> messages = new LinkedList<>();

    public static void main(String[] args){
	try{
	    //Fire up a ServerOutputThread
		ServerOutputThread outputThread = new ServerOutputThread();
		outputThread.start();
	    //Instantiate a ServerSocket in the below try parenthesis
	    try(ServerSocket serverSocket = new ServerSocket()){
		//bind() the socket to null
			serverSocket.bind(null);
		//print out the IP address using getInetAddress()
			System.out.println(serverSocket.getInetAddress());
		//print out the ephemeral Port using getLocalPort()
			System.out.println(serverSocket.getLocalPort());
		//construct a while loop to continually accept sockets
		while(true){
			try{
				Socket clientSocket = serverSocket.accept();
				System.out.println(clientSocket + " connected");
				ServerInputThread inputThread = new ServerInputThread(clientSocket);
                inputThread.start();
				System.out.println(inputThread);
			}
			catch(Exception e){}
		}
	    }catch(Exception e){
		System.out.println("ChatServer: "+e);
	    }
	}catch(Exception e){
	    System.out.println("ChatServer: "+e);
	}
    }

}
