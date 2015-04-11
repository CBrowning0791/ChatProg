import java.io.*;
import java.net.*;

class CTS implements Runnable
{
	String msg;
	String protocol;
	Talker ctsTalker;
	Socket ctsSocket;
	String serverID;
	boolean socketIsOpen;

	public CTS (Socket connectionToServer, String serverName)
	{
		ctsTalker = new Talker(connectionToServer, serverName);
		socketIsOpen = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while(socketIsOpen)
		{
			try
			{
				msg = ctsTalker.expected(" ");
				handleMessage(msg);
			}
			catch(IOException io)
			{
				io.printStackTrace();
				System.out.println("Something went wrong in message reception...continuing operation");
			}
		}
	}

	public void handleMessage(String msg)
	{

	}
}	
