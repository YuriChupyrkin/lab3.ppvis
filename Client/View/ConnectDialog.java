package Client.View;

import javax.swing.*;

import Client.Controller.ConnectDialogListener;
import Client.Model.Data;

public class ConnectDialog extends JDialog{

	private MainFrame mainFrame;
	private JButton butOk;
	public JTextField textField;
	private JLabel ipLabel;
	private ConnectDialogListener connectDialogListener;
	
	public ConnectDialog(MainFrame mainFrame){
		this.setSize(200, 160);
		this.setLocation(600, 70);
		this.mainFrame = mainFrame;
		this.setLayout(null);
		
		butOk = new JButton("ok");
		butOk.setBounds(60, 70, 100, 30);
		this.add(butOk);
		
		textField = new JTextField();
		textField.setBounds(60, 10, 100, 50);
		this.add(textField);
		
		ipLabel = new JLabel("ip: ");
		ipLabel.setBounds(10, 10, 40, 50);
		this.add(ipLabel);
		
		connectDialogListener = new ConnectDialogListener(this);
		butOk.addActionListener(connectDialogListener);
	}
	
	public void runConnectDialog(){
		this.setVisible(true);
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public Data getData(){
		return mainFrame.getAdapter().getData();
	}
}
