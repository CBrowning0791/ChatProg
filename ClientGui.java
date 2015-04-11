import java.net.*;
import java.io.IOException;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.awt.List;
import java.awt.*;
import javax.swing.BoxLayout;
public class ClientGui
{
	public static void main (String args[])
	{
		ClientSideGui csg;
		System.out.println("Starting new client-side GUI");
		csg = new ClientSideGui();
	}	
}

class ClientSideGui extends JFrame implements ActionListener
{
	JFrame mainFrame;
	JButton loginButton;
	JButton registerButton;
	JButton friendRequestButton;
	JButton chatButton;
	JButton logOutButton;
	JDialog login;
	JPanel buttonPanel;
	JPanel buddyPanel;
	JPanel loginTestLayout;
	BoxLayout boxLayout;
	JTextField userNametextField;
	JTextField userPasstextField;
	JList buddyList;
	Socket serverSocket;
	CTS connectionToServer;
	//BorderLayout borderlayout;

	public ClientSideGui () 
	{
		JLabel userNameLabel = new JLabel ("User Name: ");
		JLabel passLabel = new JLabel ("Password: ");
////////////////////////////Setting up Test List//////////////////		
		DefaultListModel testList = new DefaultListModel();
		testList.addElement("Test Buddy 1");
		testList.addElement("Test Buddy 2");
		testList.addElement("Test Buddy 3");
		testList.addElement("Test Buddy 4");
		testList.addElement("Test Buddy 5");
		testList.addElement("Test Buddy 6");
		testList.addElement("Test Buddy 7");
		testList.addElement("Test Buddy 8");
		testList.addElement("Test Buddy 9");
		testList.addElement("Test Buddy 10");
		testList.addElement("Test Buddy 11");
		testList.addElement("Test Buddy 12");
		testList.addElement("Test Buddy 13");
		testList.addElement("Test Buddy 14");
		testList.addElement("Test Buddy 15");
		testList.addElement("Test Buddy 16");
		testList.addElement("Test Buddy 17");
		testList.addElement("Test Buddy 18");
		testList.addElement("Test Buddy 5");
		testList.addElement("Test Buddy 6");
		testList.addElement("Test Buddy 7");
		testList.addElement("Test Buddy 8");
		testList.addElement("Test Buddy 9");
		testList.addElement("Test Buddy 10");
		testList.addElement("Test Buddy 11");
		testList.addElement("Test Buddy 12");
		testList.addElement("Test Buddy 13");
		testList.addElement("Test Buddy 14");
		testList.addElement("Test Buddy 1");
		testList.addElement("Test Buddy 2");
		testList.addElement("Test Buddy 3");
		testList.addElement("Test Buddy 4");
		testList.addElement("Test Buddy 5");
		testList.addElement("Test Buddy 6");
		testList.addElement("Test Buddy 7");
		testList.addElement("Test Buddy 8");
		testList.addElement("Test Buddy 9");
		testList.addElement("Test Buddy 10");
		testList.addElement("Test Buddy 11");
		testList.addElement("Test Buddy 12");
		testList.addElement("Test Buddy 13");
		testList.addElement("Test Buddy 14");
		testList.addElement("Test Buddy 15");
		testList.addElement("Test Buddy 16");
		testList.addElement("Test Buddy 17");
		testList.addElement("Test Buddy 18");
		testList.addElement("Test Buddy 5");
		testList.addElement("Test Buddy 6");
		testList.addElement("Test Buddy 7");
		testList.addElement("Test Buddy 8");
		testList.addElement("Test Buddy 9");
		testList.addElement("Test Buddy 10");
		testList.addElement("Test Buddy 11");
		testList.addElement("Test Buddy 12");
		testList.addElement("Test Buddy 13");
		testList.addElement("Test Buddy 14");
//////////////////////////////////////////////////////////////////
		userPasstextField = new JTextField("Test",25);
		userNametextField = new JTextField(25);
		userPasstextField.setMaximumSize(new Dimension(1000000, 0));
		mainFrame = new JFrame("Chat Project");
		loginButton = new JButton ("Login");
		registerButton = new JButton ("Register");
		friendRequestButton = new JButton ("Add A Friend");
		chatButton = new JButton ("Chat");
		logOutButton = new JButton ("Log Out");
		login = new JDialog(mainFrame, "Login");
		loginTestLayout = new JPanel (new GridLayout(3,2,0,30));
		buttonPanel = new JPanel(new FlowLayout());
		buddyPanel = new JPanel();
		buddyList = new JList(testList);
		JScrollPane buddyListScroller = new JScrollPane(buddyList);
///////////////SETTING UP MAIN PROGRAM FRAME////////////////////

		buddyPanel.setLayout(new FlowLayout());
		buddyPanel.add(buddyListScroller);
		buttonPanel.setLayout(new GridLayout(3,1,0,0));
		buttonPanel.add(chatButton);
		buttonPanel.add(friendRequestButton);
		buttonPanel.add(logOutButton);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(buddyPanel, BorderLayout.WEST);
		mainFrame.add(buttonPanel, BorderLayout.CENTER);
		mainFrame.setSize(300, 180);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(false);
		mainFrame.setResizable(false);

///////////////Connecting to the server/////////////////////////
		try
		{
			serverSocket = new Socket(InetAddress.getLoopbackAddress(), 124);
		}
		catch(IOException ioe)
		{
			System.out.println("Error constructing socket to server. Ending program");
			System.exit(1);
		}
		connectionToServer = new CTS(serverSocket, "server");
///////////////END OF MAIN PROGRAM FRAME////////////////////////

///////////////SETTING UP LOGIN DIALOG/////////////////////////
		
		loginTestLayout.add(userNameLabel);
		loginTestLayout.add(userNametextField);
		loginTestLayout.add(passLabel);
		loginTestLayout.add(userPasstextField);
		loginTestLayout.add(loginButton);
		loginTestLayout.add(registerButton);
		login.setLayout(new BorderLayout());
		login.add(loginTestLayout, BorderLayout.CENTER);
		login.setSize(200,150);
		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.setResizable(false);

//////////////////END OF LOGIN DIALOG///////////////////////////


///////////////Setting Action Listeners and such///////////////

		loginButton.setActionCommand("LOGIN");
		loginButton.addActionListener(this);
		registerButton.setActionCommand("REGISTER");
		registerButton.addActionListener(this);
		chatButton.setActionCommand("CHAT");
		chatButton.addActionListener(this);
		friendRequestButton.setActionCommand("FRIEND");
		friendRequestButton.addActionListener(this);
		logOutButton.setActionCommand("LOGOUT");
		logOutButton.addActionListener(this);

///////////////End of Setting Action Listeners and such////////
	}

	public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("LOGIN"))
				{
					System.out.println("Login button pushed");
					mainFrame.setVisible(true);
					login.dispose();
				}
			if(e.getActionCommand().equals("REGISTER"))
			{
				System.out.println("Register button pushed");
				mainFrame.setVisible(true);
				login.dispose();
			}
			if(e.getActionCommand().equals("CHAT"))
			{
				System.out.println("Chat button pushed");
			}
			if(e.getActionCommand().equals("FRIEND"))
			{
				System.out.println("Friend button pushed");
			}
			if(e.getActionCommand().equals("LOGOUT"))
			{
				System.out.println("Logout button pushed");
			}
		}
}
