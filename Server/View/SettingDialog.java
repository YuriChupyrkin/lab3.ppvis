package Server.View;

import java.awt.TextField;

import javax.swing.*;

import Server.Controller.SettingDialogListener;

public class SettingDialog extends JDialog{

	private MainFrame mainFrame;
	public JComboBox langComboBox;
	private JLabel langLabel;
	private JButton butOk;
	private SettingDialogListener settingDialogListener;
	private JLabel ipLabel;
	public JLabel ipTextField;
	
	public SettingDialog(MainFrame frame){
		this.mainFrame = frame;
		
		this.setSize(300, 200);
		this.setLocation(200, 200);
		this.setTitle("Setting");
		this.setLayout(null);
		
		langComboBox = new JComboBox();
		langComboBox.setEditable(false);
		langComboBox.addItem("English");
		langComboBox.addItem("Русский");
		langComboBox.setBounds(100, 10, 100, 40);
		
		langLabel = new JLabel("language:");
		langLabel.setBounds(10, 10, 80, 40);
		
		butOk = new JButton("OK");
		butOk.setBounds(100, 110, 100, 50);
		
		ipLabel = new JLabel("ip: ");
		ipLabel.setBounds(10, 60, 80, 40);
		
		ipTextField = new JLabel(mainFrame.getAdapter().getData().getServerIp());
		ipTextField.setBounds(100, 60, 100, 40);
		
		this.add(langComboBox);		
		this.add(langLabel);
		this.add(butOk);
		this.add(ipLabel);
		this.add(ipTextField);
		
		settingDialogListener = new SettingDialogListener(mainFrame);
		butOk.addActionListener(settingDialogListener);
	}
	
	public void runDialog(){
		this.setVisible(true);
	}
}
