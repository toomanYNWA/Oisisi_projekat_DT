package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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

import controller.StudentsController;
import model.Address;
import model.Student;
import model.StudentDatabase;

public class StudentDialogue extends JDialog{
	
	public static JTextField nameTF;
	public static JTextField surnameTF;
	public static JTextField dateOfBirthTF;
	public static JTextField addressTF;
	public static JTextField streetTF;
	public static JTextField numTF;
	public static JTextField cityTF;
	public static JTextField countryTF;
	public static JTextField phoneTF;
	public static JTextField emailTF;
	public static JTextField indexNTF;
	public static JTextField yearOfEnrollmentTF;
	public static JTextField currentYearTF;
	public static JTextField statusTF;

	
	public JButton doo;
	
	
	public StudentDialogue() {
		
		setModal(true);
		setSize(450,500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje studenta");
		Image img = kit.getImage("icons/pluss.png");	
		setIconImage(img);
		
		//FocusListenerStudent focus=new FocusListenerStudent();
		Dimension dim = new Dimension(120,20);
		
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
		
		JPanel surname = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel surnameL=new JLabel("Prezime: *");
		surnameL.setPreferredSize(dim);
		surnameTF=new JTextField();
		surnameTF.setPreferredSize(new Dimension(200,25));
		//surnameTF.setName("txtRequired");
		//surnameTF.addFocusListener(focus);
		surnameTF.setToolTipText("Unesite prezime");
		
		surname.add(surnameL);
		surname.add(surnameTF);
		
		surnameTF.getDocument().addDocumentListener(new DocumentListener() {

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
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel dateL=new JLabel("Datum rodjenja: *");
		dateL.setPreferredSize(dim);
		dateOfBirthTF=new JTextField();
		dateOfBirthTF.setPreferredSize(new Dimension(200,25));
		//dateOfBirthTF.setName("txtRequired");
		//dateOfBirthTF.addFocusListener(focus);
		dateOfBirthTF.setToolTipText("uneti u formatu dd.MM.yyyy. (npr. 17.08.2000.)");
		
		
		date.add(dateL);
		date.add(dateOfBirthTF);
		
		dateOfBirthTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel addressL=new JLabel("Adr. stanovanja: *");
		addressL.setPreferredSize(dim);
		streetTF=new JTextField();
		streetTF.setPreferredSize(new Dimension(40,25));
		//streetTF.setName("txtRequired");
		//streetTF.addFocusListener(focus);
		streetTF.setToolTipText("Ulica npr. Ljermontova ");
		numTF = new JTextField();
		numTF.setPreferredSize(new Dimension(25,25));
		//numTF.setName("txtRequired");
		//numTF.addFocusListener(focus);
		numTF.setToolTipText("Broj");
		cityTF = new JTextField();
		cityTF.setPreferredSize(new Dimension(45,25));
		//cityTF.setName("txtRequired");
		//cityTF.addFocusListener(focus);
		cityTF.setToolTipText("Grad");
		countryTF = new JTextField();
		countryTF.setPreferredSize(new Dimension(45,25));
		//countryTF.setName("txtRequired");
		//countryTF.addFocusListener(focus);
		countryTF.setToolTipText("Drzava");
		
		
		address.add(addressL);
		address.add(streetTF);
		address.add(numTF);
		address.add(cityTF);
		address.add(countryTF);
		
		streetTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		countryTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		numTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		cityTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JPanel phone = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel phoneL=new JLabel("Broj telefona: *");
		phoneL.setPreferredSize(dim);
		phoneTF=new JTextField();
		phoneTF.setPreferredSize(new Dimension(200,25));
		//phoneTF.setName("txtRequired");
		//phoneTF.addFocusListener(focus);
		phoneTF.setToolTipText("npr. 066/224-342 ");
		
		phone.add(phoneL);
		phone.add(phoneTF);
		
		phoneTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		
		JPanel eaddress = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel eaddressL= new JLabel("E-mail adresa je: * ");
		eaddressL.setPreferredSize(dim);
		emailTF = new JTextField();
		emailTF.setPreferredSize(new Dimension(200,25));
		//emailTF.setName("txtRequired");
		//emailTF.addFocusListener(focus);
		emailTF.setToolTipText("npr. jojobizz@gmail.com ");

		eaddress.add(eaddressL);
		eaddress.add(emailTF);

		emailTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JPanel index = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel indexL=new JLabel("Broj indeksa je: *");
		indexL.setPreferredSize(dim);
		indexNTF = new JTextField();
		indexNTF.setPreferredSize(new Dimension(200,25));
		//indexNTF.setName("txtRequired");
		//indexNTF.addFocusListener(focus);
		indexNTF.setToolTipText("npr. ra170/2019 ");
		
		
		index.add(indexL);
		index.add(indexNTF);
		
		indexNTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JPanel yoe = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel yoeL=new JLabel("Godina upisa je: *");
		yoeL.setPreferredSize(dim);
		yearOfEnrollmentTF=new JTextField();
		yearOfEnrollmentTF.setPreferredSize(new Dimension(200,25));
		//yearOfEnrollmentTF.setName("txtRequired");
		//yearOfEnrollmentTF.addFocusListener(focus);
		yearOfEnrollmentTF.setToolTipText("npr. 2010 ");
		
		yoe.add(yoeL);
		yoe.add(yearOfEnrollmentTF);
		
		yearOfEnrollmentTF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
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
		
		JPanel cy= new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel cyL=new JLabel("Trenutna godina studija: *");
		cyL.setPreferredSize(dim);
		String[] cyS= {"I", "II","III", "IV","V"};
		JComboBox<Object> cyCB=new JComboBox<Object>(cyS);
		cyCB.setPreferredSize(new Dimension(200,25));
		cyCB.setMaximumSize(cyCB.getPreferredSize());
		
		cy.add(cyL);
		cy.add(cyCB);
		
		JPanel status= new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel statusL=new JLabel("Nacin finansiranja: *");
		statusL.setPreferredSize(dim);
		String[] statusS= {"B", "S"};
		JComboBox<Object> statusCB=new JComboBox<Object>(statusS);
		statusCB.setPreferredSize(new Dimension(200,25));
		statusCB.setMaximumSize(statusCB.getPreferredSize());
		
		status.add(statusL);
		status.add(statusCB);
		//Integer.parseTo(currentYearTF)
		JPanel conf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		doo = new JButton("Potvrdi");
		JButton dont = new JButton("Odustani");
		
		
		conf.add(dont);
		conf.add(doo);
		doo.setEnabled(false);

		doo.addActionListener(new ActionListener() {
			String nameSurnameReg="([A-�][a-�]+[' ']?)+";
			String addressNumReg = "[0-9a-z]+";
			String regNum = "[0-9]+";
			String addressReg="[a-�A-� ]+"; 
			String emailReg="[a-zA-Z0-9._]+@[a-zA-Z]+[.][a-zA-Z]+[.]?[a-zA-Z]*";
			String numbersReg="[0-9]+[/]?[0-9]+[-]?[0-9]+";
			String indReg = "[a-�A-�]+[0-9]+[/][0-9]+";
			String dateReg = "[0-9]{2}[.][0-9]{2}[.][0-9]{4}[.]";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				boolean exists = false;
				for(Student s : StudentDatabase.getInstance().getStudents()) {
					if(s.getNuIndex().equals(indexNTF.getText().trim())) {
					 
					exists = true;
					}
				}
				 if(!nameTF.getText().trim().matches(nameSurnameReg)){
					JOptionPane.showMessageDialog(null, "Ime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!surnameTF.getText().trim().matches(nameSurnameReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!yearOfEnrollmentTF.getText().trim().matches(regNum)){
					JOptionPane.showMessageDialog(null, "Godina upisa nije dobro uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!streetTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Ulica nije pravilno uneta! ","",JOptionPane.ERROR_MESSAGE);
				}else if(!numTF.getText().trim().matches(addressNumReg)) {
					JOptionPane.showMessageDialog(null, "Broj nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!cityTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Grad nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!countryTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Drzava nije pravilno uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!phoneTF.getText().matches(numbersReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailTF.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!indexNTF.getText().matches(indReg)){
					JOptionPane.showMessageDialog(null, "Broj indeksa nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!dateOfBirthTF.getText().matches(dateReg)) {
					JOptionPane.showMessageDialog(null, "Datum nije pravilno unet (dd.MM.yy)","",JOptionPane.ERROR_MESSAGE);
				}else if (exists){
						JOptionPane.showMessageDialog(null, "Vec postoji student sa unetim brojem indeksa!","",JOptionPane.ERROR_MESSAGE);
					}else {
				String [] date = dateOfBirthTF.getText().split("\\.");
				LocalDate dateOB = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				Address adr = new Address(streetTF.getText(), numTF.getText(), cityTF.getText(), countryTF.getText());
				
				StudentsController.getInstance().addStudent(indexNTF.getText(),cyCB.getSelectedIndex(),statusCB.getSelectedIndex(),nameTF.getText(),surnameTF.getText(), dateOB, adr,emailTF.getText(),Integer.parseInt(yearOfEnrollmentTF.getText()),phoneTF.getText());
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
		pattern.add(name);
		pattern.add(surname);
		pattern.add(date);
		pattern.add(phone);
		pattern.add(address);
		pattern.add(eaddress);
		pattern.add(index);
		pattern.add(yoe);
		pattern.add(status);
		pattern.add(cy);
		pattern.add(conf);
		pattern.add(Box.createGlue());
		
		
		this.add(pattern,BorderLayout.CENTER);
		
		
		
		 
	
	}	
	public void check() {
		if(!nameTF.getText().trim().isEmpty() && !surnameTF.getText().trim().isEmpty() && !dateOfBirthTF.getText().trim().isEmpty()
				&& !streetTF.getText().trim().isEmpty()&& !cityTF.getText().trim().isEmpty() && !countryTF.getText().trim().isEmpty() && !numTF.getText().trim().isEmpty() && !phoneTF.getText().trim().isEmpty() && !emailTF.getText().trim().isEmpty() && !indexNTF.getText().trim().isEmpty()
				&& !yearOfEnrollmentTF.getText().trim().isEmpty()) {
			doo.setEnabled(true);
		} else doo.setEnabled(false);
	}
}

