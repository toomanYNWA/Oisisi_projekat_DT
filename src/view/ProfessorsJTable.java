package view;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfessorsJTable extends JTable {
	/*private static ProfessorsJTable instance = null;
	public static ProfessorsJTable getInstance() {
		if (instance == null) {
			instance = new ProfessorsJTable();
		}
		return instance;
	} */
	
	public static int rowSelectedIndex = -1;
	public ProfessorsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfessors());
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (row % 2==1) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
