package view;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

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
		
		this.setAutoCreateRowSorter(true);
		
	        Comparator<String> c = new Comparator<String>() {
	        	String[] st ;
	        	String[] st2;
	            public int compare(String s1, String s2) {
	                st = s1.split("[/ ]");
	                st2 = s2.split("[/ ]");
	                
	                if (!st[0].equals(st2[0])) {
	                    return s1.compareTo(s2);
	                } else{
	                	
	                    if (!st[1].equals(st2[1])) {
	                    	
	                        return Integer.compare(Integer.parseInt(st[1]), Integer.parseInt(st2[1]));
	                    }
	                    
	                }
	                
	                return Integer.compare(Integer.parseInt(st[2]), Integer.parseInt(st2[2]));
	            }
	        };

	        TableRowSorter<AbstractTableModelStudent> sorter = new TableRowSorter<AbstractTableModelStudent>(new AbstractTableModelStudent());
	        sorter.setComparator(0, c);
	        this.setRowSorter(sorter);
//	        
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

 
