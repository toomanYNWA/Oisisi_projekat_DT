package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane {
	public TabbedPane() {
		
		JPanel studentPanel=new StudentsTablePanel();
		JPanel professorPanel=new JPanel();
		JPanel subjectPanel=new JPanel();
		
		//tabelaPredmeti=PredmetiJTable.getInstance();
		//JScrollPane predmetiPane=new JScrollPane(tabelaPredmeti);
		
		//tabelaProfesori=ProfesoriJTable.getInstance();
		//JScrollPane profesoriPane=new JScrollPane(tabelaProfesori);

//		tabelaStudenti=StudentsJTable.getInstance();
//		JScrollPane studentiPane=new JScrollPane(tabelaStudenti);
		
		
		add("Studenti", studentPanel);
		add("Profesori", professorPanel);
		add("Predmeti", subjectPanel);
		

	}
}
