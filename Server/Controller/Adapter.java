package Server.Controller;

import Server.View.MainFrame;

public class Adapter {

	private MainFrame mainFrame;
	
	public Adapter(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		
	}
	
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
}
