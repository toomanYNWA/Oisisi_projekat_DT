package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Grade {
	
	private ArrayList<String> indexPassed ;
	private Subject subject;
	private int value;
	private LocalDate dateofExam;
	
	public Grade() {}
	
	public Grade(ArrayList<String> indexPassed, Subject subject, int value, LocalDate dateofExam) {
		super();
		this.indexPassed = indexPassed;
		this.subject = subject;
		this.value = value;
		this.dateofExam = dateofExam;
	}
    
	public Grade(Grade g) {
		super();
		this.indexPassed = g.indexPassed;
		this.subject = g.subject;
		this.value = g.value;
		this.dateofExam = g.dateofExam;
	}
	public List<String> getIndexPassed() {
		return indexPassed;
	}
	public void setIndexPassed(ArrayList<String> indexPassed) {
		this.indexPassed = indexPassed;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public LocalDate getDateofExam() {
		return dateofExam;
	}
	public void setDateofExam(LocalDate dateofExam) {
		this.dateofExam = dateofExam;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		if(value<6 || value>10)
			System.out.println("Wrong value.");
			else this.value = value;
	}
	
	
	
	
}
