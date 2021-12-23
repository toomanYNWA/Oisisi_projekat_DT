package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPane extends JTabbedPane {
	
	private static TabbedPane instance = null;

	public static TabbedPane getInstance() {
		if (instance == null) {
			instance = new TabbedPane();
		}
		return instance;
	}
	public static int position=0;
	private StudentsTablePanel studentPanel;
	public TabbedPane() {
		
		studentPanel=new StudentsTablePanel();
		JPanel professorPanel=new JPanel();
		JPanel subjectPanel=new JPanel();
		
		SubjectsJTable tabelSubjects=new SubjectsJTable();
		JScrollPane subjectsPane=new JScrollPane(tabelSubjects);
		subjectPanel.add(subjectsPane);
		
		ProfessorsJTable tabelProfessors=new ProfessorsJTable();
		JScrollPane professorsPane=new JScrollPane(tabelProfessors);
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
	public StudentsTablePanel getStudentsTable() {
		return studentPanel;
	}
}
