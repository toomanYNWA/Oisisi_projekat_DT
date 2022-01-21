package model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import view.TabbedPane;

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
	private ArrayList<Grade> passed = new ArrayList<Grade>();
	private ArrayList<Subject> notPassed = new ArrayList<Subject>();
	
	public Student(String nuIndex, int currentYear,int status, String name, String surname, LocalDate dateOfBirth, Address address,String email,int yearOfEnrollment,String phone) {
		super(name, surname, dateOfBirth, phone, email, address);
		
		this.nuIndex = nuIndex;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYear= currentYear ;
		this.averageGrade = averageGrade;
		this.passed = passed;
		this.notPassed = notPassed;
		
		this.nuIndex = nuIndex;
		
		if(status==0) {
			this.status=Status.B;
		}else {
			this.status=Status.S;
		}
		
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

	public ArrayList<Grade> getPassed() {
		return passed;
	}

	public void setPassed(ArrayList<Grade> passed) {
		this.passed = passed;
	}

	public ArrayList<Subject> getNotPassed() {
		return notPassed;
	}

	public void setNotPassed(ArrayList<Subject> notPassed) {
		this.notPassed = notPassed;
	}

	public int getStatus() {
		if(this.status== Status.B) {
			return 0;
		} else return 1;
	}

	public void setStatus(int status) {
		if (status==0) this.status = Status.B;
		else this.status = Status.S;
		
	}
	public void addPassed(Grade g) {
		this.passed.add(g);
	}
	
	public void addNotPassedSubject(Subject s) {
		this.notPassed.add(s);
	}

	public void removeNotPassedSubject(Subject s) {
		this.notPassed.remove(s);
	} 
	public void addAnnuledExam(Grade g) {
		this.passed.remove(g);
	}
	public float calculate() {
        int count = 0;
        this.averageGrade = 0;
        for(Grade oc : this.passed) {
            this.averageGrade += oc.getValue();
            count++;
        }
        this.averageGrade = this.averageGrade/count;
        if (count != 0) {
            return averageGrade;
            
        }
        else {
            return 0;
        }
    }
	
	@Override
	public String toString() {
		return "Student [nuIndex=" + nuIndex + ", year=" + yearOfEnrollment + ", currentYear=" + currentYear + ", averageGrade="
				+ averageGrade + ", status=" + status + ", passed=" + passed + ", notPassed=" + notPassed + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
