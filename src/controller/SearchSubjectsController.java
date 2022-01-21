package controller;

import model.SubjectsDatabase;
import view.TabbedPane;

public class SearchSubjectsController {
	SubjectsDatabase subjDB = SubjectsDatabase.getInstance();
	
	private static SearchSubjectsController instance = null;
	
	public static SearchSubjectsController getInstance() {
		if (instance == null) {
			instance = new SearchSubjectsController();
		}
		return instance;
	}
	
	public void findSubjsByName(String name) {
		SubjectsController.getInstance().findByName(name);
	}
	public void findSubjsByNameAndId(String name, String id) {
		SubjectsController.getInstance().findByNameAndId(name, id);
	}
	
	public void subjsSearchEmpty() {
		SubjectsDatabase.getInstance().switchBetweenFoundAndAll();
		TabbedPane.getInstance().updateSubjects();
	}
	public void emptySearch() {
		SubjectsDatabase.getInstance().emptySearch();
		TabbedPane.getInstance().updateSubjects();
	}

}
