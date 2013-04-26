package Client.Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Client.Model.Data;
import Client.Model.Student;
import Client.View.MainFrame;
import Client.View.SearchDialog;
import Client.View.RemoveDialog.ComboBoxItems;

public class SearchElement {

	private SearchDialogListener searchDialogListener;
	private SearchDialog searchDialog;
	
	public SearchElement(SearchDialogListener searchDialogListener) {
		super();
		this.searchDialogListener = searchDialogListener;
		this.searchDialog = searchDialogListener.getSearchDialog();

	}
	
	
	
	public void searchEl(){
		
		MainFrame mainFrame = searchDialog.getMainFrame();
		Adapter adapter = mainFrame.getAdapter();
		Data data = adapter.getData();
		try{
            Socket s = new Socket(data.getIp(), 3128);
            
            List<String>studStrList = new ArrayList<String>();
            studStrList.add("search");
            
			if(ComboBoxItems.firstIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				studStrList.add("1");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				studStrList.add("2");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)searchDialog.comboBox.getSelectedItem()){
				studStrList.add("3");
			}
			studStrList.add(searchDialog.item1Text.getText());
            studStrList.add(searchDialog.item2Text.getText());
			
            ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
            objectOutput.writeObject(studStrList); 
                
            ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());          
            Object object = objectInput.readObject();
           	ArrayList<String>getStrList = (ArrayList<String>) object;
           	
           	data.searchList.clear();
           	
           	int count = 0;
           	for(int index = 0; index < getStrList.size() / 8; index++){
           		data.searchList.add(new Student(getStrList.get(0 + count), 
           				getStrList.get(1 + count), getStrList.get(2 + count),
           				getStrList.get(3 + count), getStrList.get(4 + count),
           				getStrList.get(5 + count), getStrList.get(6 + count),
           				getStrList.get(7 + count)));
           		count += 8;
           	}	
		}
		catch(Exception e){
		        System.out.println("Client init error: "+e);
		} 
	
	}
}
