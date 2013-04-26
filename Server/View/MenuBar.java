package Server.View;

import java.util.ResourceBundle;

import javax.swing.*;

public class MenuBar extends JMenuBar{

	private MainFrame mainFrame;
	JMenu fileMenu;
	JMenu helpMenu;
	JMenu actionMenu;
	JMenuItem about;
	
	
	private enum fileMenuItems{
		New("new", "NEW"),
		load("load", "LOAD"),
		save("save", "SAVE"),
		setting("setting", "SETTING"),
		close("close", "CLOSE");
		
		private final String NAME;
		private final String COMAND;
		fileMenuItems(String name, String comand){
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	
	private enum actionMenuItems{
		add("add", "ADD"),
		remove("remove", "REMOVE"),
		search("search", "SEARCH");
		
		private final String NAME;
		private final String COMAND;
		actionMenuItems(String name, String comand){
			this.NAME = name;
			this.COMAND = comand;
		}
	}
	
	public MenuBar(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		
		ResourceBundle resourceBundle = mainFrame.getAdapter().getData().getResourceBundle();
		
		fileMenu = new JMenu();
		fileMenu.setName("fileMenu");
		fileMenu.setText((String)resourceBundle.getObject(fileMenu.getName()));
		
		helpMenu = new JMenu();
		helpMenu.setName("helpMenu");
		helpMenu.setText((String)resourceBundle.getObject(helpMenu.getName()));
		
		actionMenu = new JMenu();
		actionMenu.setName("actionMenu");
		actionMenu.setText((String)resourceBundle.getObject(actionMenu.getName()));
		
		about = new JMenuItem();
		about.setName("about");
		about.setText((String)resourceBundle.getObject(about.getName()));
		about.setActionCommand("ABOUT");
		about.addActionListener(mainFrame.getMenuListener());
		mainFrame.itemsList.add(about);		
		helpMenu.add(about);
		
		for(fileMenuItems item: fileMenuItems.values()){
			JMenuItem menuItem = new JMenuItem();
			menuItem.setName(item.NAME);
			menuItem.setText(menuItem.getName());
			menuItem.setActionCommand(item.COMAND);
			mainFrame.itemsList.add(menuItem);
			menuItem.addActionListener(mainFrame.getMenuListener());
			fileMenu.add(menuItem);
		}
		
		for(actionMenuItems item: actionMenuItems.values()){
			JMenuItem menuItem = new JMenuItem();
			menuItem.setName(item.NAME);
			menuItem.setText(menuItem.getName());
			menuItem.setActionCommand(item.COMAND);
			mainFrame.itemsList.add(menuItem);
			menuItem.addActionListener(mainFrame.getActionItemsListener());
			actionMenu.add(menuItem);
		}
	
		mainFrame.menuList.add(fileMenu);	 
		mainFrame.menuList.add(helpMenu);
		mainFrame.menuList.add(actionMenu);
		this.add(fileMenu);
		this.add(actionMenu);
		this.add(helpMenu);
	}

	
}
