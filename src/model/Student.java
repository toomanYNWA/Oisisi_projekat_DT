package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends User{
	
	public enum Status {
		B,
		S
	}
	private String nuIndex;
	private int	yearOfEnrollment;
	private int currentYear;
	private float averageGrade;
	private Status status;
	private ArrayList<Subject> passed;
	private ArrayList<Subject> notPassed ;
	
	public Student(String nuIndex, int yearOfEnrollment, int currentYear,Status status, float averageGrade, ArrayList<Subject> passed,ArrayList<Subject> notPassed, String name, String surname, LocalDate dateofbirth, Gender gender, String phone, String email,	Address address) {
		super(name, surname, dateofbirth, gender, phone, email, address);
		
		this.nuIndex = nuIndex;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYear = currentYear;
		this.status = status;
		this.averageGrade = averageGrade;
		this.passed = passed;
		this.notPassed = notPassed;
	}
	
	public Student(Student s) {
		super(s);
		this.nuIndex = s.nuIndex;
		this.yearOfEnrollment = s.yearOfEnrollment;
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
		return yearOfEnrollment;
	}

	public void setYear(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
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

	public void setPassed(ArrayList<Subject> passed) {
		this.passed = passed;
	}

	public List<Subject> getNotPassed() {
		return notPassed;
	}

	public void setNotPassed(ArrayList<Subject> notPassed) {
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
		return "Student [nuIndex=" + nuIndex + ", year=" + yearOfEnrollment + ", currentYear=" + currentYear + ", averageGrade="
				+ averageGrade + ", status=" + status + ", passed=" + passed + ", notPassed=" + notPassed + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
