package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import model.Professor;
import model.ProfessorsDatabase;
import model.Subject;
import model.SubjectsDatabase;

public class AddSubjToProfDialog extends JDialog{
	public AddSubjToProfDialog() {
		setModal(true);
		setSize(300,300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodaj predmet");
		Image img = kit.getImage("icons/new.png");
		setIconImage(img);
		
		DefaultListModel<String> subjs = new DefaultListModel<String>(); 
		
		Professor selectedP = new Professor(ProfessorsDatabase.getInstance().getRow(TabbedPane.getInstance().getTableProfessors().getSelectedRow()));
		int i = 0;
		for(Subject s : SubjectsDatabase.getInstance().getSubjects()) {
			if(s.getProfessor().getId()!=selectedP.getId())
				subjs.add(i++,s.getSubjectID()+" - "+s.getSubjectName());
			}
		
		JList<String> list = new JList<String>(subjs);
		list.setPreferredSize(new Dimension(200,200));
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(list);
		listScroller.createVerticalScrollBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 100, 10);
		listScroller.setBorder(emptyBorder);
		
		JPanel plabel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JLabel label = new JLabel();
		label.setText("Predmeti:");
		plabel.add(label);
		JPanel yesNo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton no = new JButton("Odustani");
		JButton yes = new JButton("Potvrdi");
		yesNo.add(yes);
		yesNo.add(no);
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(yesNo);
		pattern.add(Box.createGlue());
		this.add(plabel, BorderLayout.NORTH);
		this.add(listScroller,BorderLayout.CENTER);
		this.add(pattern,BorderLayout.SOUTH);
		
	}

}
