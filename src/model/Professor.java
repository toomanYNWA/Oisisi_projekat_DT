package model;

import java.time.LocalDate;
import java.util.ArrayList;




public class Professor extends User {
	
	public enum Title{
	   ASISTANT_PROFESSOR,
	   ASSOCIATE_PROFESSOR,
	   PROFESSOR
		
	}
	private Address officeAdress;
	private String id;
	private int yearsOfTrail;
	private Title title;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	
	public Professor(String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title, ArrayList<Subject> subjects ) {

		super(name, surname, dateofbirth, phone, email, address);
		this.officeAdress = officeAdress;
		this.id = id;
		this.yearsOfTrail = yearsOfTrail;
		this.title= title;
		this.subjects=subjects; 
	}
	
	
	public Professor() {
		super();
	}


	public Professor(String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title ) {

		super(name, surname, dateofbirth, phone, email, address);
		this.officeAdress = officeAdress;
		this.id = id;
		this.yearsOfTrail = yearsOfTrail;
		this.title= title; 
	}
	public Professor(Professor p) { 
		super(p);
		this.officeAdress = p.officeAdress;
		this.id = p.id;
		this.yearsOfTrail = p.yearsOfTrail;
		this.title=p.title;
		this.subjects=p.subjects; 
	}

	public Address getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(Address officeAdress) {
		this.officeAdress = officeAdress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYearsOfTrail() {
		return yearsOfTrail;
	}

	public void setYearsOfTrail(int yearsOfTrail) {
		this.yearsOfTrail = yearsOfTrail;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	public void addSubject(Subject s) {
		this.subjects.add(s);
	}
	@Override
	public String toString() {
		return "Professor [officeAdress=" + officeAdress + ", id=" + id + ", yearsOfTrail=" + yearsOfTrail + ", title="
				+ title + "]";
	}

	
	
	
	

}
