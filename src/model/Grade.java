package model;

import java.time.LocalDate;


public class Grade {
	
	private Student studentPassed ;
	private Subject subject;
	private int value;
	private LocalDate dateofExam;
	
	
	public Grade(Student studentPassed, Subject subject, int value, LocalDate dateofExam) {
		super();
		this.studentPassed = studentPassed;
		this.subject = subject;
		if(value<6 || value>10) {
			throw new IllegalArgumentException("Grade can only be in 6-10 range.");
		}
		this.value = value;
		this.dateofExam = dateofExam;
	}
    
	public Grade(Grade g) {
		super();
		this.studentPassed = g.studentPassed;
		this.subject = g.subject;
		if(g.value<6 || g.value>10) {
			throw new IllegalArgumentException("Grade can only be in 6-10 range.");
		}
		this.value = g.value;
		this.dateofExam = g.dateofExam;
	}

	
	public Student getStudentPassed() {
		return studentPassed;
	}

	public void setStudentPassed(Student studentPassed) {
		this.studentPassed = studentPassed;
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
		if(value<6 || value>10) {
			throw new IllegalArgumentException("Grade can only be in 6-10 range.");
		}
		 this.value = value;
	}

	@Override
	public String toString() {
		return "Grade [studentPassed=" + studentPassed + ", subject=" + subject + ", value=" + value + ", dateofExam="
				+ dateofExam + "]";
	}
	
	
	
	
}
