package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
	private ArrayList<Student> foundStudent = new ArrayList<Student>();
	private ArrayList<Student> allStudents;
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
		initstudents();
		allStudents = students;
		setNotPassedSubjects();
		
	}
	private void initstudents() {
		this.students = new ArrayList<Student>();
		//this. = new ArrayList<Subject>();
		
		String next=null;
		String[] column=null;
		BufferedReader in=null;
		String [] date = null;
		String [] adr=null;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Students.txt")));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next=in.readLine())!=null) {
				if(next.equals("")) {
					continue;
				}
				
				column=next.split("\\|[' ']*");
			  
			    
			    date = column[2].split("\\.");
			    adr=column[4].split("\\,");
			 
				int st = -1 ;
				if(column[9].trim().equals("B")) {
					st = 0;
				} else if(column[9].trim().equals("S")) st = 1;
				
				int c=0 ;
				if(column[8].trim().equals("I"))
					c=1;
				else if(column[8].trim().equals("II"))
					c=2;
				else if(column[8].trim().equals("III"))
					c=3;
				else if(column[8].trim().equals("IV"))
					c=4;
				else if(column[8].trim().equals("V")) c = 5;
				Address a = new Address(adr[0], adr[1], adr[2], adr[3]);
				LocalDate dt = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				int yoe= Integer.parseInt(column[7].trim());
				Student stu = new Student(column[0].trim(),c,st,column[5].trim(),column[1].trim(),dt,a,column[6].trim(),yoe,column[3].trim());
				students.add(stu);
				//			String nuIndex, int currentYear,int status, String name, String surname, LocalDate dateOfBirth, Address address,String email,int yearOfEnrollment,String phone
//													
				//			Tomislav|Andric |05.04.2000. |0611535796 | Pavla Stosa,3,Subotic,Srbija|ra170/2019|tooman00@gmail.com|2019|I|B
			} 
			
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Student> getStudents(){
		return students;
		//return allStudents;
	}
	public Student getStudentByRow(int row) {
		Student stu = students.get(row);
		return stu;
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
		//this.students.add(new Student(nuIndex, currentYear, status,  name,  surname, dateOfBirth,  address, email,yearOfEnrollment,phone));
		this.allStudents.add(new Student(nuIndex, currentYear, status,  name,  surname, dateOfBirth,  address, email,yearOfEnrollment,phone));
	}
	public void deleteStudent(int indexNu) {
		students.remove(indexNu);
		//remove sa mape
		
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
		notPassed.clear();
		for(Student s: allStudents) {
			for(Subject subj:allSubj) {
				ArrayList<String> nP = subj.getStudentsNotPassed();
				for(String temp : nP) {
					if(s.getNuIndex().equals(temp)) {
						s.addNotPassedSubject(subj);
					}
				}
			}
		}
	} 
	
	public Student getStudentById(String id) {
		for (Student s: allStudents) {
			if(s.getNuIndex().equals(id)) {
				return s;
			} 
		}
		return null;
	}
	/*public ArrayList<Grade> getSubjectsPassed(){
	
		Student stud = StudentsController.getInstance().getStudent(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow());
		if(stud.getPassed()!=null) {
			returnPassed = stud.getPassed();
		} 
		return returnPassed;
	} */
	
	/*public void passExam(int sId) {
		notPassed = getSubjectsNotPassed();
		for(Subject s: notPassed) {
			if(s.getSubjectID()==sId) {
				notPassed.remove(s);
				//passed.add(s);
			}
>>>>>>> e53adbd45ea530837a774f4c84e490c188511eaf
		}
		return null;
	} */
	
	public boolean findBySur(String surname) {
		boolean found = false;
		ArrayList<Student> fs = new ArrayList<Student>();
		for (Student stud : students) {
			
			if(stud.getSurname().toUpperCase().contains(surname.toUpperCase())) {
				foundStudent.add(stud);
				fs.add(stud);
				found = true;
			}
		}
		students = fs;
		return found;
	}
	public boolean findBySurAndName(String surname, String name) {
		boolean found = false;
		ArrayList<Student> fs = new ArrayList<Student>();
		for(Student stud : students) {
			
			if(stud.getSurname().toUpperCase().contains(surname.toUpperCase()) && stud.getName().toUpperCase().contains(name.toUpperCase())) {
				foundStudent.add(stud);
				fs.add(stud);
				found = true;
			}
		}
		students = fs;
		return found;
	}
	
	public boolean findByNuInAndNameAndSur(String index, String name, String surname) {
		boolean found = false;
		ArrayList<Student> fs = new ArrayList<Student>();
		for(Student stud : students) {
			
			if(stud.getNuIndex().toUpperCase().contains(index.toUpperCase()) && stud.getName().toUpperCase().contains(name.toUpperCase()) 
					&& stud.getSurname().toUpperCase().contains(surname.toUpperCase())) {
				foundStudent.add(stud);
				fs.add(stud);
				found = true;
			}
		}
		students = fs;
		return found;
	}
	
	public void resetSearch() {
		ArrayList<Student> pom = new ArrayList<Student>();
		pom = students;
		students = foundStudent;
		foundStudent = pom;
		
	}
	public void emS() {
		students = allStudents;
	} 
	
	public Student getSelectedStudent() {
		return StudentsController.getInstance().getStudent(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow());
	}
	
}
	
	
	
	

