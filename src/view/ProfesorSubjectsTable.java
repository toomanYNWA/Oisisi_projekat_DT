package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesorSubjectsTable extends JTable {
		public static JTable professorSubjectTable;
		public static AbstractTableModelProfessorSubject professorSubjectModel; 
		public static int rowSelectedIndex = -1;
		
		public ProfesorSubjectsTable() {
			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setModel(new AbstractTableModelProfessorSubject());
			professorSubjectModel = (AbstractTableModelProfessorSubject) this.getModel();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					professorSubjectTable = (JTable) e.getComponent();
					if(professorSubjectTable.getSelectedRow()!=-1) {
						rowSelectedIndex = professorSubjectTable.convertRowIndexToModel(professorSubjectTable.getSelectedRow());
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
		public static void updateProfessorSubjectsTable() {
			professorSubjectModel.fireTableDataChanged();
			rowSelectedIndex = -1;
			
		}
		
}
