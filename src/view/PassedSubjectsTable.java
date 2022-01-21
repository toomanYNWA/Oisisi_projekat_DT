package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PassedSubjectsTable extends JTable {
	public static JTable passedTable;
	public static AbstractTableModelPassedSubjects PassedModel; 
	public static int rowSelectedIndex = -1;
	public PassedSubjectsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPassedSubjects());
		PassedModel=(AbstractTableModelPassedSubjects) this.getModel();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				passedTable = (JTable) e.getComponent();
				if(passedTable.getSelectedRow()!=-1) {
					rowSelectedIndex = passedTable.convertRowIndexToModel(passedTable.getSelectedRow());
				}

			}
			});
		
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
	public static void updatePassed() {
		PassedModel.fireTableDataChanged();
		rowSelectedIndex = -1;
		
	}
}
