package Server.Controller;

import java.util.List;

import javax.swing.JOptionPane;

import Server.Model.Data;
import Server.Model.Student;
import Server.View.RemoveDialog.ComboBoxItems;
import Server.View.SearchDialog;

public class SearchElement {

	private List<Student> studList;
	private List<Student> searchList;
	private SearchDialogListener searchDialogListener;
	//private SearchTableModel searchTableModel;
	private SearchDialog searchDialog;
	
	public SearchElement(SearchDialogListener searchDialogListener) {
		super();
		this.searchDialogListener = searchDialogListener;
		studList = getData().studList;
		searchList = getData().searchList;
		//searchTableModel = getData().getSearchTableModel();
		searchDialog = searchDialogListener.getSearchDialog();
	}
	
	
	public void searchEl(String type){
		if(type.equals("local")){
			searchElLocal();
		}
	}
	
	public void searchElLocal(){
		getData().searchList.clear();	

		if(searchDialog.item1Text.getText().length() > 0 && searchDialog.item2Text.getText().length() > 0){
			for(int index = 0; index < studList.size(); index++){
				
				Student stud = studList.get(index);
				
				if(ComboBoxItems.firstIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
					if(stud.getFio().indexOf(searchDialog.item2Text.getText()) != -1 && stud.getHouse().equals(searchDialog.item1Text.getText())){
						if(stud.getFio().length() > searchDialog.item2Text.getText().length()){
							if(stud.getFio().toCharArray()[searchDialog.item2Text.getText().length()] == ' '){
								getData().searchList.add(studList.get(index));
							}
						}
						else {
							if(stud.getFio().equals(searchDialog.item2Text.getText())){
								getData().searchList.add(studList.get(index));
							}
						}
					}
				}
				else if(ComboBoxItems.secondIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
					if(stud.getFlat().equals(searchDialog.item2Text.getText()) && stud.getStreet().equals(searchDialog.item1Text.getText())){
						searchList.add(studList.get(index));
					}
				}
				else if(ComboBoxItems.thirdIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
						if(stud.getHouse().indexOf(searchDialog.item2Text.getText()) != -1
								&& stud.getFio().indexOf(searchDialog.item1Text.getText()) != -1){
							if(stud.getFio().length() > searchDialog.item1Text.getText().length()){
								if(stud.getFio().toCharArray()[searchDialog.item1Text.getText().length()] == ' '){					
									getData().searchList.add(studList.get(index));
									}
								}
												
							else{
								if(stud.getFio().equals(searchDialog.item1Text.getText())){
									getData().searchList.add(studList.get(index));
								}
							}
						}
				} 
				
			}
		}
		
		else{
			JOptionPane.showMessageDialog(searchDialog.getMainFrame(), "Не корректный запрос!" );
		}
		searchDialog.countLabel.setText(String.valueOf(getData().searchList.size()));
	}
	
	
	
	public List<Student> getSearchList() {
		return searchList;
	}
	
	public Data getData(){
		return searchDialogListener.getSearchDialog().getMainFrame().getAdapter().getData();
	}
}
