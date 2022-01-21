package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import model.NotPassedSubjectsDatabase;
import model.Professor;
import model.ProfessorSubjectDatabase;
import model.ProfessorsDatabase;
import model.StudentDatabase;
import model.Subject;
import model.SubjectsDatabase;

public class ChooseProfessorsSubjectDialogue extends JDialog{
		
	public ChooseProfessorsSubjectDialogue(JTable table) {
		
		setModal(true);
		setSize(300,300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Odaberi predmet");
		Image img = kit.getImage("icons/new.png");
		setIconImage(img);
		
		DefaultListModel<String> subj = new DefaultListModel<String>(); 
		
		int i = 0;
		for(Subject s : SubjectsDatabase.getInstance().getSubjects()) {
			subj.add(i++,s.getSubjectID()+"-"+s.getSubjectName());
			}
		
		JList<String> list = new JList<String>(subj);
		list.setPreferredSize(new Dimension(100,100));
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setViewportView(list);
		listScroller.createVerticalScrollBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 100, 10);
		listScroller.setBorder(emptyBorder);
		
		JPanel dd = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton doo = new JButton("Dodaj");
		JButton dont = new JButton("Odustani");
		dd.add(doo);
		dd.add(dont);
		
		doo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Nije oznacen predmet za dodavanje","",JOptionPane.ERROR_MESSAGE);
				}else {
					String [] trimmed = null;
					String selected = list.getSelectedValue();
					trimmed = selected.split("-");
					int trimmedid= Integer.parseInt(trimmed[0]);
					
					dispose();
					for(Subject s : SubjectsDatabase.getInstance().getSubjects()) {
						if(s.getSubjectID()==(trimmedid)) {
							
							int t=TabbedPane.getInstance().getTableProfessors().getSelectedRow();
							ProfessorsDatabase.getInstance().getRow(t).addSubject(s);
							ProfessorSubjectDatabase.getInstance().setProfessorsSubjects(ProfessorsDatabase.getInstance().getRow(t).getSubjects());
							
					}
						AbstractTableModelProfessorSubject model = (AbstractTableModelProfessorSubject) table.getModel();
						model.fireTableDataChanged();
						validate();
					}
					
					} 
			}
		});
		
		dont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				dispose();
					 
			}
		});
		this.add(listScroller,BorderLayout.CENTER);
		this.add(dd,BorderLayout.SOUTH);

			}
		}