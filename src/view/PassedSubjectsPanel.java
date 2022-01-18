package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PassedSubjectsPanel extends JPanel{
	
	private JTable tableSubjects;
	PassedSubjectsPanel(){
		
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton nullify = new JButton("Ponisti ocenu");
		buttons.add(nullify);
		
		add(buttons, BorderLayout.WEST);
		tableSubjects=new PassedSubjectsTable();
		JScrollPane subjectsPane=new JScrollPane(tableSubjects);
		add(subjectsPane, BorderLayout.CENTER);
		
	}
	public JTable getTable() {
		return (PassedSubjectsTable) tableSubjects;
	}
}