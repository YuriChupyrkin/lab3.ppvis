package Server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Server.View.MainFrame;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Server starting... ");	
		try {
			InetAddress ownIP = InetAddress.getLocalHost();
			MainFrame frame = new MainFrame(ownIP.getHostAddress());
			frame.runServer(); 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
