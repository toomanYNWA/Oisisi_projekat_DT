package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends User{
	
	public Student() {
		super();
	}
	public enum Status {
		B,
		S
	}
	private String nuIndex;
	private int	year;
	private int currentYear;
	private float averageGrade;
	private Status status;
	private List<Subject> passed = new ArrayList<Subject>();
	private List<Subject> notPassed = new ArrayList<Subject>();
	
	public Student(String nuIndex, int year, int currentYear,Status status, float averageGrade, List<Subject> passed,
			List<Subject> notPassed, String name, String surname, Date dateofbirth, Gender gender, String phone, String email,
			Address address) {
		super(name, surname, dateofbirth, gender, phone, email, address);
		
		this.nuIndex = nuIndex;
		this.year = year;
		this.currentYear = currentYear;
		this.status = status;
		this.averageGrade = averageGrade;
		this.passed = passed;
		this.notPassed = notPassed;
	}
	
	public Student(Student s) {
		super(s);
		this.nuIndex = s.nuIndex;
		this.year = s.year;
		this.currentYear = s.currentYear;
		this.status = s.status;
		this.averageGrade = s.averageGrade;
		this.passed = s.passed;
		this.notPassed = s.notPassed;
	}
	
	public String getNuIndex() {
		return nuIndex;
	}

	public void setNuIndex(String nuIndex) {
		this.nuIndex = nuIndex;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public float getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(float averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Subject> getPassed() {
		return passed;
	}

	public void setPassed(List<Subject> passed) {
		this.passed = passed;
	}

	public List<Subject> getNotPassed() {
		return notPassed;
	}

	public void setNotPassed(List<Subject> notPassed) {
		this.notPassed = notPassed;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [nuIndex=" + nuIndex + ", year=" + year + ", currentYear=" + currentYear + ", averageGrade="
				+ averageGrade + ", status=" + status + ", passed=" + passed + ", notPassed=" + notPassed + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
