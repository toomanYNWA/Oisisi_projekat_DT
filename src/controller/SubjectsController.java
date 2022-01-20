package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.ExamsPassedDatabase;
import model.NotPassedSubjectsDatabase;
import model.Professor;
import model.Student;
import model.StudentDatabase;
import model.Subject;
import model.SubjectsDatabase;
import view.NotPassedSubjectsTable;
import view.PassedSubjectsTable;
import view.TabbedPane;

public class SubjectsController {
	private static SubjectsController instance = null;
	private boolean found = false;
	
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
	
	 public void passExam(int subjId, int grade, LocalDate examDate) {
			Subject subj = SubjectsDatabase.getInstance().getSubjectById(subjId);
			Student stud= StudentsController.getInstance().getStudent(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow());
			NotPassedSubjectsDatabase.getInstance().removePassedExam(subj, stud.getNuIndex());
			ExamsPassedDatabase.getInstance().passExam(stud, subj, grade, examDate);
			NotPassedSubjectsTable.updateNotPassed();
			PassedSubjectsTable.updatePassed(); 
	 }
	 
	 public void annulGrade(int subjId) {
		 ExamsPassedDatabase.getInstance().annulGrade(subjId); 
		 NotPassedSubjectsDatabase.getInstance().addAnnuledExam(subjId);
		 NotPassedSubjectsTable.updateNotPassed();
		 PassedSubjectsTable.updatePassed();
	 }
	 
	 public void addProfOnSubj(int rowSelectedIndex, Professor p) {
		 Subject subj = SubjectsDatabase.getInstance().getRow(rowSelectedIndex);
		 SubjectsDatabase.getInstance().addProfOnSubj(subj, p);
		 TabbedPane.getInstance().updateSubjects();
		 
	 }
	 
	 public void removeProfessor(Subject s) {
		 SubjectsDatabase.getInstance().removeProfessor(s);
		 TabbedPane.getInstance().updateSubjects();
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
	 public void findByName(String name) {
			found = SubjectsDatabase.getInstance().findByName(name);
			if(found) {
				TabbedPane.getInstance().updateSubjects();
			} else {
				JOptionPane.showMessageDialog(null, "Ne postoji predmet sa unetim nazivom");
				TabbedPane.getInstance().updateSubjects();
			}
		}
	 public void findByNameAndId(String name, String id) {
		 	found = SubjectsDatabase.getInstance().findByNameAndId(name, id);
			if(found) {
				TabbedPane.getInstance().updateSubjects();
			} else {
				JOptionPane.showMessageDialog(null, "Ne postoji predmet sa unetim nazivom i sifrom");
				TabbedPane.getInstance().updateSubjects();
			}
		}

	 public boolean isFound() {
			return found;
		}

	 public void setFound(boolean found) {
			this.found = found;
		}

	 
	public String[] findNonUsedSubject(int selectedRowStudent) {
		return SubjectsDatabase.getInstance().findNonUsedSubject(selectedRowStudent);
		
	}
	
}
		

