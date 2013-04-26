package Server.View;

import java.awt.Component;
import java.awt.HeadlessException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MenuListener;

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
	private String serverIp;
	private WindowListener windowListener;
	
	public MainFrame(String ip) throws HeadlessException {
		super();
		
		this.serverIp = ip;
		this.setTitle("Server");
		this.setSize(800, 600);
		this.setLocation(70, 70);
		
		itemsList = new ArrayList<JMenuItem>();
		menuList = new ArrayList<JMenu>();
		buttonList = new ArrayList<JButton>();
		
		adapter = new Adapter(this);
		adapter.getData().setServerIp(ip);
		menuListener = new Server.Controller.MenuListener(this);
		settingDialog = new SettingDialog(this);
		actionItemsListener = new ActionItemsListener(this);
		
		menuBar = new MenuBar(this);
		mainPanel = new MainPanel(this);
		
		this.setJMenuBar(menuBar);
		this.add(mainPanel);	
		windowListener = new WindowListener(adapter);
		this.addWindowListener(windowListener);
	}
	
	public void runServer(){
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		runSampleServer(serverIp);
	}

	
	public void runSampleServer(String ip)
	{
		 try
	        {
	            ServerSocket server = new ServerSocket(3128, 0,
	                    InetAddress.getByName(ip));  

	            // слушаем порт
	            while(true)
	            {
	                // ждём нового подключения, после чего запускаем обработку клиента
	                // в новый вычислительный поток и увеличиваем счётчик на единичку
	                new SampleServer(this, server.accept());
	            }
	        }
	        catch(Exception e){
	        	System.out.println("init error: "+e);
	        } 
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
