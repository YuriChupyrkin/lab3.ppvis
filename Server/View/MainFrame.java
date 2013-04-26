package Server.View;

import java.awt.Component;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuListener;

import Server.Controller.Adapter;
import Server.Controller.*;

public class MainFrame extends JFrame{

	private Adapter adapter;
	public List<JMenuItem> itemsList;
	public List<JMenu> menuList;
	public List<JButton> buttonList;
	private MenuBar menuBar;
	private Server.Controller.MenuListener menuListener;
	private SettingDialog settingDialog;
	private MainPanel mainPanel;
	private ActionItemsListener actionItemsListener;
	
	public MainFrame() throws HeadlessException {
		super();
		this.setTitle("Server");
		this.setSize(800, 600);
		this.setLocation(70, 70);
		
		itemsList = new ArrayList<JMenuItem>();
		menuList = new ArrayList<JMenu>();
		buttonList = new ArrayList<JButton>();
		
		adapter = new Adapter(this);
		menuListener = new Server.Controller.MenuListener(this);
		settingDialog = new SettingDialog(this);
		actionItemsListener = new ActionItemsListener(this);
		
		menuBar = new MenuBar(this);
		mainPanel = new MainPanel(this);
		
		this.setJMenuBar(menuBar);
		this.add(mainPanel);	
	}
	
	public void runServer(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public Adapter getAdapter() {
		return adapter;
	}
	
	public Server.Controller.MenuListener getMenuListener() {
		return menuListener;
	}
	
	public SettingDialog getSettingDialog() {
		return settingDialog;
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public ActionItemsListener getActionItemsListener() {
		return actionItemsListener;
	}
}
