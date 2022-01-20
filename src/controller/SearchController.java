package controller;


import model.StudentDatabase;
import view.StudentsTablePanel;
import view.TabbedPane;

public class SearchController {
	
	StudentDatabase studDB = StudentDatabase.getInstance();
	
	private static SearchController instance = null;
	
	public static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	
	public void findStudentsBySurname(String surname) {
		StudentsController.getInstance().studentsBySurname(surname);
	}
	
	public void findStudentsBySurnameAndName(String surname, String name) {
		StudentsController.getInstance().studentsBySurAndName(surname, name);
	}
	public void findStudentsByIndexNameAndSurname(String index, String name, String surname) {
		StudentsController.getInstance().studentsByIndexAndNameAndSurname(index, name, surname);
	}
	public void studentsSearchEmpty() {
		StudentDatabase.getInstance().resetSearch();
		TabbedPane.getInstance().getStudentsTable().patchView();
	}
	public void emptySea() {
		StudentDatabase.getInstance().emS();
		TabbedPane.getInstance().getStudentsTable().patchView();
	}
}
