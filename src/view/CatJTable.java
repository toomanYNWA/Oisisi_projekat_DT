package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class CatJTable extends JTable {
	public static JTable cate;
    public static AbstractTableModelCat cateModel; 
    public static int rowSelectedIndex = -1;
    
    public CatJTable() {
        this.setRowSelectionAllowed(true);
        this.setColumnSelectionAllowed(true);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(new AbstractTableModelCat());
        cateModel=(AbstractTableModelCat) this.getModel();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                cate = (JTable) e.getComponent();
                if(cate.getSelectedRow()!=-1) {
                    rowSelectedIndex = cate.convertRowIndexToModel(cate.getSelectedRow());
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
    public static void updateCat() {
        cateModel.fireTableDataChanged();
        rowSelectedIndex = -1;

    }
}