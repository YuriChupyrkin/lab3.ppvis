package Server.Controller;

import javax.swing.JTable;

import Server.Model.Data;
import Server.Model.Student;
import Server.View.MainFrame;

public class LanRemove {

	private MainFrame mainFrame;
	
	public LanRemove(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}
	
	public void removeEl(String type, String att1, String att2){
		
		Data data = mainFrame.getAdapter().getData();
		for(int index = 0; index < data.studList.size(); index++){
			
			Student stud = data.studList.get(index);
			
			if(type.equals("1")){
				if(stud.getFio().indexOf(att2) != -1 && stud.getHouse().equals(att1)){
					if(stud.getFio().length() > att2.length()){
						if(stud.getFio().toCharArray()[att2.length()] == ' '){
							data.studList.remove(index);
							index--;
						}
					}
					else {
						if(stud.getFio().equals(att2)){
							data.studList.remove(index);
							index--;
						}
					}
				}
			}
			else if(type.equals("2")){
				if(stud.getFlat().equals(att2) && stud.getStreet().equals(att1)){
					data.studList.remove(index);
					index--;
				}
			}
			else if(type.equals("3")){
					if(stud.getHouse().indexOf(att2) != -1
							&& stud.getFio().indexOf(att1) != -1){
						if(stud.getFio().length() > att1.length()){
							if(stud.getFio().toCharArray()[att1.length()] == ' '){					
								data.studList.remove(index);
								index--;
								}
							}
											
						else{
							if(stud.getFio().equals(att1)){
								data.studList.remove(index);
								index--;
							}
						}
					}
			}
		}
		
		JTable table = mainFrame.getMainPanel().getTable();
		table.revalidate();
		table.repaint();			
	}
	
}
