package Client.Controller;

import Client.Model.Data;
import Client.View.MainFrame;

public class Adapter {

	private MainFrame mainFrame;
	private Data data;
	
	public Adapter(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		data = new Data(this);
	}

	
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Data getData() {
		return data;
	}

}
