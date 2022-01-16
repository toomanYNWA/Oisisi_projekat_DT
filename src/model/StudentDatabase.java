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
	private ArrayList<Subject> nPS;
	
	private StudentDatabase() {
		this.students = new ArrayList<Student>();
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
	
	public void addNotPassedSubjects(Subject sub) {
		for(Student s:students) {
			ArrayList<String> nP = sub.getStudentsNotPassed();
			for(String str:nP) {
				if(s.getNuIndex().equals(str)) 
					s.addNotPassedSubject(sub);
			}
		}
	}

}
	
	
	
	

