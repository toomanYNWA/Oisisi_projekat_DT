package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.StudentDatabase;

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

	
	//public static String title;
	//getText()
	public StudentDialogue() {
		
		setModal(true);
		setSize(450,500);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Dodavanje studenta");
				
		
		//FocusProfesori fokus=new FocusProfesori();
		
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel nameL=new JLabel("Ime: *");
		nameTF=new JTextField();
		nameTF.setPreferredSize(new Dimension(200,25));
		//nameTF.addFocusListener(fokus);
		nameTF.setToolTipText("unesite ime");
		
		name.add(nameL);
		name.add(nameTF);
		
		
		JPanel surname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel surnameL=new JLabel("Prezime: *");
		surnameTF=new JTextField();
		surnameTF.setPreferredSize(new Dimension(200,25));
		//prezimeTF.addFocusListener(fokus);
		surnameTF.setToolTipText("unesite prezime");
		
		surname.add(surnameL);
		surname.add(surnameTF);
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel dateL=new JLabel("Datum rodjenja: *");
		dateOfBirthTF=new JTextField();
		dateOfBirthTF.setPreferredSize(new Dimension(200,25));
		//datumTF.addFocusListener(fokus);
		dateOfBirthTF.setToolTipText("uneti u formatu dd.MM.yyyy (npr. 17.08.2000)");
		
		
		date.add(dateL);
		date.add(dateOfBirthTF);
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel addressL=new JLabel("Adresa stanovanja: *");
		addressTF=new JTextField();
		addressTF.setPreferredSize(new Dimension(200,25));
		//phoneTF.addFocusListener(fokus);
		addressTF.setToolTipText("npr. Ljutice Bogdana 23");
		
		address.add(addressL);
		address.add(addressTF);
		
		JPanel phone = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel phoneL=new JLabel("Broj telefona: *");
		phoneTF=new JTextField();
		phoneTF.setPreferredSize(new Dimension(200,25));
		//emailTF.addFocusListener(fokus);
		phoneTF.setToolTipText("npr. 066/224/342 ");
		
		phone.add(phoneL);
		phone.add(phoneTF);
		
		
		JPanel eaddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel eaddressL= new JLabel("E-mail adresa je: * ");
		emailTF = new JTextField();
		emailTF.setPreferredSize(new Dimension(200,25));
		//addressTF.addFocusListener(fokus);
		addressTF.setToolTipText("npr. jojobizz@gmail.com ");

		eaddress.add(eaddressL);
		eaddress.add(emailTF);

		
		
		JPanel index = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel indexL=new JLabel("Broj indeksa je: *");
		indexNTF=new JTextField();
		indexNTF.setPreferredSize(new Dimension(200,25));
		//officeAddressTF.addFocusListener(fokus);
		indexNTF.setToolTipText("npr. ra170/2019 ");

		
		index.add(indexL);
		index.add(indexNTF);
		
		JPanel yoe = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel yoeL=new JLabel("Godina upisa je: *");
		yearOfEnrollmentTF=new JTextField();
		yearOfEnrollmentTF.setPreferredSize(new Dimension(200,25));
		//idTF.addFocusListener(fokus);
		yearOfEnrollmentTF.setToolTipText("npr. 2010 ");
		
		yoe.add(yoeL);
		yoe.add(yearOfEnrollmentTF);
		
		JPanel cy= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel cyL=new JLabel("Trenutna godina studija: *");
		String[] cyS= {"I", "II","III", "IV","Master"};
		JComboBox<Object> cyCB=new JComboBox<Object>(cyS);
		
		cy.add(cyL);
		cy.add(cyCB);
		
		JPanel status= new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel statusL=new JLabel("Nacin finansiranja: *");
		String[] statusS= {"Budzet", "Samofinansiranje"};
		JComboBox<Object> statusCB=new JComboBox<Object>(statusS);

		
		status.add(statusL);
		status.add(statusCB);
		//Integer.parseTo(currentYearTF)
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton dont = new JButton("Odustani");
		JButton doo = new JButton("Potvrdi");
		
		odustanakPotvrda.add(dont);
		odustanakPotvrda.add(doo);
		
		doo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDatabase.getInstance().addStudent(indexNTF.getText(),cyCB.getSelectedIndex(),statusCB.getSelectedIndex(),nameTF.getText(),surnameTF.getText(), 0);
				dispose();
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
		pattern.add(odustanakPotvrda);
		pattern.add(Box.createGlue());
		
		
		this.add(pattern,BorderLayout.CENTER);
		
		
	}
	
}