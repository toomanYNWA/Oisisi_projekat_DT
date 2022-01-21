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
		this.notPassedSubjects = new ArrayList<Subject>();
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina");
		this.columns.add("Semestar");
		//setNotPassedSubjects();
		getNotPassed();
		getSubjects();
	}
	public ArrayList<Subject> getSubjects() {
		subjects = SubjectsDatabase.getInstance().getSubjects();
		return subjects;
	}

	public ArrayList<Subject> getNotPassed() {
		notPassedSubjects = StudentDatabase.getInstance().getSelectedStudent().getNotPassed();
		return notPassedSubjects;
	}

	public void setNotPassed(ArrayList<Subject> notPassed) {
		this.notPassedSubjects = notPassed;
	} 
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
	
	public void loadNotPassedSubjects() {
		ArrayList<Subject> allSubj = SubjectsDatabase.getInstance().getSubjects();
		ArrayList<Student> allStud = StudentDatabase.getInstance().getStudents();
		for(Subject subj: allSubj) {
			for(Student stud:allStud) {
				ArrayList<Subject> nP = stud.getNotPassed();
				for(Subject temp:nP) {
					if(temp==subj) {
						subj.addStudentsNotPassed(stud.getNuIndex());
					}
				}
			}}
	}
	
	/*public void setNotPassedSubjects() {
		ArrayList<Subject> allSubj = SubjectsDatabase.getInstance().getSubjects();
		ArrayList<Student> allStud = StudentDatabase.getInstance().getStudents();
		for(Student s: allStud) {
			for(Subject subj:allSubj) {
				ArrayList<String> nP = subj.getStudentsNotPassed();
				for(String temp : nP) {
					if(s.getNuIndex().equals(temp)) {
						s.addNotPassedSubject(subj);
					}
				}
			}
		}
	} */
	
	public void removePassedExam(Subject s, String indexS) {
		notPassedSubjects.remove(s);
		s.removePassedExam(indexS);
		Student stud = StudentDatabase.getInstance().getStudentById(indexS);
		stud.removeNotPassedSubject(s);
		
	}
	
	public void removeNotPassedExam(Subject s, String indexS) {
		
	}
	
	public void addAnnuledExam(int sId) {
		for(Subject s: subjects)
			if(s.getSubjectID()==sId) 
				notPassedSubjects.add(s);
	}
	public void deleteSubjectNotPassed(Subject sub, Student stud) {
		stud.removeNotPassedSubject(sub);
		notPassedSubjects.remove(sub);
		
	}
}
