package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.StudentsController;
import view.TabbedPane;

public class ExamsPassedDatabase {
	
	public static ExamsPassedDatabase instance = null;
	
	public static ExamsPassedDatabase getInstance(){
		if (instance== null) {
			instance = new ExamsPassedDatabase();
		}
		return instance;		
	}
	
	private ArrayList<Grade> subGr = new ArrayList<Grade>();
	private ArrayList<Grade> studsGr = new ArrayList<Grade>();
	private ArrayList<String> col;

	public ExamsPassedDatabase() {
	
		col = new ArrayList<String>();
		col.add("ID");
		col.add("IME");
		col.add("ESPB");
		col.add("OCENA");
		col.add("DATUM");
		//initialize();
		
	}
	/*public void initialize() {
		String next=null;
		String[] column=null;
		String [] date = null;
		BufferedReader in=null;
		
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Grades.txt")));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next=in.readLine())!=null) {
				if(next.equals("")) {
					continue;
				}
				
				column=next.split("\\|");
				String studentId = column[0].trim();
				int subjectId = Integer.parseInt(column[1].trim());
				int value = Integer.parseInt(column[2].trim());
				date = column[3].split("\\.");
				LocalDate ld = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				Student s = StudentDatabase.getInstance().getStudentById(studentId);
				Subject sub = SubjectsDatabase.getInstance().getSubjectById(subjectId);
				System.out.println(sub);
				System.out.println(s);
				Grade grade = new Grade(s,sub,value,ld);
				subGr.add(grade);
				
			} 
			
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
	} */
	public int getRowCount() {
		return subGr.size();
	}
	
	public int getColumnCount() {
		return 5;
	}
	public String getColumnName(int index) {
		return this.col.get(index);
	}
	public Grade getRow(int rowIndex) {
		return this.subGr.get(rowIndex);
	}
	
	public Object getValueAt(int row,int column) {
		Grade gr = this.subGr.get(row);
		switch(column) {
		case 0:
			return gr.getSubject().getSubjectID();
		case 1:
			return gr.getSubject().getSubjectName();
		case 2:
			return gr.getSubject().getEspb();
		case 3:
			return gr.getValue();
		case 4:
			return gr.getDateofExam().toString();
		
		default:
			return null;
		}
	}
	
	public void passExam(Student st,Subject s, int grade, LocalDate examDate) {
		this.subGr.add(new Grade(st,s,grade,examDate));
	}  
	
	public void annulGrade(int id) {
		for(Grade g: subGr) {
			if(g.getSubject().getSubjectID()==id) {
				subGr.remove(g);
				g.getSubject().addAnnuledExam(g.getStudentPassed().getNuIndex());
				break;
			}
		
		}
	} 
}
