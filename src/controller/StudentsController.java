package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Address;
import model.Student;
import model.StudentDatabase;
import view.NotPassedSubjectsTable;
import view.PassedSubjectsTable;
import view.TabbedPane;

public class StudentsController {

		private static StudentsController instance = null;
		private boolean found = false;
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
		
		public void studentsBySurname(String surname) {
			found = StudentDatabase.getInstance().findBySur(surname);
			if(found) {
				TabbedPane.getInstance().getStudentsTable().patchView();
			} else {
				JOptionPane.showMessageDialog(null, "Prezime ne postoji u bazi podataka!");
				TabbedPane.getInstance().getStudentsTable().patchView();
			}
		}
		
		public void studentsByIndexAndNameAndSurname(String index, String name, String surname) {
			found = StudentDatabase.getInstance().findByNuInAndNameAndSur(index, name, surname);
			if(found) {
				
				TabbedPane.getInstance().getStudentsTable().patchView();
			} else {
				
				JOptionPane.showMessageDialog(null, "Ne postoji student sa datim indeksom, imenom i prezimenom!");
				TabbedPane.getInstance().getStudentsTable().patchView();
			}
		}
		
		public void studentsBySurAndName(String surname, String name) {
			
			found = StudentDatabase.getInstance().findBySurAndName(surname, name);
			
			if(found) {
				
				TabbedPane.getInstance().getStudentsTable().patchView();
			} else {
				
				JOptionPane.showMessageDialog(null, "Ne postoji student sa datim imenom i prezimenom!");
				TabbedPane.getInstance().getStudentsTable().patchView();
			}
		}

		public boolean isFound() {
			return found;
		}

		public void setFound(boolean found) {
			this.found = found;
		}
		
}
