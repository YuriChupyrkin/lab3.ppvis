package Client.View;

import javax.swing.*;

public class ConnectDialog extends JDialog{

	private MainFrame mainFrame;
	private JButton butOk;
	JTextField textField;
	private JLabel ipLabel;
	
	public ConnectDialog(MainFrame mainFrame){
		this.setSize(200, 160);
		this.setLocation(200, 200);
		
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
	}
	
	public void runConnectDialog(){
		this.setVisible(true);
	}
}
