import java.net.*;
import java.io.*;
public class ServerSide
{
	public static void main (String args[])
	{
		ChatServer chatserver;
		chatserver = new ChatServer();
	}
}	
	
class ChatServer
{
	int port = 124;
	ServerSocket myServerSocket;
	Socket acceptedSocket;
	public ChatServer ()
	{
		for (int n = 0; n < 10; n++)
			System.out.println("I AM THE SERVER");
		 
		 try
		 {
		 	myServerSocket = new ServerSocket(port);
		 	System.out.println("Created the server Socket on port: " + port);
		 }
		 catch(IOException ioe)
		 {
		 	System.out.println("Error attempting to create Server Socket. Stopping program");
		 	System.exit(1);
		 }

		 while (true)
		 {
		 	try
		 	{
		 		acceptedSocket = myServerSocket.accept();
		 	}
		 	catch (IOException ioe)
		 	{
		 		System.out.println("Something went wrong creating a connection to a client");
		 	}
		 }

	}
}