package Client.View;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.table.TableModel;

import Client.Controller.ArrowIcon;
import Client.Controller.SearchDialogListener;
import Client.Controller.SearchTableListener;
import Client.Model.PagingModel;


public class SearchDialog extends JDialog{

	
	private MainFrame mainFrame;
	public JComboBox comboBox;
	private JLabel mainLabel;
	public JLabel item1Label;
	public JTextField item1Text;
	public JLabel item2Label;
	public JTextField item2Text;
	public JButton butSearch;
	private JTable table;
	private JScrollPane scrollPane;
	private SearchDialogListener searchDialogListener;
	private JLabel numLabel;
	public JLabel countLabel;
	public PagingModel model;
	public JButton upButton;
	public JButton downButton;
	private SearchTableListener searchTableListener;
	
	public enum SearchComboBoxItems{
		firstIt("номеру дома и фамилии"),
		secondIt("улице и квартире"),
		thirdIt("фамилии и цифрам встречающемс€ в номере дома");
		
		public final String ITEM;
		SearchComboBoxItems(String item){
			this.ITEM = item;
		}
	}
	
	public SearchDialog(MainFrame frame){
		this.mainFrame = frame;
		this.setSize(800, 600);
		this.setLocation(150, 150);
		this.setTitle("Search");
		this.setResizable(false);		
		this.setLayout(null);

		
		comboBox = new JComboBox();
		comboBox.setActionCommand("COMBOBOX");
		comboBox.setEditable(false);
		
		for(SearchComboBoxItems str: SearchComboBoxItems.values()){
			comboBox.addItem(str.ITEM);
		}
		mainLabel = new JLabel("найти по :");		
		item1Label = new JLabel("               номер дома");
		item2Label = new JLabel("                    фамили€");
		item1Text = new JTextField();
		item2Text = new JTextField();
		butSearch = new JButton();
		butSearch.setName("search");
		ResourceBundle resourceBundle = mainFrame.getAdapter().getData().getResourceBundle();
		butSearch.setText((String)resourceBundle.getObject(butSearch.getName()));
		mainFrame.buttonList.add(butSearch);
		butSearch.setActionCommand("SEARCH");
		numLabel = new JLabel("Ќайдено: ");
		countLabel = new JLabel("0");
		
		countLabel.setBounds(570, 10, 60, 30);
		numLabel.setBounds(500, 10, 60, 30);		
		butSearch.setBounds(330, 50, 150, 70);		
		mainLabel.setBounds(10, 10, 60, 30);
		comboBox.setBounds(70, 10, 410, 30);
		item1Label.setBounds(10, 50, 150, 30);
		item2Label.setBounds(10, 90, 150, 30);
		item1Text.setBounds(160, 50, 150, 30);
		item2Text.setBounds(160, 90, 150, 30);
		
		this.add(mainLabel);
		this.add(comboBox);
		this.add(item1Label);
		this.add(item2Label);
		this.add(item1Text);
		this.add(item2Text);
		this.add(butSearch);
		this.add(numLabel);
		this.add(countLabel);
				
		searchDialogListener = new SearchDialogListener(this);
		comboBox.addActionListener(searchDialogListener);
		butSearch.addActionListener(searchDialogListener);
		
		//table = new JTable(mainFrame.getAdapter().getData().getSearchTableModel());
		table = new JTable(mainFrame.getAdapter().getData().getSearchPagingModel());
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 150, 770, 420);
		
		upButton = new JButton(new ArrowIcon(ArrowIcon.UP));
		upButton.setEnabled(false); // starts off at 0, so can't go up
		upButton.setActionCommand("upButton");
		downButton = new JButton(new ArrowIcon(ArrowIcon.DOWN));
		downButton.setActionCommand("downButton");
		scrollPane.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER, upButton);
		scrollPane.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, downButton);
		
		TableModel tmodel = table.getModel();
		model = (PagingModel) tmodel;
		
		searchTableListener = new SearchTableListener(this);
		upButton.addActionListener(searchTableListener);
		downButton.addActionListener(searchTableListener);
			
		this.add(scrollPane);
	}
	
	public void runSearchDialog(){
		this.setVisible(true);
	}
	
	//////////////////////////  Getters  //////////////////////
	public SearchDialogListener getSearchDialogListener() {
		return searchDialogListener;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public JTable getTable() {
		return table;
	}

}
