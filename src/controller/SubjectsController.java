package controller;

import model.Subject;
import model.SubjectsDatabase;
import view.TabbedPane;

public class SubjectsController {
private static SubjectsController instance = null;
	
	public static SubjectsController getInstance() {
		if(instance==null) {
			instance = new SubjectsController();
		}
		return instance;
	}
	private SubjectsController() {}
	
	public void deleteSubject(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
		SubjectsDatabase.getInstance().deleteSubject(subj.getSubjectID());
		TabbedPane.getInstance().updateSubjects();
    }
}
