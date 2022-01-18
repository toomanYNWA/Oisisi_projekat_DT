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
import javax.swing.border.Border;

import controller.ProfessorsController;
import controller.SubjectsController;
import model.Professor;
import model.ProfessorsDatabase;
import model.Subject;
import model.SubjectsDatabase;

public class ChooseProfessorDialog extends JDialog{
	public static String fullname;
	public ChooseProfessorDialog() {
		setModal(true);
		setSize(300,300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Odaberi profesora");
		Image img = kit.getImage("icons/new.png");
		setIconImage(img);
		
		DefaultListModel<String> professors = new DefaultListModel<String>(); 
		
		int i = 0;
		for(Professor p : ProfessorsDatabase.getInstance().getProfessors()) {
				professors.add(i++,p.getName()+" "+p.getSurname());
			}
		
		JList<String> list = new JList<String>(professors);
		list.setPreferredSize(new Dimension(100,100));
		JScrollPane listScroller = new JScrollPane();
		listScroller.setViewportView(list);
		listScroller.createVerticalScrollBar();
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 100, 10);
		listScroller.setBorder(emptyBorder);
		
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
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Nije oznacen profesor za dodavanje","",JOptionPane.ERROR_MESSAGE);
				}else {
					String [] trimmed = null;
					String selected = list.getSelectedValue();
					trimmed = selected.split("\\ ");
					String trimmedName = trimmed[0];
					String trimmedSurname = trimmed[1];
					dispose();
					for(Professor p : ProfessorsDatabase.getInstance().getProfessors()) {
						if(p.getName().equals(trimmedName) && p.getSurname().equals(trimmedSurname))
							fullname = p.getName()+" "+p.getSurname();
					}
				}

			}
		});
		
		this.add(listScroller,BorderLayout.CENTER);
		this.add(yesNo,BorderLayout.SOUTH);
	}
	
	public String nameP() {
		return fullname;
	}

}
