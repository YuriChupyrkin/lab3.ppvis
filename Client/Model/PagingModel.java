package Client.Model;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PagingModel extends AbstractTableModel {

	private int pageSize;
	private int pageOffset;
	private List<Student>studList;
	
	 public PagingModel(List list) {
		    this(10);
		    this.studList = list;
		  }
	 
	 public PagingModel(int size) {
		    pageSize = size;
		  }
	  
	 // Return values appropriate for the visible table part.
	  public int getRowCount() {
	    return Math.min(pageSize, studList.size());
	  }

	  public int getColumnCount() {
	    return 8;
	  }

	  public Object getValueAt(int row, int col) {
		  int realRow = row + (pageOffset * pageSize);
		  Student student;
		  if(studList.size() > realRow)
			  student = studList.get(realRow);
		  else
			  return "";
		  
			switch(col){
			case 0:
				return student.getFio();
			case 1:
				return student.getCountry();
			case 2:
				return student.getProvince();
			case 3:
				return student.getCity();
			case 4:
				return student.getStreet();
			case 5:
				return student.getHouse();
			case 6:
				return student.getHousing();
			case 7:
				return student.getFlat();
			}
			return "";
	  }

	  @Override
	  public String getColumnName(int column){
			switch(column){
			case 0:
				return "ФИО";
			case 1:
				return "Страна";
			case 2:
				return "Область";
			case 3:
				return "Город";
			case 4: 
				return "Улица";
			case 5:
				return "Дом";	
			case 6:
				return "Корпус";	
			case 7:
				return "Квартира";	
			}
			return "";
		}

	  // Use this method to figure out which page you are on.
	  public int getPageOffset() {
	    return pageOffset;
	  }

	  public int getPageCount() {
	    return (int) Math.ceil((double) studList.size() / pageSize);
	  }

	  // Use this method if you want to know how big the real table is . . . we
	  // could also write "getRealValueAt()" if needed.
	  public int getRealRowCount() {
	    return studList.size();
	  }

	  public int getPageSize() {
	    return pageSize;
	  }

	  public void setPageSize(int s) {
	    if (s == pageSize) {
	      return;
	    }
	    int oldPageSize = pageSize;
	    pageSize = s;
	    pageOffset = (oldPageSize * pageOffset) / pageSize;
	    fireTableDataChanged();
	  }

	  // Update the page offset and fire a data changed (all rows).
	  public void pageDown() {
	    if (pageOffset < getPageCount() - 1) {
	      pageOffset++;
	      fireTableDataChanged();
	 	  }
	  }

	  // Update the page offset and fire a data changed (all rows).
	  public void pageUp() {
	    if (pageOffset > 0) {
	      pageOffset--;
	      fireTableDataChanged();
	    }
	  }
	  
	  public int getPageNum(){
		  return pageOffset;
	  }

}
