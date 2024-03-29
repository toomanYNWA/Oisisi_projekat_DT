package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SubjectsController;
import model.Student;
import model.Subject;

public class DeleteSubjectNotPassedDialogue extends JDialog {
	public DeleteSubjectNotPassedDialogue(Subject subject,Student student) {
		setModal(true);
		setSize(300,150);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Brisanje predmeta");
		Image img = kit.getImage("icons/trash.png");
		setIconImage(img);
		JPanel message = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel messageL=new JLabel("Da li ste sigurni da zelite da uklonite predmet?");
		message.add(messageL);
		JPanel yesNo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton doo = new JButton("Da");
		JButton dont = new JButton("Ne");
		
		//int selectedSubject = NotPassedSubjectsTable.rowSelectedIndex;
	
		doo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					//
				SubjectsController.getInstance().deleteSubjectNotPassed(subject, student);
				NotPassedSubjectsTable.updateNotPassed();

					dispose();
					
				
			}
		});
		
		
		dont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		yesNo.add(doo);
		yesNo.add(dont);
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(message);
		pattern.add(yesNo);
		this.add(pattern,BorderLayout.CENTER);
	}
}
