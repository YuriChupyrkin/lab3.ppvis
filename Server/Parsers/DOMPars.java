package Server.Parsers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Server.Controller.Adapter;
import Server.Model.Data;
import Server.Model.Student;

public class DOMPars {

	private Adapter adapter;
	private DocumentBuilder docBuilder;
	private Transformer transformer;
	
	public DOMPars(Adapter adapter) {
		super();
		this.adapter = adapter;
	}
	
	
	public void writeFile(String fileName){
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();		
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("doc");
		doc.appendChild(rootElement); 
		
		for(Student std: adapter.getData().studList){
			
			// staff elements
			Element stud = doc.createElement("student");
			rootElement.appendChild(stud);
			
			
			Element fio = doc.createElement("fio");
			fio.appendChild(doc.createTextNode(std.getFio()));
			stud.appendChild(fio);
			
			Element country = doc.createElement("country");
			country.appendChild(doc.createTextNode(std.getCountry()));
			stud.appendChild(country);
			
			Element province = doc.createElement("province");
			province.appendChild(doc.createTextNode(std.getProvince()));
			stud.appendChild(province);
			
			Element city = doc.createElement("city");
			city.appendChild(doc.createTextNode(std.getCity()));
			stud.appendChild(city);
			
			Element street = doc.createElement("street");
			street.appendChild(doc.createTextNode(std.getStreet()));
			stud.appendChild(street);
			
			Element house = doc.createElement("house");
			house.appendChild(doc.createTextNode(std.getHouse()));
			stud.appendChild(house);
			
			Element housing = doc.createElement("housing");
			housing.appendChild(doc.createTextNode(std.getHousing()));
			stud.appendChild(housing);
			
			Element flat = doc.createElement("flat");
			flat.appendChild(doc.createTextNode(std.getFlat()));
			stud.appendChild(flat);
		}
		
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			 transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));
 
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Adapter getAdapter() {
		return adapter;
	}
}
