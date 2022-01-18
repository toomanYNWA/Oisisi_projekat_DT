package view;

import javax.swing.table.AbstractTableModel;

import model.StudentDatabase;
import model.SubjectsDatabase;

public class AbstractTableModelNotPassedSubjects extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return StudentDatabase.getInstance().getSubjectsNotPassed().size();
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
		return SubjectsDatabase.getInstance().getValueAtNotPassed(row, col);
	} 

}
