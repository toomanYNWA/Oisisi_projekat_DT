package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;




public class StudentsJTable extends JTable{
		
	public StudentsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudent());
		
		
		
		}
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

 
