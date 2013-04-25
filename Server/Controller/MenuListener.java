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
			mainFrame.getAdapter().getLoaderSaver().saveDialog("load");
		}
		else if	(command.equals("NEW")){
			mainFrame.getAdapter().getLoaderSaver().saveDialog("new");
		}
		else if	(command.equals("SAVE")){
			mainFrame.getAdapter().getLoaderSaver().saveAs();
		}
		else if(command.equals("SETTING")){
			mainFrame.getSettingDialog().runDialog();
		}
		else if(command.equals("CLOSE")){
			mainFrame.getAdapter().getLoaderSaver().saveDialog("close");
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
