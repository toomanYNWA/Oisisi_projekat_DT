package view;

import javax.swing.table.AbstractTableModel;

import model.SubjectsDatabase;

public class AbstractTableModelSubjects extends AbstractTableModel {
	@Override
	public int getRowCount() {
		return SubjectsDatabase.getInstance().getSubjects().size();
	}

	@Override
	public int getColumnCount() {
		return SubjectsDatabase.getInstance().getColumnCount();
	}
	@Override
	public String getColumnName(int column) {
		return SubjectsDatabase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return SubjectsDatabase.getInstance().getValueAt(row, col);
	} 
}
