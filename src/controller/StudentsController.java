package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Address;
import model.Student;
import model.StudentDatabase;
import model.Subject;
import model.Student.Status;
import view.MainFrame;
import view.StudentsTablePanel;
import view.TabbedPane;

public class StudentsController {

		private static StudentsController instance = null;
		
		public static StudentsController getInstance() {
			if(instance==null) {
				instance = new StudentsController();
			}
			return instance;
		}
		private StudentsController() {}
		
		public void addStudent(String nuIndex,int currentYear,int status, String name, String surname,LocalDate date,Address address,String email,int yearOfEnrollment,String phone) {
			currentYear++;
			StudentDatabase.getInstance().addStudent(nuIndex, currentYear, status, name, surname,date,address,email,yearOfEnrollment,phone);
			
			TabbedPane.getInstance().getStudentsTable().patchView();
		}
		

		//int row = TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow();
		public void editStudent(int rowSelectedIndex,String nuIndex, int yearOfEnrollment, int currentYear,int status,  String name, String surname, LocalDate dateofbirth, String phone, String email,
				Address address) {
			 currentYear++;
			if (rowSelectedIndex < 0) {
				 return;
			 }
			//Student student = StudentDatabase.getInstance().getRow(rowSelectedIndex);
			StudentDatabase.getInstance().editStudent(rowSelectedIndex, nuIndex,  yearOfEnrollment, currentYear, status, name, surname, dateofbirth, phone, email, address);
			TabbedPane.getInstance().getStudentsTable().patchView();
			
		}	
		
		public void deleteStudent(int rowSelectedIndex) {
			if(rowSelectedIndex < 0) {
				
				return;
			}
			StudentDatabase.getInstance().deleteStudent(rowSelectedIndex);
			TabbedPane.getInstance().getStudentsTable().patchView();
		}
		public Student getStudent(int rowSelectedIndex) {
			Student student = StudentDatabase.getInstance().getRow(rowSelectedIndex);
			return student;
		}
		
}
