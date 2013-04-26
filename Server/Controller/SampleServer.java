package Server.Controller;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import Server.Model.Data;
import Server.Model.PagingModel;
import Server.Model.Student;
import Server.View.MainFrame;


public class SampleServer extends Thread
{
    private Socket socket;
    private OutputStream os;
    private MainFrame mainFrame;
    private List<String>inList;

    public SampleServer(MainFrame mainFrame, Socket s)
    {
        // копируем данные
        this.socket = s;
        this.mainFrame = mainFrame;
        inList = new ArrayList<String>();
        

        // и запускаем новый вычислительный поток (см. ф-ю run())
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }
    
    public void run()
    {
        try
        {
            // из сокета клиента берём поток входящих данных
            InputStream is = socket.getInputStream();
            os = socket.getOutputStream();
            
            inList.clear();
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());            
            Object object = objectInput.readObject();
            inList =  (ArrayList<String>) object;
            
            
            if(inList.get(0).equals("add")){
            	addEl();
            }
            else if(inList.get(0).equals("get"))
            {
            	sendStudList();
            } 
            else if(inList.get(0).equals("remove"))
            {
            	removeEl();
            } 
            else if(inList.get(0).equals("search"))
            {
            	searchEl();
            } 
            
            socket.close();
        }
        catch(Exception e){
        	System.out.println("Server init error: "+e);
        } // вывод исключений
    }
    
    private void addEl(){
    	
    	Data data = mainFrame.getAdapter().getData();
    	data.studList.add(new Student(inList.get(1), inList.get(2), 
    			inList.get(3), inList.get(4), inList.get(5), 
    			inList.get(6), inList.get(7), inList.get(8)));
    	data.pagingModel = new PagingModel(data.studList);
    	mainFrame.getMainPanel().getTable().revalidate();
    	mainFrame.getMainPanel().getTable().repaint();
    }
    
    private void sendStudList(){
    	try{
	    	Data data = mainFrame.getAdapter().getData();
	    	List<String>outList = new ArrayList<String>();
	    	for(Student stud: data.studList){
	    		outList.add(stud.getFio());
	    		outList.add(stud.getCountry());
	    		outList.add(stud.getProvince());
	    		outList.add(stud.getCity());
	    		outList.add(stud.getStreet());
	    		outList.add(stud.getHouse());
	    		outList.add(stud.getHousing());
	    		outList.add(stud.getFlat());
	    	}
	    	ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
	    	objectOutput.writeObject(outList);
    	}
    	catch(Exception e){
    		System.out.println("SendStudList: ERROR");
    	}
    }
    
    public void removeEl(){
    	LanRemove lanRemove = new LanRemove(mainFrame);
    	lanRemove.removeEl(inList.get(1), inList.get(2), inList.get(3));
    	sendStudList();
    }
    
    public void searchEl(){
    	LanSearch lanSearch = new LanSearch(mainFrame);
    	lanSearch.searchEl(inList.get(1), inList.get(2), inList.get(3));
    	
    	try{
	    	Data data = mainFrame.getAdapter().getData();
	    	List<String>outList = new ArrayList<String>();
	    	for(Student stud: data.searchList){
	    		outList.add(stud.getFio());
	    		outList.add(stud.getCountry());
	    		outList.add(stud.getProvince());
	    		outList.add(stud.getCity());
	    		outList.add(stud.getStreet());
	    		outList.add(stud.getHouse());
	    		outList.add(stud.getHousing());
	    		outList.add(stud.getFlat());
	    	}
	    	ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
	    	objectOutput.writeObject(outList);
    	}
    	catch(Exception e){
    		System.out.println("SendStudList: ERROR");
    	}
    	
    }
    
}
