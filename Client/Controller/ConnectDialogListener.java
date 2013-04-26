package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Client.Model.Data;
import Client.View.ConnectDialog;
import Client.View.MainFrame;

public class ConnectDialogListener extends AbstractAction{

	private ConnectDialog connectDialog;
	
	public ConnectDialogListener(ConnectDialog connectDialog) {
		super();
		this.connectDialog = connectDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Data data = connectDialog.getData();
		data.setIp(connectDialog.textField.getText());
		Refresh refresh = new Refresh(data);
		refresh.refreshEl();
		connectDialog.setVisible(false);
	}


}
