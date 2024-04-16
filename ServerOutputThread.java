import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerOutputThread extends Thread{
    public void run(){
	try{
	    //Continually loop through all messages
	    //If queue is not empty then pop message off the queue
	    //Loop through all connections and send popped message to each connection
	    //Sleep for 100 miliseconds if the queue is currently empty
	}
	}catch(Exception e){
	    System.out.println("ServerOutputThread (run): " + e);
	}
    }
}
