package Server.Model;

import java.awt.Component;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Server.Controller.Adapter;

public class Data {

	private Adapter adapter;
	private ResourceBundle resourceBundle;
	public PagingModel pagingModel;
	public PagingModel searchPagingModel;
	public List<Student>studList;
	public List<Student> searchList;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
		
		studList = new ArrayList<Student>();
		searchList = new ArrayList<Student>();
		
		for(int i = 0; i < 504; i++){
			studList.add(new Student("" + i, "2", "3", "4", "w", "w", "w", "w"));
		}
		
		resourceBundle = ResourceBundle.getBundle("lang", new Locale("en","EN"));
		pagingModel = new PagingModel(studList);
		searchPagingModel = new PagingModel(searchList);
	}

	
	
	
	
	
	public void changeLang(String lang){
		List<JMenuItem>itemsList = adapter.getMainFrame().itemsList;
		List<JMenu>menuList = adapter.getMainFrame().menuList;
		List<JButton>buttonList = adapter.getMainFrame().buttonList;
		
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
		for(JButton item: buttonList){
			item.setText((String)resourceBundle.getObject(item.getName()));
		}
		
		adapter.getMainFrame().revalidate();
		adapter.getMainFrame().repaint();
		adapter.getMainFrame().getMainPanel().revalidate();
		adapter.getMainFrame().getMainPanel().repaint();
	}
	
	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public PagingModel getPagingModel() {
		return pagingModel;
	}
	
	public PagingModel getSearchPagingModel() {
		return searchPagingModel;
	}

}
