package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Client.View.SearchDialog;


public class SearchTableListener extends AbstractAction{

	private SearchDialog searchDialog;
	private String command;
	
	public SearchTableListener(SearchDialog searchDialog) {
		super();
		this.searchDialog = searchDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		command = arg0.getActionCommand();
		
		if(command.equals("downButton")){
			searchDialog.model.pageDown();
		    if (searchDialog.model.getPageOffset() == (searchDialog.model.getPageCount() - 1)) {
		    	searchDialog.downButton.setEnabled(false);
		     }
		    searchDialog.upButton.setEnabled(true);		
		}
		else if(command.equals("upButton")){
			searchDialog.model.pageUp();
	        if (searchDialog.model.getPageOffset() == 0) {
	        	searchDialog.upButton.setEnabled(false);
	        }
	        searchDialog.downButton.setEnabled(true);     
		}
		
	}

}
