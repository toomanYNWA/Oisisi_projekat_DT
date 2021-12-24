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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ProfessorsController;

public class DeleteProfessorDialog extends JDialog{
	
	public DeleteProfessorDialog() {
		
		setModal(true);
		setSize(300,150);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Brisanje profesora");
		Image img = kit.getImage("icons/trash.png");
		setIconImage(img);
		JPanel message = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel messageL=new JLabel("Da li ste sigurni da zelite da obrisete profesora?");
		message.add(messageL);
		JPanel yesNo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton yes = new JButton("Yes");
		
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorsController.getInstance().deleteProfessor(TabbedPane.getInstance().getTableProfessors().getSelectedRow());
				dispose();
			}
		}); 
		
		JButton no = new JButton("No");
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
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
}
