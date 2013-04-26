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
		runSampleServer();
	}

	
	public void runSampleServer()
	{
		 try
	        {
	            // привинтить сокет на локалхост, порт 3128
	            ServerSocket server = new ServerSocket(3128, 0,
	                    InetAddress.getByName("localhost")); 
	           /* ServerSocket server = new ServerSocket(3128, 0,
	                    InetAddress.getByName("192.168.1.16"));  */

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
	        } // вывод исключений
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
