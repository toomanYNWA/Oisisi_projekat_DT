package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class NotPassedSubjectsTable extends JTable {
	public static JTable notPassedTable;
	public static AbstractTableModelNotPassedSubjects notPassedModel; 
	public static int rowSelectedIndex = -1;
	public NotPassedSubjectsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelNotPassedSubjects());
		notPassedModel=(AbstractTableModelNotPassedSubjects) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				notPassedTable = (JTable) e.getComponent();
				if(notPassedTable.getSelectedRow()!=-1) {
					rowSelectedIndex = notPassedTable.convertRowIndexToModel(notPassedTable.getSelectedRow());
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
	public static void updateNotPassed() {
		notPassedModel.fireTableDataChanged();
		rowSelectedIndex = -1;
		
	}

}
