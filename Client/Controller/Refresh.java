package Client.Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import Client.Model.Data;
import Client.Model.Student;

public class Refresh {

	private Data data;
	
	public Refresh(Data data) {
		super();
		this.data = data;
	}


	public void refreshEl(){
		try{
            Socket s = new Socket(data.getIp(), 3128);
            
            List<String>studStrList = new ArrayList<String>();
            studStrList.add("get");
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
        }
        catch(Exception e){
        System.out.println("Client init error: "+e);
        } 
	}
	
	public Data getData() {
		return data;
	}
}
