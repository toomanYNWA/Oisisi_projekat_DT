package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.StudentsController;
import view.TabbedPane;




public class StudentDatabase {
	
	public static StudentDatabase instance = null;
	
	public static StudentDatabase getInstance(){
		if (instance== null) {
			instance = new StudentDatabase();
		}
		return instance;		
	}
	//private long generator;
	
	private ArrayList<Student> students;
	private List<String> columns;
	private ArrayList<Subject> notPassed;
	
	private StudentDatabase() {
		this.students = new ArrayList<Student>();
		this.notPassed = new ArrayList<Subject>();
		this.columns = new ArrayList<String>();
		this.columns.add("BROJ INDEKSA");
		this.columns.add("IME");
		this.columns.add("PREZIME");
		this.columns.add("GODINA STUDIJA");
		this.columns.add("STATUS");
		this.columns.add("PROSEK");
		
		
	}
	
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	public void setStudenti(ArrayList<Student> students) {
		this.students = students;
    }
	
	public int getColumnCount() {
		return columns.size();
	}
	public String getColumnName(int index) {
		return this.columns.get(index);
	}
	public Student getRow(int rowIndex) {
		return this.students.get(rowIndex);
	}
	
	public Object getValueAt(int row,int column) {
		Student student = this.students.get(row);
		switch(column) {
		case 0:
			return student.getNuIndex();
		case 1:
			return student.getName();
		case 2:
			return student.getSurname();
		case 3:
			return student.getCurrentYear();
		case 4:
			 if(student.getStatus()==0) {
				 return "B";
			 } else return "S";
		case 5:
			return student.getAverageGrade();
		default:
			return null;
		}
	}
	public void addStudent(String nuIndex, int currentYear,int status, String name, String surname, LocalDate dateOfBirth, Address address,String email,int yearOfEnrollment,String phone) {
		this.students.add(new Student(nuIndex, currentYear, status,  name,  surname, dateOfBirth,  address, email,yearOfEnrollment,phone));
		setNotPassedSubjects();
	}
	public void deleteStudent(int indexNu) {
		students.remove(indexNu);
		
	}
	public Student gback(int r) {
		return students.get(r); 
	}
	public void editStudent(int rowSelectedIndex,String nuIndex, int yearOfEnrollment, int currentYear,int status,  String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address) {
			Student s = gback(rowSelectedIndex);
			
				s.setNuIndex(nuIndex);
				s.setName(name);
				s.setSurname(surname);
				s.setAddress(address);
				s.setCurrentYear(currentYear);
				s.setDateofbirth(dateofbirth);
				s.setStatus(status);
				s.setEmail(email);
				s.setPhone(phone);
				s.setYear(yearOfEnrollment);
				
		
	}
	
	public void setNotPassedSubjects() {
		ArrayList<Subject> allSubj = SubjectsDatabase.getInstance().getSubjects();
		for(Student s: students) {
			for(Subject subj:allSubj) {
				ArrayList<String> nP = subj.getStudentsNotPassed();
				for(String temp : nP) {
					if(s.getNuIndex().equals(temp)) {
						notPassed.add(subj);
					}
				}
			}
			s.setNotPassed(notPassed);
		}
	}
	
	public ArrayList<Subject> getSubjectsNotPassed() {
		Student stud= StudentsController.getInstance().getStudent(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow());
		return stud.getNotPassed();
	} 
	
	public void passExam(int sId) {
		notPassed = getSubjectsNotPassed();
		for(Subject s: notPassed) {
			if(s.getSubjectID()==sId) {
				notPassed.remove(s);
				//passed.add(s);
			}
		}
	}
	/*public void passExam(int sId) {
		Passed = getSubjectsPassed();
		for(Subject s: passed) {
			if(s.getSubjectID()==sId) {
				passed.remove(s);
				notPassed.add(s);
			}
		}
	} */
}
	
	
	
	

