package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorsDatabase;

public class AbstractTableModelProfessors extends AbstractTableModel{
	@Override
	public int getRowCount() {
		return ProfessorsDatabase.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return ProfessorsDatabase.getInstance().getColumnCount();
	}
	@Override
	public String getColumnName(int column) {
		return ProfessorsDatabase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		return ProfessorsDatabase.getInstance().getValueAt(row, col);
	}

} 
