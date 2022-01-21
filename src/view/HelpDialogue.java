package view;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDialogue extends JDialog {
	
	public HelpDialogue() {
		
		setModal(true);
		setSize(300,300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Pomoc");
		Image img = kit.getImage("icons/interrogation.png");
		setIconImage(img);
			
		JTextArea text = new JTextArea();
		
		text.setText("Precice: CTRL+n - otvara prozor za unosenje osobe/predmeta otvorenog taba\n"
				+ "	CTRL+e - otvara prozor za promene u podacima otvorenog taba\n"
				+ "CTRL+d - brise odabranog clana tabele otvorenog taba\n"
				+ "Mneumonici: Pomoci komande alt+(f,e,h)  se preko tastature(strelica i entera) pristupa poljima na Meni liniji(Menu Bar)\n"
				+ "Aplikacija je studentska sluzba koja drzi podatke o odredjenom broju studenata, profesora i predmeta.\n "
				+ "Sve nabrojane je moguce dodati i ukloniti iz baza podataka, takodje se moze i pristupiti njihovim podacima i menjati iste.\n");
		
		text.setLineWrap(true);
		text.setEditable(false);
		
		JScrollPane sc = new JScrollPane(text);
		add(sc);
	}
}
