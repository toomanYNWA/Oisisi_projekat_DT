package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MenuBar extends JMenuBar {

		public MenuBar() {
				
			JMenu file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			JMenu edit = new JMenu("Edit");
			edit.setMnemonic(KeyEvent.VK_E);
			JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			
			JMenuItem new1 = new JMenuItem("New");
			new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			new1.setIcon(new ImageIcon("icons/new.png"));
			file.add(new1);
			JMenuItem save = new JMenuItem("Save");
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			save.setIcon(new ImageIcon("icons/diskette.png"));
			file.add(save);
			JMenuItem open = new JMenuItem("Open");
			open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			open.setIcon(new ImageIcon("icons/share.png"));
			file.add(open);
			JMenuItem close = new JMenuItem("Close");
			close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			close.setIcon(new ImageIcon("icons/cross.png"));
			file.add(close);
			
			JMenuItem edit2 = new JMenuItem("Edit");
			edit2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
			edit2.setIcon(new ImageIcon("icons/edit.png"));
			edit.add(edit2);
			JMenuItem delete = new JMenuItem("Delete");
			delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
			delete.setIcon(new ImageIcon("icons/trash.png"));
			edit.add(delete);
			
			JMenuItem help2 = new JMenuItem("Help");
			help2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
			help2.setIcon(new ImageIcon("icons/interrogation.png"));
			help.add(help2);
			JMenuItem about = new JMenuItem("About");
			about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			about.setIcon(new ImageIcon("icons/info.png"));
			help.add(about);
			
			
			add(file);
			add(edit);
			add(help);
			
			
			
		}
}