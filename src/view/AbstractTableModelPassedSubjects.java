package view;

import javax.swing.table.AbstractTableModel;

import model.ExamsPassedDatabase;

public class AbstractTableModelPassedSubjects extends AbstractTableModel {
	
	@Override
	public int getRowCount() {
		return ExamsPassedDatabase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return ExamsPassedDatabase.getInstance().getColumnCount();
	}
	@Override
	public String getColumnName(int column) {
		return ExamsPassedDatabase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return ExamsPassedDatabase.getInstance().getValueAt(row, col);
	}
}
