package Client.Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import Client.Model.Data;
import Client.Model.PagingModel;
import Client.Model.Student;


public class AddElementCommand {
	private Data data;
	
	public AddElementCommand(AddDialogButtonListener dialogButtonListener) {
		super();
		data = dialogButtonListener.getAddDialog().getData();
	}
	
	public void add(String fio, String country, String province, String city,
			String street, String house, String housing, String flat){	
		try
        {
            Socket s = new Socket(data.getIp(), 3128);        
            List<String>studListStr = new ArrayList<String>();
            studListStr.add("add");
            
            studListStr.add(fio);
            studListStr.add(country);
            studListStr.add(province);
            studListStr.add(city);
            studListStr.add(street);
            studListStr.add(house);
            studListStr.add(housing);
            studListStr.add(flat);
            
            ObjectOutputStream objectOutput = new ObjectOutputStream(s.getOutputStream());
            objectOutput.writeObject(studListStr); 
            
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
           	
        }
        catch(Exception e){
        System.out.println("Client init error: "+e);
        } // вывод исключений     
	}

}
