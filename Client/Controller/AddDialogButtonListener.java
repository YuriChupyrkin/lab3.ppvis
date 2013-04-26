package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Client.View.AddDialog;
import Client.View.MainPanel;


public class AddDialogButtonListener extends AbstractAction{

	private AddDialog addDialog;
	private String comand;
	
	public AddDialogButtonListener(AddDialog addDialog) {
		super();
		this.addDialog = addDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
			if(addDialog.getFioText().getText().length() > 0 && addDialog.getCountryText().getText().length() > 0 &&
					addDialog.getProvinceText().getText().length() > 0 && addDialog.getCityText().getText().length() > 0
					&& addDialog.getStreetText().getText().length() > 0 
					&& addDialog.getHouseText().getText().length() > 0){
				
				AddElementCommand addElement = new AddElementCommand(this);
				addElement.add(addDialog.getFioText().getText(), addDialog.getCountryText().getText(),
						addDialog.getProvinceText().getText(), addDialog.getCityText().getText(),
						addDialog.getStreetText().getText(), addDialog.getHouseText().getText(),
						addDialog.getHousingText().getText(), addDialog.getFlatText().getText());
				addDialog.setVisible(false);
				MainPanel mainPanel = addDialog.getMainFrame().getMainPanel();
				mainPanel.getTable().revalidate();
				mainPanel.getTable().repaint();				
				mainPanel.repaint();
			}
			else{
				JOptionPane.showMessageDialog(addDialog.getMainFrame(), "Незаполнено обязательное поле!");
			}
		
	}
	
	///////////////////////  Getters  ///////////////
	public AddDialog getAddDialog() {
		return addDialog;
	}

}
