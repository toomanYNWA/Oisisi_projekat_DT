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

import controller.StudentsController;

public class DeleteStudent extends JDialog implements ActionListener {
	
	public DeleteStudent() {
		
		setModal(true);
		setSize(300,150);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Brisanje studenta");
		Image img = kit.getImage("icons/trash.png");
		setIconImage(img);
		
		JPanel message = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel messageL=new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
		message.add(messageL);
		JPanel yesNo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton yes = new JButton("Da");
		JButton no = new JButton("Ne");
		
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
				StudentsController.getInstance().deleteStudent(TabbedPane.getInstance().getStudentsTable().getTable().convertRowIndexToModel(TabbedPane.getInstance().getStudentsTable().getTable().getSelectedRow()));
				dispose();

			}
		});
		
		yesNo.add(yes);
		yesNo.add(no);
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(message);
		pattern.add(yesNo);
		this.add(pattern,BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

