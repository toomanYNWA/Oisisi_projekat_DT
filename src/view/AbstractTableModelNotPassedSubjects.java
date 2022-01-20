package view;

import javax.swing.table.AbstractTableModel;

import model.NotPassedSubjectsDatabase;

public class AbstractTableModelNotPassedSubjects extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return NotPassedSubjectsDatabase.getInstance().getNotPassed().size();
	}
	@Override
	public int getColumnCount() {
		return NotPassedSubjectsDatabase.getInstance().getColumnCount();
	}
	@Override
	public String getColumnName(int column) {
		return NotPassedSubjectsDatabase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return NotPassedSubjectsDatabase.getInstance().getValueAt(row, col);
	} 

}
