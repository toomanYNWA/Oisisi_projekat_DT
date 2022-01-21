package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ProfessorsController;
import controller.StudentsController;
import controller.SubjectsController;
import model.Address;
import model.Professor;
import model.ProfessorsDatabase;
import model.Student;
import model.StudentDatabase;
import model.Subject;
import model.SubjectsDatabase;

public class EditSubjectsDialogue extends JDialog{
	public static JTextField idTF;
	public static JTextField nameTF;
	public static JTextField yearTF;
	public static JTextField profTF;
	public static JTextField espbTF;
	public static JTextField semesTF;
	public String nameP;
	public Professor selP;
//	public static JTextField passedTF;
//	public static JTextField notPassedTF;
	
	
	public JButton doo;
	public EditSubjectsDialogue() {
		

		setModal(true);
		setSize(450,500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje predmeta");
		Image img = kit.getImage("icons/pluss.png");	
		setIconImage(img);
		
		Dimension dim = new Dimension(100,20);
		
		JPanel id = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel idL=new JLabel("ID: *");
		idL.setPreferredSize(dim);
		idTF=new JTextField();
		idTF.setPreferredSize(new Dimension(200,25));
		//idTF.setName("txtRequired");
		//idTF.addFocusListener(focus);
		idTF.setToolTipText("Unesite ID");
		
		id.add(idL);
		id.add(idTF);
		
		idTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//pozovi fju provera svih empti ili ne polja
				check();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}
			
		});
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel nameL=new JLabel("Ime: *");
		nameL.setPreferredSize(dim);
		nameTF=new JTextField();
		nameTF.setPreferredSize(new Dimension(200,25));
		//nameTF.setName("txtRequired");
		//nameTF.addFocusListener(focus);
		nameTF.setToolTipText("Unesite ime");
		
		name.add(nameL);
		name.add(nameTF);
		
		nameTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//pozovi fju provera svih empti ili ne polja
				check();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}
			
		});
		JPanel year = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel yearL=new JLabel("Godina: *");
		yearL.setPreferredSize(dim);
		yearTF=new JTextField();
		yearTF.setPreferredSize(new Dimension(200,25));
		//yearTF.setName("txtRequired");
		//yearTF.addFocusListener(focus);
		yearTF.setToolTipText("Unesite godinu");
		
		year.add(yearL);
		year.add(yearTF);
		
		yearTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//pozovi fju provera svih empti ili ne polja
				check();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}
			
		});
		
		JPanel prof = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel profL=new JLabel("Profesor: *");
		profL.setPreferredSize(dim);
		profTF=new JTextField();
		profTF.setPreferredSize(new Dimension(120,25));
        profTF.setToolTipText("Unesite profesora");
        JButton plus = new JButton();
        plus.setIcon(new ImageIcon("icons/plusprof.png"));
        plus.setPreferredSize(new Dimension(25,25));
        JButton minus = new JButton();
        minus.setIcon(new ImageIcon("icons/minusprof.png"));
        minus.setPreferredSize(new Dimension(25,25));
        
        prof.add(profL);
        prof.add(profTF);
        prof.add(minus);
        prof.add(plus);
        
        plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ChooseProfessorDialog cP = new ChooseProfessorDialog();
				cP.setVisible(true);
				nameP=cP.nameP();
				profTF.setText(nameP);
				minus.setEnabled(true);
				plus.setEnabled(false);

			}
		});
        
		
		JPanel espb = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel espbL=new JLabel("ESPB: *");
		espbL.setPreferredSize(dim);
		espbTF=new JTextField();
		espbTF.setPreferredSize(new Dimension(200,25));
		//espbTF.setName("txtRequired");
		//espbTF.addFocusListener(focus);
		espbTF.setToolTipText("Unesite broj espb");
		
		espb.add(espbL);
		espb.add(espbTF);
		
		espbTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				//pozovi fju provera svih empti ili ne polja
				check();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				check();
			}
			
		});
		
		JPanel sem = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel semL=new JLabel("Semestar: *");
		semL.setPreferredSize(dim);
		String[] semS= {"WINTER", "SUMMER"};
		JComboBox<Object> semCB=new JComboBox<Object>(semS);
		semCB.setPreferredSize(new Dimension(200,25));
		semCB.setMaximumSize(semCB.getPreferredSize());
		
		sem.add(semL);
		sem.add(semCB);
		

		
		JPanel conf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		doo = new JButton("Potvrdi");
		JButton dont = new JButton("Odustani");
		
		
		conf.add(dont);
		conf.add(doo);
		doo.setEnabled(false);
		
		
		doo.addActionListener(new ActionListener() {
			String numbersReg="[0-9]+";
			String nameReg = "[A-Ža-ž ]+";
			//String nameSurnameReg="([A-Ž][a-ž]+[' ']?)+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
//				boolean exists = false;
//				for(Subject s : SubjectsDatabase.getInstance().getSubjects()) {
//					if(s.getSubjectID()==Integer.parseInt(idTF.getText().trim())) {
//						exists = true;
//					}
//				}
				if(!idTF.getText().trim().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Id nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!nameTF.getText().trim().matches(nameReg)){
					JOptionPane.showMessageDialog(null, "Ime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!yearTF.getText().trim().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Godina nije pravilno uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!espbTF.getText().trim().matches(numbersReg)) {
					JOptionPane.showMessageDialog(null, "Polje ESPB nije pravilno uneto! ","",JOptionPane.ERROR_MESSAGE);
				}//else if (exists){
//					JOptionPane.showMessageDialog(null, "Vec postoji predmet sa unetim ID-jem!","",JOptionPane.ERROR_MESSAGE);
//				}
				else {
				int index = TabbedPane.getInstance().getTableSubjects().convertRowIndexToModel(TabbedPane.getInstance().getTableSubjects().getSelectedRow());
				SubjectsController.getInstance().editSubject(TabbedPane.getInstance().getTableSubjects().convertRowIndexToModel(TabbedPane.getInstance().getTableSubjects().getSelectedRow()),Integer.parseInt(idTF.getText()),nameTF.getText(),semCB.getSelectedIndex(),Integer.parseInt(yearTF.getText()),Integer.parseInt(espbTF.getText()));

				String [] trimmed = null;
				String selected = nameP;
				if(selected!=null) {
				trimmed = selected.split("\\ ");
				String trimmedName = trimmed[0];
				String trimmedSurname = trimmed[1];
				for(Professor p : ProfessorsDatabase.getInstance().getProfessors()) {
					if(p.getName().equals(trimmedName) && p.getSurname().equals(trimmedSurname)) {
						SubjectsController.getInstance().addProfOnSubj(index, p);
					}
				}
				}else {	
					Subject s = SubjectsController.getInstance().getSubject(index);
					SubjectsController.getInstance().removeProfessor(s);
					}
				dispose(); 						
				}
			}	
		});
		
		dont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		
		Subject subject = new Subject(SubjectsController.getInstance().getSubject(TabbedPane.getInstance().getTableSubjects().convertRowIndexToModel(TabbedPane.getInstance().getTableSubjects().getSelectedRow())));
		idTF.setText(String.valueOf(subject.getSubjectID()));
		nameTF.setText(subject.getSubjectName());
		yearTF.setText(String.valueOf(subject.getSubjectYear()));
		espbTF.setText(String.valueOf(subject.getEspb()));
		if(subject.getProfessor()!=null) {
		profTF.setText(subject.getProfessor().getName()+" "+subject.getProfessor().getSurname());
		}
		
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RemoveProfOfSubjDialog rP = new RemoveProfOfSubjDialog();
				rP.setVisible(true);
				if(rP.yes()==true) {
					profTF.setText("");
				}
				minus.setEnabled(false);
				plus.setEnabled(true);

			}
		});
		
		plus.setEnabled(true);
		minus.setEnabled(true);
		if(subject.getProfessor()==null) {
			minus.setEnabled(false);
		}else {
			plus.setEnabled(false);
		}
		if(subject.getSemestar() == "WINTER") {
		semCB.setSelectedIndex(0);
		} else 	semCB.setSelectedIndex(1);
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(id);
		pattern.add(name);
		pattern.add(year);
		pattern.add(espb);
		pattern.add(sem);
		pattern.add(prof);
		pattern.add(conf);
		pattern.add(Box.createGlue());
		
		
		this.add(pattern,BorderLayout.CENTER);
	}
	
	public void check() {
		if(!nameTF.getText().trim().isEmpty() && !idTF.getText().trim().isEmpty() && !yearTF.getText().trim().isEmpty()
				&& !espbTF.getText().trim().isEmpty()) {
			doo.setEnabled(true);
		} else doo.setEnabled(false);
	}
}
