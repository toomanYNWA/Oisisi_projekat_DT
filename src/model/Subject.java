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
	private Professor professor;
	private int espb;
	private Semestar semestar;
	private ArrayList<String> indexPassed ;
	private ArrayList<String> indexNotPassed ;
	
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

	public List<String> getStudentsPassed() {
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
		return "Subject [subjectID=" + subjectID + ", subjectName=" + subjectName + ", subjectYear=" + subjectYear
				+ ", professor=" + professor + ", espb=" + espb + ", semestar=" + semestar + ", indexPassed="
				+ indexPassed + ", indexNotPassed=" + indexNotPassed + "]";
	}	
	
}
