package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Server.View.MainFrame;
import Server.View.RemoveDialog;
import Server.View.RemoveDialog.ComboBoxItems;

public class RemoveDialogListener extends AbstractAction{

	private RemoveDialog removeDialog;
	private String comand;
	
	public RemoveDialogListener(RemoveDialog removeDialog) {
		super();
		this.removeDialog = removeDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
		if(comand.equals("COMBOBOX")){
			if(ComboBoxItems.firstIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				removeDialog.item1Label.setText("               номер дома");
				removeDialog.item2Label.setText("                  Фамилия");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				removeDialog.item1Label.setText("                    улица");
				removeDialog.item2Label.setText("                 квартира");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				removeDialog.item1Label.setText("                  фамилия");
				removeDialog.item2Label.setText("цифры встречающиеся в номере дома");
			}
		}
		else if(comand.equals("REMOVE")){
			RemoveElements removeElements = new RemoveElements(this);
			removeElements.removeEl("local");		
			removeDialog.getMainFrame().getMainPanel().repaint();
		}
		
	}
	
	
	///////////////////////  Getters  //////////////////////
	public RemoveDialog getRemoveDialog() {
		return removeDialog;
	}
	
	public MainFrame getMainFrame(){
		return removeDialog.getMainFrame();
	}


}
