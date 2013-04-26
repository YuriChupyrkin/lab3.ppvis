package Client.Model;

public class Student {

private Data data;
	
	private String fio;  // фамилия имя отчество
	private String country;  // страна
	private String province;  // область
	private String city;  // город
	private String street; // улица
	private String house;  // дом
	private String housing;  // корпус
	private String flat; //квартира
	
	
	public Student(String fio, String country, String province, String city,
			String street, String house, String housing, String flat) {
		super();
		this.fio = fio;
		this.country = country;
		this.province = province;
		this.city = city;
		this.street = street;
		this.house = house;
		this.housing = housing;
		this.flat = flat;
	}
	
	public Student(){
		
	}
	
	//////////////////////////  Getters  /////////////////////////
	public String getFio() {
		return fio;
	}


	public void setFio(String fio) {
		this.fio = fio;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public String getHousing() {
		return housing;
	}


	public void setHousing(String housing) {
		this.housing = housing;
	}


	public String getFlat() {
		return flat;
	}


	public void setFlat(String flat) {
		this.flat = flat;
	}


	public Data getData() {
		return data;
	}


}
