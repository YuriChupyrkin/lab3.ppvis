package Server.Controller;

import Server.Model.Data;
import Server.Model.Student;
import Server.View.MainFrame;

public class LanSearch {

	private MainFrame mainFrame;
	
	public LanSearch(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
	}

	public void searchEl(String type, String att1, String att2){
		Data data = mainFrame.getAdapter().getData();
		data.searchList.clear();
		
		for(int index = 0; index < data.studList.size(); index++){
			
			Student stud = data.studList.get(index);
			
			if(type.equals("1")){
				if(stud.getFio().indexOf(att2) != -1 && stud.getHouse().equals(att1)){
					if(stud.getFio().length() > att2.length()){
						if(stud.getFio().toCharArray()[att2.length()] == ' '){
							data.searchList.add(data.studList.get(index));
						}
					}
					else {
						if(stud.getFio().equals(att2)){
							data.searchList.add(data.studList.get(index));
						}
					}
				}
			}
			else if(type.equals("2")){
				if(stud.getFlat().equals(att2) && stud.getStreet().equals(att1)){
					data.searchList.add(data.studList.get(index));
				}
			}
			else if(type.equals("3")){
					if(stud.getHouse().indexOf(att2) != -1
							&& stud.getFio().indexOf(att1) != -1){
						if(stud.getFio().length() > att1.length()){
							if(stud.getFio().toCharArray()[att1.length()] == ' '){					
								data.searchList.add(data.studList.get(index));
								}
							}
											
						else{
							if(stud.getFio().equals(att1)){
								data.searchList.add(data.studList.get(index));
							}
						}
					}
			}
		}
	}
	
}
