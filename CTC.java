import java.io.*;
import java.net.*;

class CTC implements Runnable
{
	String msg;
	String protocol;
	Talker ctcTalker;
	Socket ctcSocket;
	String clientID;
	Boolean socketOpen;


	public CTC (Socket connectionToClient, String clientName)
	{
		ctcSocket = connectionToClient;
		clientID = clientName;
		ctcTalker = new Talker(connectionToClient, clientName);
		socketOpen = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	public void run()
	{
		while(socketOpen)
		{
			try
			{
				msg = ctcTalker.expected(" ");
				ctcHandleMsg(msg);
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
				System.out.println("Something went wrong in message reception...continuing operation");
			}
		}
	}///end of run

	public void ctcHandleMsg(String message)
	{
		
	}
}