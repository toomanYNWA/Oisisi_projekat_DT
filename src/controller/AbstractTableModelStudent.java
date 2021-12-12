package controller;


import javax.swing.table.AbstractTableModel;

import model.StudentDatabase;

public class AbstractTableModelStudent extends AbstractTableModel{
	
	public AbstractTableModelStudent() {
	}
		//br redova
		@Override
		public int getRowCount(){
			return StudentDatabase.getInstance().getStudents().size();
		}
		//broj kolona
		@Override
		public int getColumnCount() {
			return StudentDatabase.getInstance().getColumnCount();
		}
		
		//nazivi kolona u zaglavlju
		@Override
		public String getColumnName(int column) {
			return StudentDatabase.getInstance().getColumnName(column);
		}
		//sadrzaj celije
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			 return StudentDatabase.getInstance().getValueAt(rowIndex, columnIndex);
		}
		
		@Override
		public void setValueAt(Object value, int rowIndex, int columnIndex) {
			super.setValueAt(value, rowIndex, columnIndex);
		}
		
	}

