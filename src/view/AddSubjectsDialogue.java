package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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

import controller.SubjectsController;

public class AddSubjectsDialogue extends JDialog{

	public static JTextField idTF;
	public static JTextField nameTF;
	public static JTextField yearTF;
	//public static JTextField profTF;
	public static JTextField espbTF;
	public static JTextField semesTF;
//	public static JTextField passedTF;
//	public static JTextField notPassedTF;
	
	
	public JButton doo;
	
	public AddSubjectsDialogue() {
		

		setModal(true);
		setSize(450,500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje predmeta");
		Image img = kit.getImage("icons/pluss.png");	
		setIconImage(img);
		
		Dimension dim = new Dimension(120,20);
		
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
//		
//		JPanel prof = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
//		JLabel profL=new JLabel("Profesor: *");
//		profL.setPreferredSize(dim);
//		profTF=new JTextField();
//		profTF.setPreferredSize(new Dimension(200,25));
//		//profTF.setName("txtRequired");
//		//profTF.addFocusListener(focus);
//		profTF.setToolTipText("Unesite profesora");
//		
//		prof.add(profL);
//		prof.add(profTF);
		
		
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
			String nameSurnameReg="([A-Ž][a-ž]+[' ']?)+";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!idTF.getText().trim().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Id nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!nameTF.getText().trim().matches(nameSurnameReg)){
					JOptionPane.showMessageDialog(null, "Ime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!yearTF.getText().trim().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Godina nije pravilno uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!espbTF.getText().trim().matches(numbersReg)) {
					JOptionPane.showMessageDialog(null, "Polje ESPB nije pravilno uneto! ","",JOptionPane.ERROR_MESSAGE);
				}else {
				
				
				SubjectsController.getInstance().addSubject(Integer.parseInt(idTF.getText()),nameTF.getText(),semCB.getSelectedIndex(),Integer.parseInt(yearTF.getText()),Integer.parseInt(espbTF.getText()));
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
		
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(id);
		pattern.add(name);
		pattern.add(year);
		pattern.add(espb);
		pattern.add(sem);
		
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
