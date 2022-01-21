package view;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPane extends JTabbedPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableProfessors;
	private JTable tableSubjects;
	private static TabbedPane instance = null;
	private static StatusBar st;
	public static TabbedPane getInstance() {

		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	
	public static TabbedPane getInstance(StatusBar sst) {
		st=sst;
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	public static int position=0;
	private StudentsTablePanel studentPanel;
	public TabbedPane() {
		addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                   switch(getSelectedIndex()) {
                   case 0:
                       st.getStatusLabel().setText(" Studentska služba - Studenti ");
                       break;
                   case 1:
                       st.getStatusLabel().setText(" Studentska služba - Profesori ");
                       break;
                   case 2:
                       st.getStatusLabel().setText(" Studentska služba - Predmeti ");
                       break;
                 
               }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}

        });
		
		studentPanel=new StudentsTablePanel();
		JPanel professorPanel=new JPanel();
		JPanel subjectPanel=new JPanel();

		
		
		tableSubjects=new SubjectsJTable();
		JScrollPane subjectsPane=new JScrollPane(tableSubjects);
		subjectPanel.add(subjectsPane);
		
		tableProfessors =new ProfessorsJTable();
		JScrollPane professorsPane=new JScrollPane(tableProfessors);
		professorPanel.add(professorsPane);
		
		add("Studenti", studentPanel);
		add("Profesori", professorPanel);
		add("Predmeti", subjectPanel);
	
		addChangeListener((ChangeListener) new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
       
				position=getSelectedIndex();
				
			}
		});
		
		
		
	}
	public JTable getTableProfessors() {
		return tableProfessors;
	}
	public void updateProfessors() {
		AbstractTableModelProfessors model=(AbstractTableModelProfessors)tableProfessors.getModel();
		model.fireTableDataChanged();
		validate();
		
	}
	
	public void updateSubjects() {
		AbstractTableModelSubjects model=(AbstractTableModelSubjects)tableSubjects.getModel();
		model.fireTableDataChanged();
		validate();
		
	}
	
	public JTable getTableSubjects() {
		return tableSubjects;
	} 
	
	public StudentsTablePanel getStudentsTable() {
		return studentPanel;
	}
	
	
}
