package Server.View;

import java.util.ResourceBundle;

import javax.swing.*;

public class MenuBar extends JMenuBar{

	private MainFrame mainFrame;
	JMenu fileMenu;
	JMenu actionMenu;
	
	
	private enum fileMenuItems{
		load("load", "LOAD"),
		save("save", "SAVE"),
		setting("setting", "SETTING");
		
		private final String NAME;
		private final String COMAND;
		fileMenuItems(String name, String comand){
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
		
		actionMenu = new JMenu();
		actionMenu.setName("actionMenu");
		actionMenu.setText((String)resourceBundle.getObject(actionMenu.getName()));
		
		for(fileMenuItems item: fileMenuItems.values()){
			JMenuItem menuItem = new JMenuItem();
			menuItem.setName(item.NAME);
			menuItem.setText(menuItem.getName());
			menuItem.setActionCommand(item.COMAND);
			mainFrame.itemsList.add(menuItem);
			menuItem.addActionListener(mainFrame.getMenuListener());
			fileMenu.add(menuItem);
		}
		
		
		
		mainFrame.menuList.add(fileMenu);	 
		mainFrame.menuList.add(actionMenu);
		this.add(fileMenu);
		this.add(actionMenu);
	}

	
}
