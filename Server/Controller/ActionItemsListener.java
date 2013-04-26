package Server.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Server.View.AddDialog;
import Server.View.MainFrame;
import Server.View.RemoveDialog;
import Server.View.SearchDialog;

public class ActionItemsListener extends AbstractAction{

	private MainFrame mainFrame;
	private String comand;
	private AddDialog addDialog;
	
	public ActionItemsListener(MainFrame frame) {
		super();
		this.mainFrame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		comand = e.getActionCommand();
		
		if(comand.equals("ADD")){
			addDialog = new AddDialog(mainFrame);
			addDialog.runAddDialog();
		}
		else if(comand.equals("REMOVE")){
			RemoveDialog removeDialog = new RemoveDialog(mainFrame);
			removeDialog.runRemoveDialog(); 
		}
		else if(comand.equals("SEARCH")){
			SearchDialog searchDialog = new SearchDialog(mainFrame);
			searchDialog.getMainFrame().getAdapter().getData().searchList.clear();
			searchDialog.getTable().revalidate();
			searchDialog.getTable().repaint();
			searchDialog.runSearchDialog(); 
		}
		
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
}
