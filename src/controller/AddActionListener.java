package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddProfessorDialog;
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
		
	}

}
