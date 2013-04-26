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
import Client.View.RemoveDialog;
import Client.View.RemoveDialog.ComboBoxItems;


public class RemoveElements {

	private RemoveDialogListener removeDialogListener;
	private Data data;
	private RemoveDialog removeDialog;
	
	public RemoveElements(RemoveDialogListener removeDialogListener) {
		super();
		this.removeDialogListener = removeDialogListener;
		removeDialog = removeDialogListener.getRemoveDialog();
	}
	

	public void revomeEl(){	
		try{
			data = removeDialog.getMainFrame().getAdapter().getData();
            Socket s = new Socket(data.getIp(), 3128);
            
            List<String>studStrList = new ArrayList<String>();
            studStrList.add("remove");
            
			if(ComboBoxItems.firstIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				studStrList.add("1");
			}
			else if(ComboBoxItems.secondIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				studStrList.add("2");
			}
			else if(ComboBoxItems.thirdIt.ITEM  == (String)removeDialog.comboBox.getSelectedItem()){
				studStrList.add("3");
			}
			studStrList.add(removeDialog.item1Text.getText());
            studStrList.add(removeDialog.item2Text.getText());
			
            ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
            objectOutput.writeObject(studStrList); 
                
            ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());          
            Object object = objectInput.readObject();
           	ArrayList<String>getStrList = (ArrayList<String>) object;
           	
           	data.studList.clear();
           	
           	int count = 0;
           	for(int index = 0; index < getStrList.size() / 8; index++){
           		data.studList.add(new Student(getStrList.get(0 + count), 
           				getStrList.get(1 + count), getStrList.get(2 + count),
           				getStrList.get(3 + count), getStrList.get(4 + count),
           				getStrList.get(5 + count), getStrList.get(6 + count),
           				getStrList.get(7 + count)));
           		count += 8;
           	}
           	
           	JTable table = data.getAdapter().getMainFrame().getMainPanel().getTable();
			table.revalidate();
			table.repaint();
			
			removeDialog.setVisible(false);
			
		}
		catch(Exception e){
		        System.out.println("Client init error: "+e);
		} 
	}	
	
}
