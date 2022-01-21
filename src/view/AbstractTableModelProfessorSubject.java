package view;

import javax.swing.table.AbstractTableModel;

import model.ProfessorSubjectDatabase;

public class AbstractTableModelProfessorSubject extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(ProfessorSubjectDatabase.getInstance().getProfessorsSubjects() != null) {			
			return  ProfessorSubjectDatabase.getInstance().getProfessorsSubjects().size();
		}
		else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ProfessorSubjectDatabase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return ProfessorSubjectDatabase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return ProfessorSubjectDatabase.getInstance().getValueAt(row, col);
	}
	
	
}
