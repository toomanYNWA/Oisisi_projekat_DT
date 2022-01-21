package controller;

import model.ProfessorsDatabase;
import view.TabbedPane;

public class SearchProfessorsController {
	ProfessorsDatabase profDB = ProfessorsDatabase.getInstance();
	
	private static SearchProfessorsController instance = null;
	
	public static SearchProfessorsController getInstance() {
		if (instance == null) {
			instance = new SearchProfessorsController();
		}
		return instance;
	}
	
	public void findProfsBySurname(String surname) {
		ProfessorsController.getInstance().findBySurname(surname);
	}
	public void findProfsByName(String name) {
		ProfessorsController.getInstance().findByName(name);
	}
	public void findProfsBySurnameAndName(String surname, String name) {
		ProfessorsController.getInstance().findBySurnameAndName(surname,name);
	}
	
	public void profsSearchEmpty() {
		ProfessorsDatabase.getInstance().switchBetweenFoundAndAll();
		TabbedPane.getInstance().updateProfessors();
	}
	public void emptySearch() {
		ProfessorsDatabase.getInstance().emptySearch();
		TabbedPane.getInstance().updateProfessors();
	}
}
