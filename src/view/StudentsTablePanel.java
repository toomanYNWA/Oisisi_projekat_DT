package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class StudentsTablePanel extends JPanel{
	
		
		private JLabel lab;
		private JTable table;
		
		
	StudentsTablePanel(){
		lab = new JLabel("");
		table = new StudentsJTable();
		add(lab);
		add(new JScrollPane(table),BorderLayout.CENTER);
		
		
	}

	public void patchView() {
		AbstractTableModelStudent model = (AbstractTableModelStudent)table.getModel();
		model.fireTableDataChanged();
        validate();
	}
	
	public JTable getTable() {
		return (StudentsJTable)table;
	}

	
}
