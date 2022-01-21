package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddProfessorDialog;
import view.AddSubjectsDialogue;
import view.StudentDialogue;
import view.TabbedPane;

public class AddActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(TabbedPane.position==0) {
			StudentDialogue addS = new StudentDialogue();
			addS.setVisible(true);
			}
		else if(TabbedPane.position==1) {
			AddProfessorDialog addP=new AddProfessorDialog();
			addP.setVisible(true);
			}
		else if(TabbedPane.position==2) {
			AddSubjectsDialogue addSu=new AddSubjectsDialogue();
			addSu.setVisible(true);
		}
	}

}
