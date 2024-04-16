import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ClientReceiver extends Thread{
    BufferedReader in;
    public void run(){
	while(true){
	    try{
		//Read in message and print if not null
	        //Sleep for 100 miliseconds if message is null
	    }catch(Exception e){
		System.out.println("ClientReceiver: " + e);
		System.exit(1);
	    }
	    
	}
    }
    ClientReceiver(BufferedReader in){
	//takes the input stream from the server socket connected to client instance
	this.in = in;
    }
}
