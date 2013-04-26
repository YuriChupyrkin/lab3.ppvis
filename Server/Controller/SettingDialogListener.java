package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Server.Model.Data;
import Server.View.MainFrame;

public class SettingDialogListener extends AbstractAction{

	private MainFrame mainFrame;
	
	public SettingDialogListener(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox langComboBox = mainFrame.getSettingDialog().langComboBox;
		Data data = mainFrame.getAdapter().getData();
		
		if((String)langComboBox.getSelectedItem() == "English"){
			data.changeLang("eng");
		}
		else if((String)langComboBox.getSelectedItem() == "Русский"){
			data.changeLang("ru");
		}
		mainFrame.getSettingDialog().setVisible(false);
	}

}
