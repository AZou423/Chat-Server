import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerOutputThread extends Thread{
	private void broadcast(String message){
		for(Socket socket: ChatServer.connections){
			try{
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println(message);
				out.flush();
			}
			catch(Exception e){}
		}
	}
    public void run(){
	try{
		while(true){
			if(ChatServer.messages.isEmpty() == false){
				String chat;
				synchronized (ChatServer.messages){
					chat = ChatServer.messages.pop();
					broadcast(chat);
				}
				// synchronized(ChatServer.messages){
				// 	for(Socket socket: ChatServer.connections){
				// 		try{
				// 			PrintWriter out = new PrintWriter(socket.getOutputStream());
				// 			out.println(message);
				// 			out.flush();
				// 		}
				// 		catch(Exception e){}
				// 	}
				// }
			}
			else{
				Thread.sleep(100);
			}
		}
	    //Continually loop through all messages
	    //If queue is not empty then pop message off the queue
	    //Loop through all connections and send popped message to each connection
	    //Sleep for 100 miliseconds if the queue is currently empty
	}
	catch(Exception e){
	    System.out.println("ServerOutputThread (run): " + e);
	}
    }
}
