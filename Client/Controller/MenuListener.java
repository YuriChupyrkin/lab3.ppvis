package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Client.View.ConnectDialog;
import Client.View.MainFrame;


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
		

		if	(command.equals("CONNECT")){
			ConnectDialog connectDialog = new ConnectDialog(mainFrame);
			connectDialog.runConnectDialog();
		}
		else if(command.equals("SETTING")){
			mainFrame.getSettingDialog().runDialog();
		}
		else if(command.equals("CLOSE")){
			System.exit(1);
		}
		else if(command.equals("ABOUT")){
			JOptionPane.showMessageDialog(mainFrame, "Лаб №3 по ППвИС\n" +
					"выполнил: Чупыркин Ю.А." );

		}
	}

	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
