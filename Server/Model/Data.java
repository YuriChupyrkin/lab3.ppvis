package Server.Model;

import java.awt.Component;
import java.util.*;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Server.Controller.Adapter;

public class Data {

	private Adapter adapter;
	private ResourceBundle resourceBundle;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
		
		resourceBundle = ResourceBundle.getBundle("lang", new Locale("en","EN"));
	}

	
	public void changeLang(String lang){
		List<JMenuItem>itemsList = adapter.getMainFrame().itemsList;
		List<JMenu>menuList = adapter.getMainFrame().menuList;
		
		if(lang.equals("eng")){
			resourceBundle = ResourceBundle.getBundle("lang", new Locale("en","EN"));			
		}
		else if(lang.equals("ru")){
			resourceBundle = ResourceBundle.getBundle("lang", new Locale("ru","RU"));
		}
		
		
		for(JMenuItem item: itemsList){
			item.setText((String)resourceBundle.getObject(item.getName()));
		}
		for(JMenu item: menuList){
			item.setText((String)resourceBundle.getObject(item.getName()));
		}
		
		adapter.getMainFrame().revalidate();
		adapter.getMainFrame().repaint();
	}
	
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
