package model;

import java.util.Date;

public abstract class User {
	public enum Gender {
		MALE,
		FEMALE
	}
	private String name;
	private String surname;
	private Date dateofbirth;
	private Gender gender;
	private String phone;
	private String email;
	private Address address;
	
	public User() {
		
	}
	
	public User(String name, String surname, Date dateofbirth,  Gender gender, String phone, String email, Address address) {
		this();
		this.name = name;
		this.surname = surname;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public User(User u) {
		this();
		this.name = u.name;
		this.surname = u.surname;
		this.dateofbirth = u.dateofbirth;
		this.gender = u.gender;
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

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
		return "User [name=" + name + ", surname=" + surname + ", dateofbirth=" + dateofbirth + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
