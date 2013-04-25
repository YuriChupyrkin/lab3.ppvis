package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Server.View.MainFrame;

public class MenuListener extends AbstractAction{

	private MainFrame mainFrame;
	private String command;
	
	public MenuListener(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		command = arg0.getActionCommand();
		
		if(command.equals("LOAD")){
			System.out.println("LOAD!!!");
		}
		else if(command.equals("SETTING")){
			mainFrame.getAdapter().getData().changeLang("ru");
			mainFrame.getSettingDialog().runDialog();
		}
	}

	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
