package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

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
		if
		(command.equals("SAVE")){
			System.out.println("SAVE!!!");
		}
		else if(command.equals("SETTING")){
			mainFrame.getSettingDialog().runDialog();
		}
		if(command.equals("CLOSE")){
			System.exit(1);
		}
		if(command.equals("ABOUT")){
			JOptionPane.showMessageDialog(mainFrame, "Лаб №3 по ППвИС\n" +
					"выполнил: Чупыркин Ю.А." );

		}
	}

	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
