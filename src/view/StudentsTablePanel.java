package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentsTablePanel extends JPanel{
	
		//labela za studenta i tabela za studenta
		private JLabel lab;
		private JTable table;
		
		
	StudentsTablePanel(){
		lab = new JLabel("STUDENTS");
		table = new StudentsJTable();
		add(lab);
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}
	
	
	
	
	
}
