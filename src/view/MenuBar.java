package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
			//new1.setIcon(new ImageIcon("icons/"));
			file.add(new1);
			JMenuItem save = new JMenuItem("Save");
			file.add(save);
			JMenuItem open = new JMenuItem("Open");
			file.add(open);
			JMenuItem close = new JMenuItem("Close");
			new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			file.add(close);
			
			JMenuItem edit2 = new JMenuItem("Edit");
			edit.add(edit2);
			JMenuItem delete = new JMenuItem("Delete");
			edit.add(delete);
			
			JMenuItem help2 = new JMenuItem("Help");
			help.add(help2);
			JMenuItem about = new JMenuItem("About");
			help.add(about);
			
			
			
			
			
		}
}
