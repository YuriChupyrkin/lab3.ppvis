package Server;

import Server.View.MainFrame;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Server starting... ");
		MainFrame frame = new MainFrame();
		frame.runServer();
	}

}
