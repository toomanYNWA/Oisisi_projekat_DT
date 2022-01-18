package view;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.ExamsPassedDatabase;
import model.SubjectsDatabase;

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
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return ExamsPassedDatabase.getInstance().getColumnName(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ExamsPassedDatabase.getInstance().getValueAt(rowIndex,columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
