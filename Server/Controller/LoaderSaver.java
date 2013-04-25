package Server.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Server.Model.Data;
import Server.Model.PagingModel;
import Server.Parsers.SAXPars;
import Server.View.MainPanel;

public class LoaderSaver {

	private Adapter adapter;
	private File file;
	private String fileName;
	private JFileChooser fileChooser;
	private TextFileFilter xmlFilter;
	
	public LoaderSaver(Adapter adapter) {
		super();
		this.adapter = adapter;
		fileChooser = new  JFileChooser();
		xmlFilter = new  TextFileFilter(".xml");

	}
	
	
	public void saveDialog(String action){	
		if(!adapter.getData().studList.isEmpty()){
			int messageType = JOptionPane.QUESTION_MESSAGE;
		    String[] options = {"yes", "no", "cancel"};
		    int code = JOptionPane.showOptionDialog(adapter.getMainFrame(), 
		         "Save xml file?", 
		         " ", 0, messageType, 
		         null, options, "yes");
		    
			 if(code == 0){
		    	  saveAs();
		    	  if(action == "load"){
		    		  loadFile();
		    	  }
		    	  else if(action == "close")
		    	  {
		    		  System.exit(1);
		    	  }
		    	  else if(action == "new")
		    	  {
		    		  newFile();
		    	  }
		     }
			 else  if(code == 1){
		    	  if(action == "close"){
			    	  System.exit(1);
		    	  }
		    	  else if(action == "load"){
		    		  loadFile();
		    	  }
		    	  else if(action == "new"){
		    		  newFile();
		    	  }
		     }
		}
		else{
			 if(action == "close"){
		    	  System.exit(1);
	    	  }
	    	  else if(action == "load"){
	    		  loadFile();
	    	  }
	    	  else if(action == "new"){
	    		  newFile();
	    	  }
		}
	}

	
	private void newFile(){
		Data data = adapter.getData();
		data.studList.clear();
		data.pagingModel = new PagingModel(data.studList);
		MainPanel mainPanel = data.getAdapter().getMainFrame().getMainPanel();
		mainPanel.getTable().revalidate();
		mainPanel.getTable().repaint();
		mainPanel.repaint();

	}
	
	private void loadFile(){

		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(xmlFilter); 
	    int  result1 = fileChooser.showOpenDialog(null);		   
	    if(result1==JFileChooser.APPROVE_OPTION)
	    {
	        fileName = fileChooser.getSelectedFile().getAbsolutePath();
	        file = new  File(fileName);
	        
	        try{
	        	adapter.getData().studList.clear();
	        	adapter.getData().pagingModel = new PagingModel(adapter.getData().studList);
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser parser = factory.newSAXParser();
				SAXPars saxp = new SAXPars(adapter);
				
				parser.parse(new File(fileName), saxp);
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}

	     }
	    MainPanel mainPanel = adapter.getData().getAdapter().getMainFrame().getMainPanel();
		mainPanel.getTable().revalidate();
	    mainPanel.getTable().repaint();
	    mainPanel.repaint();
	}
	
	public void saveAs(){
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(xmlFilter);
			int  result = fileChooser.showSaveDialog(null);
	        if(result==JFileChooser.APPROVE_OPTION)
	        {
	        	fileName = fileChooser.getSelectedFile().getAbsolutePath() + ".xml";
	        	adapter.getDomPars().writeFile(fileName);
	        }
	}

}
