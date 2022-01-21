package view;

import javax.swing.table.AbstractTableModel;

import model.CatDatabase;


public class AbstractTableModelCat  extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return CatDatabase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return CatDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return CatDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
    public String getColumnName(int column) {
        return CatDatabase.getInstance().getColumnName(column);
    }

}
