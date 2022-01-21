package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.RowSetListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.NotPassedSubjectsDatabase;
import model.Student;
import model.StudentDatabase;
import model.Subject;

public class NotPassedSubjectsPanel extends JPanel{
	
	private NotPassedSubjectsTable tableSubjects;
	NotPassedSubjectsPanel(){
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton add = new JButton("Dodaj");
		JButton delete = new JButton("Obrisi");
		JButton exam = new JButton("Polaganje");
		buttons.add(add);
		buttons.add(delete);
		buttons.add(exam);
		add(buttons, BorderLayout.WEST);
		
		exam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(NotPassedSubjectsTable.rowSelectedIndex>=0) {
				 AddGradeDialog addG = new  AddGradeDialog();
				 addG.setVisible(true);
				}
			}
		});
		tableSubjects=new NotPassedSubjectsTable();
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ChooseSubjectDialogue suD = new ChooseSubjectDialogue(tableSubjects);
				
				suD.setVisible(true);
				
			}
		});
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(NotPassedSubjectsTable.rowSelectedIndex == -1) {
					JOptionPane.showMessageDialog(null,"Nije oznacen predmet za uklanjanje!","",JOptionPane.ERROR_MESSAGE);
				}else {
				Student stud = StudentDatabase.getInstance().getRow(TabbedPane.getInstance().getStudentsTable().getTable().convertRowIndexToModel(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()));
				Subject subj = NotPassedSubjectsDatabase.getInstance().getRow(NotPassedSubjectsTable.rowSelectedIndex);
				DeleteSubjectNotPassedDialogue suDel = new DeleteSubjectNotPassedDialogue(subj, stud);
				suDel.setVisible(true);
				}
			}
		});
		
		JScrollPane subjectsPane=new JScrollPane(tableSubjects);
		add(subjectsPane, BorderLayout.CENTER);
	}
	
	public JTable getTable() {
		return (NotPassedSubjectsTable)tableSubjects;
	}
	
	
}
