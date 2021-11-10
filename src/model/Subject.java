package model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	public enum Semestar{
		SUMMER,
		WINTER
	}
	private int subjectID;
	private String subjectName;
	private int subjectYear;
	private int espb;
	private Semestar semestar;
	private List<Student> studentsPassed = new ArrayList<Student>();
	private List<Student> studentsNotPassed = new ArrayList<Student>();
	
	public Subject(int subjectID, String subjectName,Semestar semestar, int subjectYear, int espb, List<Student> studentsPassed,
			List<Student> studentsNotPassed) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.semestar = semestar;
		this.subjectYear = subjectYear;
		this.espb = espb;
		this.studentsPassed = studentsPassed;
		this.studentsNotPassed = studentsNotPassed;
	}
	
	public Subject(Subject s) {
		this.subjectID = s.subjectID;
		this.subjectName = s.subjectName;
		this.semestar = s.semestar;
		this.subjectYear = s.subjectYear;
		this.espb = s.espb;
		this.studentsPassed = s.studentsPassed;
		this.studentsNotPassed = s.studentsNotPassed;
	}
	public int getSubjectID() {
		return subjectID;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectYear() {
		return subjectYear;
	}

	public void setSubjectYear(int subjectYear) {
		this.subjectYear = subjectYear;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getStudentsPassed() {
		return studentsPassed;
	}

	public void setStudentsPassed(List<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}

	public List<Student> getStudentsNotPassed() {
		return studentsNotPassed;
	}

	public void setStudentsNotPassed(List<Student> studentsNotPassed) {
		this.studentsNotPassed = studentsNotPassed;
	}

	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectName=" + subjectName + ", subjectYear=" + subjectYear
				+ ", espb=" + espb + ", semestar=" + semestar + ", studentsPassed=" + studentsPassed
				+ ", studentsNotPassed=" + studentsNotPassed + "]";
	}

	
	
	
	
	
	
	
}
