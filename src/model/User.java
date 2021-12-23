package model;

import java.time.LocalDate;


public abstract class User {
	private String name;
	private String surname;
	private LocalDate dateofbirth;
	private String phone;
	private String email;
	private Address address;
	
	
	
	public User(String name, String surname, LocalDate dateofbirth, String phone, String email, Address address) {
		this.name = name;
		this.surname = surname;
		this.dateofbirth = dateofbirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	
	}

	public User(User u) {
		this.name = u.name;
		this.surname = u.surname;
		this.dateofbirth = u.dateofbirth;
		this.phone = u.phone;
		this.email = u.email;
		this.address = u.address;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", dateofbirth=" + dateofbirth
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
