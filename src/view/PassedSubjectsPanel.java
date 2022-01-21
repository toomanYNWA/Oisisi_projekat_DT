package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		
		nullify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(PassedSubjectsTable.rowSelectedIndex>=0) {
				 AnnulGradeDialog annG = new  AnnulGradeDialog();
				 annG.setVisible(true);
				}
			}
		});
		
		add(buttons, BorderLayout.WEST);
		tableSubjects=new PassedSubjectsTable();
		JScrollPane subjectsPane=new JScrollPane(tableSubjects);
		add(subjectsPane, BorderLayout.CENTER);
		setVisible(true);
	}
	/*public JTable getTable() {
		return (PassedSubjectsTable) tableSubjects;
	} */
}