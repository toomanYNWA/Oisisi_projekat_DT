package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Grade {
	
	private List<String> indexPassed = new ArrayList<String>();
	private Subject subject;
	private int value;
	private Date dateofExam;
	
	public Grade() {}
	
	public Grade(List<String> indexPassed, Subject subject, int value, Date dateofExam) {
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
	public void setIndexPassed(List<String> indexPassed) {
		this.indexPassed = indexPassed;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Date getDateofExam() {
		return dateofExam;
	}
	public void setDateofExam(Date dateofExam) {
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
