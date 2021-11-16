package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar{
	
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnCreate = new JButton();
		btnCreate.setToolTipText("Create");
		btnCreate.setIcon(new ImageIcon("icons/pluss.png"));
		add(btnCreate);
		
		addSeparator();
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("icons/edit.png"));
		add(btnOpen);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("icons/trash.png"));
		add(btnDelete);
		
		addSeparator();
		
		
		
		JTextField search = new JTextField();
		search.setPreferredSize(new Dimension(170,35));
		add(search);
		
		add(Box.createHorizontalGlue());
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("icons/searchh.png"));
		add(btnSearch);
		
		
		setFloatable(false);
	}

}
