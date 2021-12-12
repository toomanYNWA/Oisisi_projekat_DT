package controller;

import model.Student;
import model.StudentDatabase;
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
		
		public void addStudent() {
			StudentDatabase.getInstance().addStudent(null, 0, 0, null, 0, null, null, null, null, null, null, null, null, null);
			
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
			//editStudent da l treba ovo u zagradi?
			StudentDatabase.getInstance().editStudent(null, rowSelectedIndex, rowSelectedIndex, null, rowSelectedIndex, null, null, null, null, null, null, null, null, null);
			//MainFrame.getInstance().patchView(null,-1);
		}	
		
		
		
		
}
