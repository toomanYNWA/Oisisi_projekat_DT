package model;

import java.util.ArrayList;
import java.util.List;

import controller.ProfessorsController;
import view.TabbedPane;

public class ProfessorSubjectDatabase {
		
	public static ProfessorSubjectDatabase instance = null;
	
	public static ProfessorSubjectDatabase getInstance(){
		if (instance== null) {
			instance = new ProfessorSubjectDatabase();
		}
		return instance;		
	}
	
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Subject> professorsSubjects;
	private List<String> columns;
	private Professor p = new Professor();
	
	private ProfessorSubjectDatabase() {
		
		this.professorsSubjects = new ArrayList<Subject>();
		initProfesssorSubject();
		
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra");
		this.columns.add("Naziv");
		this.columns.add("Godina studija");
		this.columns.add("Semestar");
		
		getProfessor();
		
		getProfessorsSubjects();
		
		
	}
	
//	public ArrayList<Subject> getSubjects() {
//		subjects = SubjectsDatabase.getInstance().getSubjects();
//		return subjects;
//	}
	
	public ArrayList<Subject> getProfessorsSubjects(){
		professorsSubjects =  p.getSubjects();
		return professorsSubjects;		
	}
	
	public void setProfessorsSubjects(ArrayList<Subject> ps) {
		this.professorsSubjects = ps;
	}
	public Professor getProfessor() {
		p =ProfessorsController.getInstance().getProfessor(TabbedPane.getInstance().getTableProfessors().convertRowIndexToModel(TabbedPane.getInstance().getTableProfessors().getSelectedRow()));
		return p;
	}
	public void initProfesssorSubject() {
		
		for(Subject s : SubjectsDatabase.getInstance().getSubjects()) {
			if(s.getProfessor() != null) {
				
				if(s.getProfessor() == ProfessorsDatabase.getInstance().getRow(TabbedPane.getInstance().getTableProfessors().convertRowIndexToModel(TabbedPane.getInstance().getTableProfessors().getSelectedRow()))) {
					professorsSubjects.add(s);
					//p.addSubject(s);
			}
			}
		}
	}
	public Object getValueAt(int row, int col) {
		Subject s=this.professorsSubjects.get(row);
		switch(col) {
		case 0:
			return s.getSubjectID();
		case 1:
			return s.getSubjectName();
		case 2:
			return s.getSubjectYear();
		case 3:
			return s.getSemestar();
		default:
			return null;
		}
	}
	public int getColumnCount() {
		return 4;
	}
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	public Subject getRow(int rowIndex) {
		return this.professorsSubjects.get(rowIndex);
	}

	public void deleteSP(Subject selSubject, Professor professor) {
		
		professor.removeSubj(selSubject);
		subjects.remove(selSubject);
		
	}
}
