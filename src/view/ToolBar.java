package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar{
	
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnCreate = new JButton();
		btnCreate.setToolTipText("Create");
		//btnCreate.setIcon(new ImageIcon("");
		add(btnCreate);
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		//btnOpen.setIcon(new ImageIcon("");
		add(btnOpen);
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		//btnDelete.setIcon(new ImageIcon("");
		add(btnDelete);
		
		add(Box.createHorizontalGlue());
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		//btnDelete.setIcon(new ImageIcon("");
		add(btnSearch);
		
		
		setFloatable(false);
	}

}
