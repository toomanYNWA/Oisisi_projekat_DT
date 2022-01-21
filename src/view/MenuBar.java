package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.AddActionListener;
import controller.DeleteActionListener;
import controller.EditActionListener;
import model.Professor;
import model.ProfessorsDatabase;



public class MenuBar extends JMenuBar {
		private JMenu file;
		private JMenu edit;
		private JMenu help;
		private JMenu admin;
		private JCheckBoxMenuItem serbian;
		private JCheckBoxMenuItem english ;
		private JMenuItem new1 ;
		private JMenuItem save;
		private JMenu open;
		private JMenuItem students;
		private JMenuItem professor;
		private JMenuItem sub;
		private JMenuItem cat;
		private JMenuItem close;
		private JMenuItem edit2;
		private JMenuItem delete;
		private JMenuItem help2;
		private JMenuItem about;
		
		public MenuBar() {
				
			//file = new JMenu(MainFrame.getInstance().getResourcesBundle().getString("fileMB"));
			file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			//edit = new JMenu(MainFrame.getInstance().getResourcesBundle().getString("editMB"));
			edit = new JMenu("Edit");
			edit.setMnemonic(KeyEvent.VK_E);
			//help = new JMenu(MainFrame.getInstance().getResourcesBundle().getString("helpMB"));
			help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			/*admin = new JMenu(MainFrame.getInstance().getResourcesBundle().getString("adminMB"));
			admin = new JMenu("Admin");
			serbian = new JCheckBoxMenuItem("Serbian");
			english = new JCheckBoxMenuItem("English");
			//serbian = new JCheckBoxMenuItem(MainFrame.getInstance().getResourcesBundle().getString("serbianMB"));
			//english = new JCheckBoxMenuItem(MainFrame.getInstance().getResourcesBundle().getString("englishMB"));
			english.setSelected(true);
			serbian.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("sr","RS"));
					MainFrame.getInstance().changeLanguageComponents();
				}
					
				
			});
			english.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("en","US"));
					MainFrame.getInstance().changeLanguageComponents();
				}
					
				
			});
			admin.add(english);
			admin.add(serbian); */
			
			//new1 = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("new1MB"));
			new1 = new JMenuItem("New");
			new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
			new1.setIcon(new ImageIcon("icons/new.png"));
			file.add(new1);
			//save = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("saveMB"));
			save = new JMenuItem("Save");
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			save.setIcon(new ImageIcon("icons/diskette.png"));
			file.add(save);
			//open = new JMenu(MainFrame.getInstance().getResourcesBundle().getString("openMB"));
			open = new JMenu("Open");
			open.setMnemonic(KeyEvent.VK_O);
			open.setIcon(new ImageIcon("icons/share.png"));
			//students = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("studentsMB"));
			students = new JMenuItem("Students");
			open.add(students);
			//professor = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("professorMB"));
			professor = new JMenuItem("Professors");
			
			open.add(professor);
			sub = new JMenuItem("Subejcts");
			//sub = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("subMB"));
			open.add(sub);
			//cat = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("catMB"));
			cat = new JMenuItem("Cathedras");
			open.add(cat);
			
			cat.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					CatDialogue c = new CatDialogue();
					
					c.setVisible(true);
					
				}
					

			});
			
			professor.setIcon(new ImageIcon("icons/female.png"));
			students.setIcon(new ImageIcon("icons/reading.png"));
			file.add(open);
			cat.setIcon(new ImageIcon("icons/chairman.png"));
			sub.setIcon(new ImageIcon("icons/book.png"));
			//close = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("closeMB"));
			close = new JMenuItem("Close");
			close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			close.setIcon(new ImageIcon("icons/cross.png"));
			file.add(close);
			
			//edit2 = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("edit2MB"));
			edit2 = new JMenuItem("Edit");
			edit2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
			edit2.setIcon(new ImageIcon("icons/edit.png"));
			edit.add(edit2);
			//delete = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("deleteMB"));
			delete = new JMenuItem("Delete");
			delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
			delete.setIcon(new ImageIcon("icons/trash.png"));
			edit.add(delete);
			
			//help2 = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("help2MB"));
			help2 = new JMenuItem("Help");
			help2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
			help2.setIcon(new ImageIcon("icons/interrogation.png"));
			help.add(help2);
			
			help2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					HelpDialogue c = new HelpDialogue();
					
					c.setVisible(true);
					
				}
					

			});
			//about = new JMenuItem(MainFrame.getInstance().getResourcesBundle().getString("aboutMB"));
			about = new JMenuItem("About");
			about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			about.setIcon(new ImageIcon("icons/info.png"));
			help.add(about);
			about.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					AboutDialogue c = new AboutDialogue();
					
					c.setVisible(true);
					
				}
					

			});
			students.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
			professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
			sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
			cat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
			
			
			
			add(file);
			add(edit);
			add(help);
			//add(admin);
			
			AddActionListener addA = new AddActionListener();
			new1.addActionListener(addA);
			EditActionListener editA = new EditActionListener();
			edit2.addActionListener(editA);
			DeleteActionListener deleteA = new DeleteActionListener();
			delete.addActionListener(deleteA);
			
		}
		public void init() {
			/*file.setText(MainFrame.getInstance().getResourcesBundle().getString("fileMB"));
			edit.setText(MainFrame.getInstance().getResourcesBundle().getString("editMB"));
			help.setText(MainFrame.getInstance().getResourcesBundle().getString("helpMB"));
			admin.setText(MainFrame.getInstance().getResourcesBundle().getString("adminMB"));
			serbian.setText(MainFrame.getInstance().getResourcesBundle().getString("serbianMB"));
			english.setText(MainFrame.getInstance().getResourcesBundle().getString("englishMB"));
			new1.setText(MainFrame.getInstance().getResourcesBundle().getString("new1MB"));
			save.setText(MainFrame.getInstance().getResourcesBundle().getString("saveMB"));
			open.setText(MainFrame.getInstance().getResourcesBundle().getString("openMB"));
			students.setText(MainFrame.getInstance().getResourcesBundle().getString("studentsMB"));
			professor.setText(MainFrame.getInstance().getResourcesBundle().getString("professorMB"));
			sub.setText(MainFrame.getInstance().getResourcesBundle().getString("subMB"));
			cat.setText(MainFrame.getInstance().getResourcesBundle().getString("catMB"));
			close.setText(MainFrame.getInstance().getResourcesBundle().getString("closeMB"));
			edit2.setText(MainFrame.getInstance().getResourcesBundle().getString("edit2MB"));
			delete.setText(MainFrame.getInstance().getResourcesBundle().getString("deleteMB"));
			help2.setText(MainFrame.getInstance().getResourcesBundle().getString("help2MB"));
			about.setText(MainFrame.getInstance().getResourcesBundle().getString("aboutMB"));*/
		}
}
