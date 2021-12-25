package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FocusListenerStudent;
import controller.ProfessorsController;
import controller.StudentsController;
import model.Address;
import model.Professor.Title;
import model.Student.Status;

public class StudentDialogue extends JDialog{
	
	public static JTextField nameTF;
	public static JTextField surnameTF;
	public static JTextField dateOfBirthTF;
	public static JTextField addressTF;
	public static JTextField phoneTF;
	public static JTextField emailTF;
	public static JTextField indexNTF;
	public static JTextField yearOfEnrollmentTF;
	public static JTextField currentYearTF;
	public static JTextField statusTF;

	
	
	
	
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
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel dateL=new JLabel("Datum rodjenja: *");
		dateL.setPreferredSize(dim);
		dateOfBirthTF=new JTextField();
		dateOfBirthTF.setPreferredSize(new Dimension(200,25));
		//dateOfBirthTF.setName("txtRequired");
		//dateOfBirthTF.addFocusListener(focus);
		dateOfBirthTF.setToolTipText("uneti u formatu dd.MM.yyyy (npr. 17.08.2000)");
		
		
		date.add(dateL);
		date.add(dateOfBirthTF);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel addressL=new JLabel("Adresa stanovanja: *");
		addressL.setPreferredSize(dim);
		addressTF=new JTextField();
		addressTF.setPreferredSize(new Dimension(200,25));
		//addressTF.setName("txtRequired");
		//addressTF.addFocusListener(focus);
		addressTF.setToolTipText("npr. Pere Antica , 33, Beograd , Srbija ");
		
		address.add(addressL);
		address.add(addressTF);
		
		JPanel phone = new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel phoneL=new JLabel("Broj telefona: *");
		phoneL.setPreferredSize(dim);
		phoneTF=new JTextField();
		phoneTF.setPreferredSize(new Dimension(200,25));
		//phoneTF.setName("txtRequired");
		//phoneTF.addFocusListener(focus);
		phoneTF.setToolTipText("npr. 066/224/342 ");
		
		phone.add(phoneL);
		phone.add(phoneTF);
		
		
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
		
		JPanel cy= new JPanel(new FlowLayout(FlowLayout.LEFT,30,0));
		JLabel cyL=new JLabel("Trenutna godina studija: *");
		cyL.setPreferredSize(dim);
		String[] cyS= {"I", "II","III", "IV","Master"};
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
		JButton dont = new JButton("Odustani");
		JButton doo = new JButton("Potvrdi");
		
		conf.add(dont);
		conf.add(doo);
	

		doo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nameTF.getText().trim().isEmpty() ||surnameTF.getText().trim().isEmpty() ||dateOfBirthTF.getText().trim().isEmpty()
						||addressTF.getText().trim().isEmpty()||phoneTF.getText().trim().isEmpty()||emailTF.getText().trim().isEmpty()||indexNTF.getText().trim().isEmpty()
						||yearOfEnrollmentTF.getText().trim().isEmpty()) {
				
				System.out.println("Nisu sva polja popunjena");
			}else {
				String [] date = dateOfBirthTF.getText().split("\\.");
				LocalDate dateOB = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				String [] address = addressTF.getText().split("\\,");
				Address adr = new Address(address[0], address[1], address[2], address[3]);
				
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
}

