package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DeleteProfessorDialog;
import view.DeleteStudent;
import view.DeleteSubjectDialog;
import view.DeleteSubjectNotPassedDialogue;
import view.TabbedPane;

public class DeleteActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.position==0) {
			if(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()>=0) {
			DeleteStudent deleteS = new DeleteStudent();
			deleteS.setVisible(true);
		}	
		} else if(TabbedPane.position==1) {
			if(TabbedPane.getInstance().getTableProfessors().getSelectedRow()>=0) {
				DeleteProfessorDialog deleteP = new DeleteProfessorDialog();
				deleteP.setVisible(true);
			}
		} else if(TabbedPane.position==2) {
			if(TabbedPane.getInstance().getTableSubjects().getSelectedRow()>=0) {
				DeleteSubjectDialog deleteS = new DeleteSubjectDialog();
				deleteS.setVisible(true);
			}
		}
	}

}
