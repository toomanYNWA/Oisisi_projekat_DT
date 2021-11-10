package model;

public class Address {
	private String street;
	private String number;
	private String city;
	private String state;
	
	public Address() {};
	
	public Address(String street, String number, String city, String state) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
	}
	
	public Address(Address a) {
		super();
		this.street = a.street;
		this.number = a.number;
		this.city = a.city;
		this.state = a.state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
