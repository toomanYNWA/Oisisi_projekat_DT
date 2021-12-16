package controller;

import java.time.LocalDate;

import model.Address;
import model.Student;
import model.StudentDatabase;
import model.Student.Status;
import view.MainFrame;

public class StudentsController {

		private static StudentsController instance = null;
		
		public static StudentsController getInstance() {
			if(instance==null) {
				instance = new StudentsController();
			}
			return instance;
		}
		private StudentsController() {}
		
		public void addStudent(String nuIndex,int currentYear,int status, String name, String surname, float averageGrade) {
			StudentDatabase.getInstance().addStudent(nuIndex, currentYear, status, name, surname,averageGrade);
			
			//MainFrame.getInstance().patchView("ADDED",-1);
		}
		public void deleteStudent(int rowSelectedIndex) {
			if(rowSelectedIndex < 0) {
				return;
			}
		
		//izmena modela
		Student student = StudentDatabase.getInstance().getRow(rowSelectedIndex);
		StudentDatabase.getInstance().deleteStudent(student.getNuIndex());
		//azuriranje prikaza
		//MainFrame.getInstance().patchView("DELETED",rowSelectedIndex);
		}
		
		public void editStudent(int rowSelectedIndex) {
			if(rowSelectedIndex <0) {
				return;
			}
			Student student = StudentDatabase.getInstance().getRow(rowSelectedIndex);
			//editStudent
			StudentDatabase.getInstance().editStudent(null, rowSelectedIndex, rowSelectedIndex, null, null, null, null, null, null, null);
			//MainFrame.getInstance().patchView(null,-1);
		}	
		
		
		
		
}
