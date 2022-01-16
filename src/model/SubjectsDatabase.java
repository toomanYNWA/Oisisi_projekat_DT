package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import controller.StudentsController;
import model.Subject.Semestar;
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
	private ArrayList<Subject> notPassed;
	private List<String> columns;

	private SubjectsDatabase() {
		initsubjects();
		this.columns = new ArrayList<String>();
		this.columns.add("Šifra predmeta");
		this.columns.add("Naziv predmeta");
		this.columns.add("ESPB");
		this.columns.add("Godina");
		this.columns.add("Semestar");
	}
	private void initsubjects() {
		this.subjects = new ArrayList<Subject>();
		this.notPassed = new ArrayList<Subject>();
		
		String next=null;
		String[] column=null;
		BufferedReader in=null;
		
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Subjects.txt")));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next=in.readLine())!=null) {
				if(next.equals("")) {
					continue;
				}
				
				column=next.split("\\|");
			    String[] indexPassed = column[6].split("\\#");
			    String[] indexNotPassed = column[7].split("\\#");
			    
			    List<String> l = Arrays.<String>asList(indexPassed);
			    List<String> list = Arrays.<String>asList(indexNotPassed);
			    ArrayList<String> indexP= new ArrayList<String>(l);
			    ArrayList<String> indexNP= new ArrayList<String>(list); 
				
				int sId = Integer.parseInt(column[0].trim());
				int sY = Integer.parseInt(column[3].trim());
				int espb = Integer.parseInt(column[5].trim());
				Semestar s;
				if(column[2].trim().equals("WINTER"))
					s=Semestar.WINTER;
				else
					s=Semestar.SUMMER;
				Professor p = ProfessorsDatabase.getInstance().getProfById(column[4].trim());
				
				subjects.add(new Subject(sId ,column[1].trim(),s,sY,p,espb, indexP, indexNP));
				
					

			} 
			
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	
	public ArrayList<Subject> getSubjectsNotPassed() {
		return notPassed;
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
	
	public Object getValueAtNotPassed(int row, int col) {
		//Student stud = new Student(StudentsController.getInstance().getStudent(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()));
		Student stud = new Student(StudentDatabase.getInstance().getRow(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()));
		Subject s=stud.getNotPassed().get(row);
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
	
	public void deleteSubject(int id) {
		for(Subject s: subjects) {
			if(s.getSubjectID()==id) {
				subjects.remove(s);
				//mora da sadrzi i brisanje prof sa predmeta
				break;
			}
		}
	}
	
	/*public void annulGrade(int id) {
		for(Subject s: subjects) {
			if(s.getSubjectID()==id) {
				
				break;
			}
		}
	} */
	
}
