package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;

import Client.Model.Data;
import Client.View.MainFrame;


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
