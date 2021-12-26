package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EditProfessorDialog;
import view.EditStudentDialogue;
import view.TabbedPane;

public class EditActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.position==0) {
			if(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()>=0) {
			EditStudentDialogue editS = new EditStudentDialogue();
			editS.setVisible(true);	
		}
		}
		else if(TabbedPane.position==1) {
			if(TabbedPane.getInstance().getTableProfessors().getSelectedRow()>=0) {
				EditProfessorDialog editP = new EditProfessorDialog();
				editP.setVisible(true);
			}
		}
		
	}

}
