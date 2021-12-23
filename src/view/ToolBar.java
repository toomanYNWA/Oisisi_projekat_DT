package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

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
		//btnCreate.addMouseListener(new AddProfessorListener());
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.position==0) {
					StudentDialogue addS = new StudentDialogue();
					addS.setVisible(true);
					}
				else if(TabbedPane.position==1) {
				AddProfessorDialog addP = new AddProfessorDialog();
				addP.setVisible(true);
				}}
			
		});
		addSeparator();
		
		JButton btnOpen = new JButton();
		btnOpen.setToolTipText("Open");
		btnOpen.setIcon(new ImageIcon("icons/edit.png"));
		add(btnOpen);
		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.position==1) {
				EditProfessorDialog editP = new EditProfessorDialog();
				editP.setVisible(true);
				}
				else if(TabbedPane.position==0) {
					EditStudentDialogue editS = new EditStudentDialogue();
					editS.setVisible(true);
				}
				}
			
		});
		
		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("icons/trash.png"));
		add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(TabbedPane.position==1) {
				DeleteProfessorDialog deleteP = new DeleteProfessorDialog();
				deleteP.setVisible(true);
				}
				else if(TabbedPane.position==0) {
					DeleteStudent deleteS = new DeleteStudent();
					deleteS.setVisible(true);
				}
					}
			
		});
		
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
