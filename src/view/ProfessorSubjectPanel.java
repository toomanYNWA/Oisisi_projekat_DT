package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.NotPassedSubjectsDatabase;
import model.Professor;
import model.ProfessorSubjectDatabase;
import model.ProfessorsDatabase;
import model.Student;
import model.StudentDatabase;
import model.Subject;



public class ProfessorSubjectPanel extends JPanel {
	
	private ProfesorSubjectsTable tableProfSub;
	
	ProfessorSubjectPanel(){
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton add = new JButton("Dodaj predmet");
		JButton delete = new JButton("Ukloni predmet");
		
		buttons.add(add);
		buttons.add(delete);
		add(buttons, BorderLayout.WEST);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ChooseProfessorsSubjectDialogue suD = new ChooseProfessorsSubjectDialogue(tableProfSub);
				
				suD.setVisible(true);
				
			}
		});
		tableProfSub = new ProfesorSubjectsTable();
		
		
		JScrollPane subjectsPane=new JScrollPane(tableProfSub);
		add(subjectsPane, BorderLayout.CENTER);
	
	
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ProfesorSubjectsTable.rowSelectedIndex == -1) {
					JOptionPane.showMessageDialog(null,"Nije oznacen predmet za uklanjanje!","",JOptionPane.ERROR_MESSAGE);
				}else {
				Professor prof = ProfessorsDatabase.getInstance().getRow(TabbedPane.getInstance().getTableProfessors().convertRowIndexToModel(TabbedPane.getInstance().getTableProfessors().getSelectedRow()));
				Subject subj = ProfessorSubjectDatabase.getInstance().getRow(ProfesorSubjectsTable.rowSelectedIndex);
				DeleteProfessorSubjectDialogue dls = new DeleteProfessorSubjectDialogue(subj, prof);
				dls.setVisible(true);
				}
			
				
			}
		});
	}
	public JTable getTable() {
		return (ProfesorSubjectsTable)tableProfSub;
	}
}
