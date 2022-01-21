package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AboutDialogue  extends JDialog {
	public AboutDialogue() {
	setModal(true);
	setSize(300,300);
	Toolkit kit = Toolkit.getDefaultToolkit();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	setTitle("Pomoc");
	Image img = kit.getImage("icons/interrogation.png");
	setIconImage(img);
		
	JTextArea text = new JTextArea();
	
	text.setText("Aplikacija predstavlja studentsku sluzbu."
			+ "Projekat radili Dragana Kucanski i Tomislav Andric.  "
			+ "Dragana je rodjena u Sapcu. "
			+ " Tomislav je rodjen u  Subotici."
			+ " Rad zavrsen : 21.1.2022.");
	
	text.setLineWrap(true);
	text.setEditable(false);
	
	JScrollPane sc = new JScrollPane(text);
	add(sc);
	}
}