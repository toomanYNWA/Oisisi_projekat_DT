package view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CatDialogue extends JDialog{
	
	public CatDialogue() {
	setModal(true);
	setSize(500,500);
	Toolkit kit = Toolkit.getDefaultToolkit();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	setTitle("Katedre");
	Image img = kit.getImage("icons/new.png");
	setIconImage(img);
	    
	JPanel subjectPanel=new JPanel();

	JTable tableSubjects= new CatJTable();
    JScrollPane subjectsPane=new JScrollPane(tableSubjects);
    subjectPanel.add(subjectsPane);
    
    add(subjectPanel);
	}
}
