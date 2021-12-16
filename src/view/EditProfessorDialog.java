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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.FocusListenerProfessors;
import model.Professor;
import model.ProfessorsDatabase;

public class EditProfessorDialog extends JDialog{
	public static JTextField nameTF;
	public static JTextField surnameTF;
	public static JTextField dateOfBirthTF;
	public static JTextField phoneTF;
	public static JTextField addressTF;
	public static JTextField officeAddressTF;
	public static JTextField idTF;
	public static JTextField emailTF;
	public static JTextField yearsOfTrailTF;
	
	public EditProfessorDialog() {
		
		setModal(true);
		setSize(450,500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Izmena profesora");
		Image img = kit.getImage("icons/edit.png");
		setIconImage(img);
		
		FocusListenerProfessors focus=new FocusListenerProfessors();
		Dimension dim = new Dimension(120, 20);
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel nameL=new JLabel("Ime: *");
		nameL.setPreferredSize(dim);
		nameTF=new JTextField();
		nameTF.setPreferredSize(new Dimension(200,25));
		nameTF.setName("txtRequired");
		nameTF.addFocusListener(focus);
		nameTF.setToolTipText("unesite ime");
		
		name.add(nameL);
		name.add(nameTF);
		
		
		JPanel surname = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel surnameL=new JLabel("Prezime: *");
		surnameL.setPreferredSize(dim);
		surnameTF=new JTextField();
		surnameTF.setPreferredSize(new Dimension(200,25));
		surnameTF.setName("txtRequired");
		surnameTF.addFocusListener(focus);
		surnameTF.setToolTipText("unesite prezime");
		
		surname.add(surnameL);
		surname.add(surnameTF);
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,0));
		JLabel dateL=new JLabel("Datum rodjenja: *");
		dateL.setPreferredSize(dim);
		dateOfBirthTF=new JTextField();
		dateOfBirthTF.setPreferredSize(new Dimension(200,25));
		dateOfBirthTF.setName("txtRequired");
		dateOfBirthTF.addFocusListener(focus);
		dateOfBirthTF.setToolTipText("uneti u formatu dd.MM.yyyy (npr. 17.08.2000)");
		
		
		date.add(dateL);
		date.add(dateOfBirthTF);
		
		JPanel phone = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel phoneL=new JLabel("Broj telefona: *");
		phoneL.setPreferredSize(dim);
		phoneTF=new JTextField();
		phoneTF.setPreferredSize(new Dimension(200,25));
		phoneTF.setName("txtRequired");
		phoneTF.addFocusListener(focus);
		phoneTF.setToolTipText("npr. 021/1234-567");
		
		phone.add(phoneL);
		phone.add(phoneTF);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel emailL=new JLabel("Email:*");
		emailL.setPreferredSize(dim);
		emailTF=new JTextField();
		emailTF.setPreferredSize(new Dimension(200,25));
		emailTF.setName("txtRequired");
		emailTF.addFocusListener(focus);
		emailTF.setToolTipText("npr. ime.prezime@uns.ac.rs");
		
		email.add(emailL);
		email.add(emailTF);
		
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel addressL= new JLabel("Adresa stanovanja:* ");
		addressL.setPreferredSize(dim);
		addressTF = new JTextField();
		addressTF.setPreferredSize(new Dimension(200,25));
		addressTF.setName("txtRequired");
		addressTF.addFocusListener(focus);
		addressTF.setToolTipText("npr. Dositejeva 16, Novi Sad");

		address.add(addressL);
		address.add(addressTF);

		
		
		JPanel office = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel officeL=new JLabel("Adresa kancelarije: *");
		officeL.setPreferredSize(dim);
		officeAddressTF=new JTextField();
		officeAddressTF.setPreferredSize(new Dimension(200,25));
		officeAddressTF.setName("txtRequired");
		officeAddressTF.addFocusListener(focus);
		officeAddressTF.setToolTipText("npr. Dositeja Obradoviæa 6, Novi Sad, NTP 5");

		
		office.add(officeL);
		office.add(officeAddressTF);
		
		JPanel id = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 , 0));
		JLabel idL=new JLabel("Broj liène karte:*");
		idL.setPreferredSize(dim);
		idTF=new JTextField();
		idTF.setPreferredSize(new Dimension(200,25));
		idTF.setName("txtRequired");
		idTF.addFocusListener(focus);
		idTF.setToolTipText("npr. 123456789");
		
		id.add(idL);
		id.add(idTF);
		
		JPanel yearsOT = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel yOTL=new JLabel("Godine staža:* ");
		yOTL.setPreferredSize(dim);
		yearsOfTrailTF=new JTextField();
		yearsOfTrailTF.setPreferredSize(new Dimension(200,25));
		yearsOfTrailTF.setName("txtRequired");
		yearsOfTrailTF.addFocusListener(focus);
		yearsOfTrailTF.setToolTipText("npr. 15");
		
		yearsOT.add(yOTL);
		yearsOT.add(yearsOfTrailTF);
		
		JPanel title = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel titleL=new JLabel("Zvanje:*");
		titleL.setPreferredSize(dim);
		String[] titleS= {"Asistent", "Docent", "Profesor"};
		JComboBox<Object> titleCB=new JComboBox<Object>(titleS);
		titleCB.setPreferredSize(new Dimension(200,25));
		titleCB.setMaximumSize(titleCB.getPreferredSize());
		title.add(titleL);
		title.add(titleCB);
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton odustani = new JButton("Odustani");
		JButton potvrdi = new JButton("Potvrdi");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		/*Professor prof=new Professor(ProfessorsDatabase.getInstance().getRow(ProfessorsJTable.getInstance().getSelectedRow()));
		nameTF.setText(prof.getName());
		surnameTF.setText(prof.getSurname());
		dateOfBirthTF.setText(prof.getDateofbirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		adresaTF.setText(prof.getAdresaStanovanja());
		telefonTF.setText(prof.getKontaktTel());
		emailTF.setText(prof.getEmail());
		kancelarijaTF.setText(prof.getAdresa_kancelarije());
		blkTF.setText(prof.getBLK());
		titula=prof.getTitula();
		zvanje=prof.getZvanje(); */
		
		odustanakPotvrda.add(potvrdi);
		odustanakPotvrda.add(odustani);
		
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(name);
		pattern.add(surname);
		pattern.add(date);
		pattern.add(phone);
		pattern.add(address);
		pattern.add(office);
		pattern.add(id);
		pattern.add(email);
		pattern.add(yearsOT);
		pattern.add(title);
		pattern.add(odustanakPotvrda);
		pattern.add(Box.createGlue());
		
		JTabbedPane tabs= new JTabbedPane();
		JPanel subjs= new JPanel();
		tabs.add("Info", pattern);
		tabs.add("Predmeti", subjs);
		this.add(tabs);
		//this.add(pattern,BorderLayout.CENTER);
	}
}
