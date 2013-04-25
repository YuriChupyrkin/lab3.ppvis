package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Server.View.MainFrame;

public class SettingDialogListener extends AbstractAction{

	private MainFrame mainFrame;
	private String command;
	
	public SettingDialogListener(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		command = arg0.getActionCommand();
		if((String)mainFrame.getSettingDialog().langComboBox.getSelectedItem() == "English"){
			mainFrame.getAdapter().getData().changeLang("eng");
		}
		else if((String)mainFrame.getSettingDialog().langComboBox.getSelectedItem() == "Русский"){
			mainFrame.getAdapter().getData().changeLang("ru");
		}
		mainFrame.getSettingDialog().setVisible(false);
	}

}
