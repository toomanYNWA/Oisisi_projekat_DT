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
import controller.SearchController;
import controller.StudentsController;


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
		
		
		
		btnSearch.addActionListener(new ActionListener(){
			@Override
    		public void actionPerformed(ActionEvent e) {
    			String search1 = search.getText();
    			
    			if(TabbedPane.position == 0) {
    				if(!search1.equals("")) {
    					String[] split = search1.split(",");
    					if(split.length == 1) {
    						
    						SearchController.getInstance().findStudentsBySurname(search1);
    						
    						if(!StudentsController.getInstance().isFound()) {
    							search.setText("");
    							search1 = "";
    						}
    					}
    					else if(split.length == 2) {
    						split[0] = split[0].trim();
    						split[1] = split[1].trim();
    						SearchController.getInstance().findStudentsBySurnameAndName(split[0], split[1]);;
    						
    						if(!StudentsController.getInstance().isFound()) {
    							search.setText("");
    							search1 = "";
    						}
    					}
    					else if(split.length == 3) {
    						split[0] = split[0].trim();
    						split[1] = split[1].trim();
    						split[2] = split[2].trim();
    						SearchController.getInstance().findStudentsByIndexNameAndSurname(split[0], split[1], split[2]);;
    					
    						if(!StudentsController.getInstance().isFound()) {
    							search.setText("");
    							search1 = "";
    						}
    					}
    				}
    				else {
    					
    					SearchController.getInstance().emptySea();
    				}
    			}
    		}
			
	});
	}

}
