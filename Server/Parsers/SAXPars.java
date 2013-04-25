package Server.Parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import Server.Controller.Adapter;
import Server.Model.Student;


public class SAXPars extends DefaultHandler{

	private Adapter adapter;
	private List<Student>studList;
	private String thisElement = "";
	private Student student;
	
	public SAXPars(Adapter adapter) {
		super();
		this.adapter = adapter;
		studList = adapter.getData().studList;
	}
	
	
	@Override
	public void startDocument() throws SAXException {
	}
	
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		thisElement = qName; 
		  if (thisElement.equals("student")) {
			  student = new Student();   
		  }		  
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		 if (thisElement.equals("")) {
			 if(student != null){
			  		studList.add(student);
			  		student = null;
				}
		 }
		 thisElement = "";
	}
	
	@Override
	public void endDocument() {
	}

	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		  
		  if (thisElement.equals("fio")) {
		     student.setFio(new String(ch, start, length));
		  }
		  if(thisElement.equals("country")){
			  student.setCountry(new String(ch, start, length));
		  }
		  if(thisElement.equals("province")){
			  student.setProvince(new String(ch, start, length));
		  }
		  if(thisElement.equals("city")){
			  student.setCity(new String(ch, start, length));
		  }
		  if(thisElement.equals("street")){
			  student.setStreet(new String(ch, start, length));
		  }		  
		  if(thisElement.equals("house")){
			  student.setHouse(new String(ch, start, length));
		  }	  
		  if(thisElement.equals("housing")){
			  student.setHousing(new String(ch, start, length));
		  }	 
		  if(thisElement.equals("flat")){
			  student.setFlat(new String(ch, start, length));
		  }	 
	}

	
	public Adapter getAdapter() {
		return adapter;
	}
}