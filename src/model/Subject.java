package model;

import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class Subject {
	
	public enum Semestar{
		WINTER,
		SUMMER
	}
	private int subjectID;
	private String subjectName;
	private int subjectYear;
	private Professor professor;
	private int espb;
	private Semestar semestar;
	private ArrayList<String> indexPassed ;
	private ArrayList<String> indexNotPassed ;
	
	public Subject() {}
	
	public Subject(int subjectID, String subjectName,Semestar semestar, int subjectYear, Professor professor, int espb, ArrayList<String> studentsPassed,
			ArrayList<String> studentsNotPassed) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.semestar = semestar;
		this.subjectYear = subjectYear;
		this.professor = professor;
		this.espb = espb;
		this.indexPassed = studentsPassed;
		this.indexNotPassed = studentsNotPassed;
	}
	
	public Subject(int subjectID, String subjectName,int semestar, int subjectYear,int espb) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.subjectYear = subjectYear;
		this.espb = espb;
		
		if(semestar==0) {
			this.semestar=Semestar.WINTER;
		}else {
			this.semestar=Semestar.SUMMER;
		}
	}
	
	public Subject(Subject s) {
		this.subjectID = s.subjectID;
		this.subjectName = s.subjectName;
		this.semestar = s.semestar;
		this.subjectYear = s.subjectYear;
		this.professor = s.professor;
		this.espb = s.espb;
		this.indexPassed = s.indexPassed;
		this.indexNotPassed = s.indexNotPassed;
	}
	
	public int getSubjectID() {
		return subjectID;
	}

	public String getSemestar() {
		if(this.semestar == Semestar.WINTER) {
			return "WINTER";
		} else return "SUMMER";
	}

	public void setSemestar(int semestar) {
		if(semestar == 0 ) this.semestar = Semestar.WINTER;
		else this.semestar = Semestar.SUMMER;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<String> getStudentsPassed() {
		return indexPassed;
	}

	public void setStudentsPassed(ArrayList<String> indexPassed) {
		this.indexPassed = indexPassed;
	}

	public ArrayList<String> getStudentsNotPassed() {
		return indexNotPassed;
	}

	public void setStudentsNotPassed(ArrayList<String> indexNotPassed) {
		this.indexNotPassed = indexNotPassed;
	}

	@Override
	public String toString() {
		return	 this.subjectID+"-"+this.subjectName;
	}	
	
}
