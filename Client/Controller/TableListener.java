package Client.Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Client.View.MainPanel;


public class TableListener extends AbstractAction implements ChangeListener{

	private MainPanel mainPanel;
	private String command;
	
	public TableListener(MainPanel mainPanel) {
		super();
		this.mainPanel = mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		command = arg0.getActionCommand();
		
		if(command.equals("ubButton")){
			mainPanel.model.pageUp();
	        if (mainPanel.model.getPageOffset() == 0) {
	        	mainPanel.upButton.setEnabled(false);
	        }
	        mainPanel.downButton.setEnabled(true);     
	        mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
	    	mainPanel.repaint();
		}
		
		else if(command.equals("downButton")){
			mainPanel.model.pageDown();
		    if (mainPanel.model.getPageOffset() == (mainPanel.model.getPageCount() - 1)) {
		        mainPanel.downButton.setEnabled(false);
		     }
		    mainPanel.upButton.setEnabled(true);
		    mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
	    	mainPanel.repaint();
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		mainPanel.slider = (JSlider)e.getSource();
		if(mainPanel.slider.getValue() != 0){
			mainPanel.model.setPageSize(mainPanel.slider.getValue());
		}
		else{
			mainPanel.model.setPageSize(1);
		}
		mainPanel.pageLabel.setText(String.valueOf(mainPanel.model.getPageNum() + 1));
	    mainPanel.repaint();
		mainPanel.getTable().revalidate();
		mainPanel.getTable().repaint();
	}

}
