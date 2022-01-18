package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.AddActionListener;
import controller.DeleteActionListener;
import controller.EditActionListener;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnCreate = new JButton();
		btnCreate.setToolTipText("Add new");
		btnCreate.setIcon(new ImageIcon("icons/pluss.png"));
		add(btnCreate);
		AddActionListener addA = new AddActionListener();
		btnCreate.addActionListener(addA);
		addSeparator();
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Edit");
		btnOpen.setIcon(new ImageIcon("icons/edit.png"));
		add(btnOpen);
		EditActionListener editA = new EditActionListener();
		btnOpen.addActionListener(editA);
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("icons/trash.png"));
		add(btnDelete);
		DeleteActionListener deleteA = new DeleteActionListener();
		btnDelete.addActionListener(deleteA);
		
		addSeparator();
		
		add(Box.createHorizontalGlue());
		
		JTextField search = new JTextField();
		search.setPreferredSize(new Dimension(170,30));
		search.setMaximumSize(search.getPreferredSize());
		add(search);
		
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("icons/searchh.png"));
		add(btnSearch);
		
		setFloatable(false);
	}

}
