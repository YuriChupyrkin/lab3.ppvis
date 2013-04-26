package Client.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Client.Controller.Adapter;

public class Data {

	private Adapter adapter;
	private ResourceBundle resourceBundle;
	public List<Student>studList;
	public List<Student>searchList;
	public PagingModel pagingModel;
	public PagingModel searchPagingModel;
	private String ip;
	
	public Data(Adapter adapter) {
		super();
		this.adapter = adapter;
		
		//ip = "192.168.1.15";
		ip = "localhost";
		
		studList = new ArrayList<Student>();
		searchList = new ArrayList<Student>();
		
		/*for(int i = 0; i < 204; i++){
			studList.add(new Student("" + i, "2", "3", "4", "w", "w", "w", "w"));
		} */
				
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
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
}
