package Server.View;

import java.awt.HeadlessException;

import javax.swing.*;

public class MainFrame extends JFrame{

	public MainFrame() throws HeadlessException {
		super();
		this.setTitle("Server");
		this.setSize(800, 600);
		this.setLocation(70, 70);
		
	}
	
	public void runServer(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
}
