package view;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PassedSubjectsTable extends JTable {
	public PassedSubjectsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPassedSubjects());
	}
}
