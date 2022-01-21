package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.StudentsController;
import controller.SubjectsController;
import model.Subject.Semestar;
import view.StudentsJTable;
import view.StudentsTablePanel;
import view.TabbedPane;

public class SubjectsDatabase {
	private static SubjectsDatabase instance = null;

	public static SubjectsDatabase getInstance() {
		if (instance == null) {
			instance = new SubjectsDatabase();
		}
		return instance;
	}

	private ArrayList<Subject> subjects;
	private ArrayList<Subject> passed;
	private ArrayList<Subject> foundSubj = new ArrayList<Subject>();
	private ArrayList<Subject> allSubjs;
	private List<String> columns;

	private SubjectsDatabase() {
		initsubjects();
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina");
		this.columns.add("Semestar");
		allSubjs = subjects;
	}
	private void initsubjects() {
		this.subjects = new ArrayList<Subject>();
		//this.allSubjs = new ArrayList<Subject>();
		String next=null;
		String[] column=null;
		BufferedReader in=null;
		
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Subjects.txt"),"utf-8"));
		}catch(UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next=in.readLine())!=null) {
				if(next.equals("")) {
					continue;
				}
				
				column=next.split("\\|");
			    //String[] indexPassed = column[6].split("\\#");
			    //String[] indexNotPassed = column[7].split("\\#");
			    
			   // List<String> l = Arrays.<String>asList(indexPassed);
			    //List<String> list = Arrays.<String>asList(indexNotPassed);
			   // ArrayList<String> indexP= new ArrayList<String>(l);
			    //ArrayList<String> indexNP= new ArrayList<String>(list); 
				
				int sId = Integer.parseInt(column[0].trim());
				int sY = Integer.parseInt(column[3].trim());
				int espb = Integer.parseInt(column[4].trim());
				Semestar s;
				if(column[6].trim().equals("ZIMSKI"))
					s=Semestar.WINTER;
				else
					s=Semestar.SUMMER;
				Professor p = ProfessorsDatabase.getInstance().getProfById(column[5].trim());
				
				Subject subj = new Subject(sId ,column[2].trim(),s,sY,p,espb);
				subjects.add(subj);
				//allSubjs.add(new Subject(sId ,column[1].trim(),s,sY,p,espb, indexP, indexNP));
				

			} 
			
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public ArrayList<Subject> getPassed() {
		return passed;
	}
	public void setPassed(ArrayList<Subject> passed) {
		this.passed = passed;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}
	public Object getValueAt(int row, int col) {
		Subject s=this.subjects.get(row);
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

	
	public Subject getSubjById(String id) {
		for (Subject s: subjects) {
			if(String.valueOf(s.getSubjectID()).equals(id)) {
				return s;
			} 
		}
		return null;
	}

	public Subject getSubjectById(int id) {
		for (Subject s: subjects) {
			if(s.getSubjectID()==id) {
				return s;
			} 
		}
		return null;
	}
	
	public Subject getSelectedSubject(int index) {
		return subjects.get(index);
	}
	
	public void deleteSubject(int id) {
		for(Subject s: subjects) {
			if(s.getSubjectID()==id) {
				subjects.remove(s);
				//mora da sadrzi i brisanje prof sa predmeta
				break;
			}
		}
	}
	
	public void addProfOnSubj(Subject s, Professor p) {
		s.setProfessor(p);
	}
	
	public void removeProfessor(Subject s) {
		s.setProfessor(null);
		
	}
	
	public void addSubject(int subjectID, String subjectName,int semestar, int subjectYear, int espb ) {
		//this.subjects.add(new Subject( subjectID,  subjectName, semestar, subjectYear, espb));
		this.allSubjs.add(new Subject( subjectID,  subjectName, semestar, subjectYear, espb));
	}
	public Subject gback(int r) {
		return subjects.get(r); 
	}
	public void editSubject(int rowSelectedIndex,int subjectID, String subjectName,int semestar, int subjectYear, int espb ) {
			Subject s = gback(rowSelectedIndex);
			
				s.setSubjectID(subjectID);
				s.setSubjectName(subjectName);
				s.setSemestar(semestar);
				s.setSubjectYear(subjectYear);
				s.setEspb(espb);
		
	}
	
	public boolean findByName(String name) {
		boolean found = false;
		ArrayList<Subject> fs = new ArrayList<Subject>();
		for (Subject subj: subjects) {
			
			if(subj.getSubjectName().toUpperCase().contains(name.toUpperCase())) {
				foundSubj.add(subj);
				fs.add(subj);
				found = true;
			}
		}
		subjects = fs;
		return found;
	}
	public boolean findById(String id) {
		boolean found = false;
		ArrayList<Subject> fs = new ArrayList<Subject>();
		for (Subject subj: subjects) {
			String Sid = String.valueOf(subj.getSubjectID());
			if(Sid.toUpperCase().contains(id.toUpperCase())) {
				foundSubj.add(subj);
				fs.add(subj);
				found = true;
			}
		}
		subjects = fs;
		return found;
	}
	
	public boolean findByNameAndId(String name, String id){
		boolean found = false;
		ArrayList<Subject> fs = new ArrayList<Subject>();
		for (Subject subj: subjects) {
			String Sid = String.valueOf(subj.getSubjectID());
			if(subj.getSubjectName().toUpperCase().contains(name.toUpperCase()) && Sid.toUpperCase().contains(id.toUpperCase())) {
				foundSubj.add(subj);
				fs.add(subj);
				found = true;
			}
		}
		subjects = fs;
		return found;
	}
	
	public void switchBetweenFoundAndAll() {
		ArrayList<Subject> temp = new ArrayList<Subject>();
		temp = subjects;
		subjects = foundSubj;
		foundSubj = temp;
		
	}
	public void emptySearch() {
		subjects = allSubjs;
	} 
	public String[] findNonUsedSubject(int selectedRowStudent ) {
		
		ArrayList<Subject> allSubjects = subjects;
		ArrayList<Subject> filteredSubjectsByYear = new ArrayList<Subject>();
		for(Subject s : allSubjects) {
			if(s.getSubjectYear() <= StudentDatabase.getInstance().getRow(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()).getCurrentYear()) {
				filteredSubjectsByYear.add(s);
			}
		}
		ArrayList<Subject> notPassed = StudentDatabase.getInstance().getStudentByRow(selectedRowStudent).getNotPassed();
		ArrayList<Grade> passedGrade = StudentDatabase.getInstance().getStudentByRow(selectedRowStudent).getPassed();
		
		ArrayList<Subject> subjPassedFromGrade = new ArrayList<Subject>();
		
		for(Grade gr: passedGrade) {
			subjPassedFromGrade.add(gr.getSubject());
		}
		ArrayList<Subject> finalList = new ArrayList<Subject>();
		for(Subject subject : filteredSubjectsByYear) {
			if((!notPassed.contains(subject)) && (!subjPassedFromGrade.contains(subject))) {
				
					finalList.add(subject);
			}
		
		}
		
		String[] leftoverSubj = new String[finalList.size()];
		
		int iterator = 0 ;
		for(Subject subject : finalList) {
			leftoverSubj[iterator] = subject.toString();
			iterator++;
		}
		return leftoverSubj;
	}
	public String[] findNonUsedSubjectInProfessor(int selectedRowProfessor ) {
		
		ArrayList<Subject> allSubjects = subjects;
		ArrayList<Subject> professorsSubjects = ProfessorSubjectDatabase.getInstance().getProfessor().getSubjects();
		ArrayList<Subject> filtered = new ArrayList<Subject>();
		
		for(Subject subject : allSubjects) {
			if(!professorsSubjects.contains(subject)) {
				filtered.add(subject);
			}	
		
		}
		String[] list = new String[filtered.size()];
		for(int i = 0; i<filtered.size();i++) {
			list[i]= filtered.get(i).getSubjectID()+"-"+filtered.get(i).getSubjectName();
		}
		return list ;
	}
}
