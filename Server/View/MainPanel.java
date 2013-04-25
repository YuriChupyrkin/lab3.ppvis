package Server.View;
import java.awt.Color;

import javax.swing.*;
import javax.swing.table.TableModel;

import Server.Controller.ArrowIcon;
import Server.Controller.TableListener;
import Server.Model.PagingModel;

public class MainPanel extends JPanel{

	private enum Buttons{
		
		add("add", "ADD", 250, 10, 100, 30),
		remove("remove", "REMOVE", 360, 10, 100, 30),
		search("search", "SEARCH", 470, 10, 100, 30);
		
		final int posX;
		final int posY;
		final int WIDTH;
		final int HEIGHT;
		final String NAME;
		final String COMAND;
		
		Buttons(String name, String cmd, int X, int Y, int H, int W){
			this.NAME = name;
			this.COMAND = cmd;
			this.posX = X;
			this.posY = Y;
			this.HEIGHT = H;
			this.WIDTH = W;
		}
	}

	private MainFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;
	public JButton upButton;
	public JButton downButton;
	private TableListener tableListener;
	public PagingModel model;
	public JLabel pageLabel;
	private JLabel page;
	public JSlider slider;
	
	public MainPanel(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		
		tableListener = new TableListener(this);
		
		pageLabel = new JLabel("0");
		pageLabel.setBounds(70, 10, 60, 30);
		pageLabel.setForeground(Color.white);
		page = new JLabel("page:");
		page.setBounds(10, 10, 65, 30);
		page.setForeground(Color.white);		
		
		PagingModel pagingModel = mainFrame.getAdapter().getData().getPagingModel();
		table = new JTable(pagingModel);
		TableModel tmodel = table.getModel();
	    model = (PagingModel) tmodel;
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 760, 390);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
		upButton = new JButton(new ArrowIcon(ArrowIcon.UP));
		upButton.setEnabled(false); // starts off at 0, so can't go up
		upButton.setActionCommand("ubButton");
		upButton.addActionListener(tableListener);
		
		downButton = new JButton(new ArrowIcon(ArrowIcon.DOWN));
		downButton.setActionCommand("downButton");
		downButton.addActionListener(tableListener);
		
		scrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);
		scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);
		
		slider = new JSlider(0, 100, 10);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);	
		slider.setBounds(10, 480, 765, 50);
		slider.addChangeListener(tableListener);
		
		for(Buttons but: Buttons.values()){
			JButton button = new JButton();
			button.setName(but.NAME);
			button.setText(button.getName());
			button.setBounds(but.posX, but.posY, but.HEIGHT, but.WIDTH);
			button.setActionCommand(but.COMAND);
			//button.addActionListener(mainFrame.getActionItemsListener());
			mainFrame.buttonList.add(button);
			this.add(button);
		}
		
	    this.add(scrollPane);
	    this.add(page);
	    this.add(pageLabel);
	    this.add(slider);
	}
	
	
	public JTable getTable() {
		return table;
	}

}
