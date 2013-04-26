package Client.View;

import javax.swing.*;

import Client.Controller.SettingDialogListener;


public class SettingDialog extends JDialog{

	private MainFrame mainFrame;
	public JComboBox langComboBox;
	private JLabel langLabel;
	private JButton butOk;
	private SettingDialogListener settingDialogListener;
	
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
		langComboBox.setBounds(100, 30, 100, 50);
		
		langLabel = new JLabel("language:");
		langLabel.setBounds(10, 30, 80, 50);
		
		butOk = new JButton("OK");
		butOk.setBounds(100, 100, 100, 50);
		
		this.add(langComboBox);		
		this.add(langLabel);
		this.add(butOk);
		
		settingDialogListener = new SettingDialogListener(mainFrame);
		butOk.addActionListener(settingDialogListener);
	}
	
	public void runDialog(){
		this.setVisible(true);
	}
}
