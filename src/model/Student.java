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
	
	public Student(String nuIndex, int currentYear,int status, String name, String surname, LocalDate dateOfBirth, Address address,String email,int yearOfEnrollment,String phone) {
		super(name, surname, dateOfBirth, phone, email, address);
		
		this.nuIndex = nuIndex;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYear = ++currentYear;
		this.averageGrade = averageGrade;
		this.passed = passed;
		this.notPassed = notPassed;
		
		this.nuIndex = nuIndex;
		
		if(status==0) {
			this.status=Status.B;
		}else this.status=Status.S;
		this.averageGrade = 0f;
	}
	public Student(String nuIndex,  int currentYear,int status, String name, String surname) {
		super(name, surname);
		
		this.nuIndex = nuIndex;
		if(currentYear == 0) {
			this.currentYear = 1;
		}else if(currentYear == 1)
		{
			this.currentYear = 2;
		}
		else if(currentYear == 2)
		{
			this.currentYear = 3;
		}
		else if(currentYear == 3)
		{
			this.currentYear = 4;
		}else if(currentYear == 4)
		{
			this.currentYear = 5;
		}
		if(status==0) {
			this.status=Status.B;
		}else this.status=Status.S;
		this.averageGrade = 0f;
		
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
