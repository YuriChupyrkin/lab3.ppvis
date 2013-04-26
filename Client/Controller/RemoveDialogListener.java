package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Client.View.MainFrame;
import Client.View.RemoveDialog;
import Client.View.RemoveDialog.ComboBoxItems;


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
				removeDialog.item1Label.setText("               ����� ����");
				removeDialog.item2Label.setText("                  �������");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				removeDialog.item1Label.setText("                    �����");
				removeDialog.item2Label.setText("                 ��������");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				removeDialog.item1Label.setText("                  �������");
				removeDialog.item2Label.setText("����� ������������� � ������ ����");
			}
		}
		else if(comand.equals("REMOVE")){
			RemoveElements removeElements = new RemoveElements(this);
			removeElements.revomeEl();		
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
