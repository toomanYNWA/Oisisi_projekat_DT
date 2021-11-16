package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends User {
	
	public enum Title{
	   ASISTANT_PROFESSOR,
	   ASSOCIATE_PROFESSOR,
	   PROFESSOR
		
	}
	private String officeAdress;
	private String id;
	private int yearsOfTrail;
	private Title title;
	private List<Subject> subjects= new ArrayList<Subject>();
	
	public Professor() {
		super();
	}

	public Professor(String name, String surname, LocalDate dateofbirth, Gender gender, String phone, String email,
			Address address, String officeAdress, String id, int yearsOfTrail, Title title, List<Subject> subjects ) {
		super(name, surname, dateofbirth, gender, phone, email, address);
		this.officeAdress = officeAdress;
		this.id = id;
		this.yearsOfTrail = yearsOfTrail;
		this.title= title;
		this.subjects=subjects; 
	}
   
	public Professor(Professor p) { 
		super(p);
		this.officeAdress = p.officeAdress;
		this.id = p.id;
		this.yearsOfTrail = p.yearsOfTrail;
		this.title=p.title;
		this.subjects=p.subjects; 
	}

	public String getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(String officeAdress) {
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

	@Override
	public String toString() {
		return "Professor [officeAdress=" + officeAdress + ", id=" + id + ", yearsOfTrail=" + yearsOfTrail + ", title="
				+ title + "]";
	}

	
	
	
	

}
