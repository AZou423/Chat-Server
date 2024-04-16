import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerInputThread extends Thread{

    public void run(){
	try{
	    //Read in a line representing the username
	    //Set the username field
	    //Add a new socket to the static connection list

	    //Continually read input from the client socket
	    //Add that input to the messages list with the username infront "JR: lorum ipsum"
	}catch(Exception e){
	    System.out.println("ServerInputThread (run): " + e);
	    System.exit(1);
	}
    }

    public ServerInputThread(Socket clientSocket){
	try{
	    //Set the appropriate fields 
	}catch(Exception e){
	    System.out.println("ServerInputThread (Constructor)"+e);
	    System.exit(1);
	}
    }
}
