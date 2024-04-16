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
	    //Instantiate a ServerSocket in the below try parenthesis
	    try(){
		//bind() the socket to null
		//print out the IP address using getInetAddress()
		//print out the ephemeral Port using getLocalPort()
		//construct a while loop to continually accept sockets
	    }catch(Exception e){
		System.out.println("ChatServer: "+e);
	    }
	}catch(Exception e){
	    System.out.println("ChatServer: "+e);
	}
    }

}
