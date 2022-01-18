package controller;

import java.time.LocalDate;

import model.Professor;
import model.StudentDatabase;
import model.Subject;
import model.SubjectsDatabase;
import view.NotPassedSubjectsTable;
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
	 public Subject getSubject(int rowSelectedIndex) {
		 Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
		 return subj;
	 }
	
	 public void passExam(int rowSelectedIndex, int grade, LocalDate examDate) {
		 if (rowSelectedIndex < 0) {
				return;
			}
			Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
			StudentDatabase.getInstance().passExam(subj.getSubjectID());
			NotPassedSubjectsTable.updateNotPassed();
	 }
	 
	 public void annulGrade(int rowSelectedIndex) {
		 if (rowSelectedIndex < 0) {
				return;
			}
		 Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
		 //StudentDatabase.getInstance().annulGrade(subj.getSubjectID());
		 //PasssedSubjectsTable.updatePassed();
		 //NotPassedSubjectsTable.updateNotPassed();
	 }
	 
	 public void addProfOnSubj(int rowSelectedIndex, Professor p) {
		 Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
		 SubjectsDatabase.getInstance().addProfOnSubj(subj, p);
		 TabbedPane.getInstance().updateSubjects();
		 
	 }
	 
	 public void removeProfessor() {
		 
	 }
	 
	 public void addSubject(int subjectID, String subjectName,int semestar, int subjectYear,  int espb) {
		 	
			SubjectsDatabase.getInstance().addSubject(subjectID,  subjectName, semestar, subjectYear, espb);
			
			TabbedPane.getInstance().updateSubjects();
		}
	 
	 public void editSubject(int rowSelectedIndex,int subjectID, String subjectName,int semestar, int subjectYear,  int espb) {
			 
			if (rowSelectedIndex < 0) {
				 return;
			 }
			//Student student = StudentDatabase.getInstance().getRow(rowSelectedIndex);
			SubjectsDatabase.getInstance().editSubject(rowSelectedIndex,subjectID,  subjectName, semestar, subjectYear, espb);
			TabbedPane.getInstance().updateSubjects();
			
		}
}
		

