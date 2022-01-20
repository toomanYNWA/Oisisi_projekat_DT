package model;

import java.util.ArrayList;
import java.util.List;

public class NotPassedSubjectsDatabase {
	
	public static NotPassedSubjectsDatabase instance = null;
		public static NotPassedSubjectsDatabase getInstance(){
		if (instance== null) {
			instance = new NotPassedSubjectsDatabase();
		}
		return instance;		
	}
		
	private ArrayList<Subject> subjects;
	private ArrayList<Subject> notPassedSubjects;
	private List<String> columns;
	private NotPassedSubjectsDatabase() {
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina");
		this.columns.add("Semestar");
		notPassedSubjects = getNotPassed();
		getSubjects();
	}
	public ArrayList<Subject> getSubjects() {
		subjects = SubjectsDatabase.getInstance().getSubjects();
		return subjects;
	}

	public ArrayList<Subject> getNotPassed() {
		return StudentDatabase.getInstance().getSelectedStudent().getNotPassed();
	}
	/*public void setNotPassed(ArrayList<Subject> notPassed) {
		this.passed = passed;
	} */
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.notPassedSubjects.get(rowIndex);
	}
	public Object getValueAt(int row, int col) {
		Subject s=this.notPassedSubjects.get(row);
		switch(col) {
		case 0:
			return s.getSubjectID();
		case 1:
			return s.getSubjectName();
		case 2:
			return s.getEspb();
		case 3:
			return s.getSubjectYear();
		case 4:
			return s.getSemestar();
		default:
			return null;
		}
	}
	
	public void removePassedExam(Subject s) {
		notPassedSubjects.remove(s);
	}
	
	public void addAnnuledExam(int sId) {
		for(Subject s: subjects)
			if(s.getSubjectID()==sId)
				notPassedSubjects.add(s);
	}
	
}
