package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class ProfessorSubjectPanel extends JPanel {
	
	private ProfesorSubjectsTable tableProfSub;
	
	ProfessorSubjectPanel(){
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton doo = new JButton("Dodaj predmet");
		JButton dont = new JButton("Ukloni predmet");
		
		buttons.add(doo);
		buttons.add(dont);
		add(buttons, BorderLayout.WEST);
		
		doo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ChooseProfessorsSubjectDialogue suD = new ChooseProfessorsSubjectDialogue(tableProfSub);
				
				suD.setVisible(true);
				
			}
		});
		tableProfSub = new ProfesorSubjectsTable();
		
		
		JScrollPane subjectsPane=new JScrollPane(tableProfSub);
		add(subjectsPane, BorderLayout.CENTER);
	}
	
	public JTable getTable() {
		return (ProfesorSubjectsTable)tableProfSub;
	}
}
