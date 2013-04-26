package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Client.View.RemoveDialog.ComboBoxItems;
import Client.View.SearchDialog;
import Client.View.SearchDialog.SearchComboBoxItems;


public class SearchDialogListener extends AbstractAction{

	private SearchDialog searchDialog;
	private String comand;
	private SearchElement searchElement;
	
	public SearchDialogListener(SearchDialog searchDialog) {
		super();
		this.searchDialog = searchDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comand = arg0.getActionCommand();
		
		if(comand.equals("COMBOBOX")){
			if(SearchComboBoxItems.firstIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("               номер дома");
				searchDialog.item2Label.setText("                  Фамилия");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("                    улица");
				searchDialog.item2Label.setText("                 квартира");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				searchDialog.item1Label.setText("                  фамилия");
				searchDialog.item2Label.setText("цифры встречающиеся в номере дома");
			}
		}
		else if(comand.equals("SEARCH")){
			searchElement = new SearchElement(this);
			searchElement.searchEl();
			searchDialog.getTable().revalidate();
			searchDialog.getTable().repaint();
			searchDialog.getMainFrame().getMainPanel().repaint();
		}
		
	}
	

	public SearchDialog getSearchDialog() {
		return searchDialog;
	}
	
	public SearchElement getSearchElement() {
		return searchElement;
	}


}
