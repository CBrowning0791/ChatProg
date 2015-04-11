import java.io.*;
import java.net.*;

class Talker 
{
	Socket openSocket;
	String otherSide;
	private DataOutputStream dos;
	//private DataInputStream dis;
	private BufferedReader br;

	//public static void main(String[] args)
	//{}

	public Talker (String domain, int port, String who) throws UnknownHostException, IOException
	{
		try {
				openSocket = new Socket(domain, port);
				otherSide = new String(who);
				dos = new DataOutputStream(openSocket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(openSocket.getInputStream()));
			}
		catch (UnknownHostException e)
			{
				System.out.println("Domain Not Recognized, Input Domain: " + domain);
				throw new UnknownHostException ("Domain Not Recognized");
			}
		catch (IOException r)
			{
				throw new IOException ("Something went wrong in IO");
			}
	}

	public Talker (Socket socketToOpen, String who)
	{
		openSocket = new Socket();
		openSocket = socketToOpen;
		otherSide = new String (who);
	}

	public void send (String message) throws IOException
	{
		try {
				//dos = new DataOutputStream(openSocket.getOutputStream());
				System.out.println("Sent >> " + message);
				message += '\n';
				dos.writeBytes(message);
			}
		catch(IOException e)
			{
				System.out.println("Something went wrong in IO comms to the socket");
				throw new IOException("Something went wrong in IO");
			}
	}

	private String recieve() throws IOException 
	{
		try {
				//dis = new DataInputStream(openSocket.getInputStream());
				String recieved = new String (br.readLine());
				System.out.println("Recieved From: " + otherSide + " >> " + recieved);
				recieved.toLowerCase();
				return recieved;
			}
		catch (IOException e) 
			{
				System.out.println("Something went wrong when recieveing IO from socket");
				throw new IOException("Something went wrong in IO");
			}	
	}

	public String expected(String checkString) throws IOException
	{
		String stringFromServer = new String (recieve());
		checkString.toLowerCase();
		if (checkString.equals(" "))
			return stringFromServer;
		if (checkString.startsWith(stringFromServer))
		{
			return stringFromServer;
		}			
		else
		{
			return checkString = "Bad Return";
		}

	}
}


