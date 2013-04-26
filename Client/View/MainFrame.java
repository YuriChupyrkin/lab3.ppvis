package Client.View;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



import Client.Controller.ActionItemsListener;
import Client.Controller.Adapter;
import Client.Controller.MenuListener;

public class MainFrame extends JFrame{

	public List<JMenuItem> itemsList;
	public List<JMenu> menuList;
	public List<JButton> buttonList;
	
	private Adapter adapter;
	private MenuBar menuBar;
	private MenuListener menuListener;
	private SettingDialog settingDialog;
	private ActionItemsListener actionItemsListener;
	
	public MainFrame() throws HeadlessException {
		super();
		this.setTitle("Client");
		this.setSize(800, 600);
		this.setLocation(600, 70);
		
		itemsList = new ArrayList<JMenuItem>();
		menuList = new ArrayList<JMenu>();
		buttonList = new ArrayList<JButton>();
		
		adapter = new Adapter(this);
		menuListener = new MenuListener(this);
		settingDialog = new SettingDialog(this);
		actionItemsListener = new ActionItemsListener(this);
		
		menuBar = new MenuBar(this);
		this.setJMenuBar(menuBar);
	}
	
	
	public void run(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public Adapter getAdapter() {
		return adapter;
	}

	
	public MenuListener getMenuListener() {
		return menuListener;
	}
	
	public SettingDialog getSettingDialog() {
		return settingDialog;
	}
	
	public ActionItemsListener getActionItemsListener() {
		return actionItemsListener;
	}
	
}
