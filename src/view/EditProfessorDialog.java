package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ProfessorsController;
import model.Address;
import model.Professor;
import model.Professor.Title;

public class EditProfessorDialog extends JDialog{
	public static JTextField nameTF;
	public static JTextField surnameTF;
	public static JTextField dateOfBirthTF;
	public static JTextField phoneTF;
	public static JTextField streetTF;
	public static JTextField numberTF;
	public static JTextField cityTF;
	public static JTextField stateTF;
	public static JTextField streetOTF;
	public static JTextField numberOTF;
	public static JTextField cityOTF;
	public static JTextField stateOTF;
	public static JTextField idTF;
	public static JTextField emailTF;
	public static JTextField yearsOfTrailTF;
	public static String titleP;
	public JButton potvrdi;
	
	public EditProfessorDialog() {
		
		try {
		setModal(true);
		setSize(500,500);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Izmena profesora");
		Image img = kit.getImage("icons/edit.png");
		setIconImage(img);
		
		Dimension dim = new Dimension(120, 20);
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel nameL=new JLabel("Ime: *");
		nameL.setPreferredSize(dim);
		nameTF=new JTextField();
		nameTF.setPreferredSize(new Dimension(200,25));
		nameTF.setToolTipText("unesite ime");
		
		name.add(nameL);
		name.add(nameTF);
		
		
		JPanel surname = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel surnameL=new JLabel("Prezime: *");
		surnameL.setPreferredSize(dim);
		surnameTF=new JTextField();
		surnameTF.setPreferredSize(new Dimension(200,25));
		surnameTF.setToolTipText("unesite prezime");
		
		surname.add(surnameL);
		surname.add(surnameTF);
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT, 30,0));
		JLabel dateL=new JLabel("Datum rodjenja: *");
		dateL.setPreferredSize(dim);
		dateOfBirthTF=new JTextField();
		dateOfBirthTF.setPreferredSize(new Dimension(200,25));
		dateOfBirthTF.setToolTipText("uneti u formatu dd.MM.yyyy (npr. 17.08.2000)");
		
		
		date.add(dateL);
		date.add(dateOfBirthTF);
		
		
		JPanel phone = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel phoneL=new JLabel("Broj telefona: *");
		phoneL.setPreferredSize(dim);
		phoneTF=new JTextField();
		phoneTF.setPreferredSize(new Dimension(200,25));
		phoneTF.setToolTipText("npr. 0651234567");
		
		phone.add(phoneL);
		phone.add(phoneTF);
		
		JPanel email = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel emailL=new JLabel("Email:*");
		emailL.setPreferredSize(dim);
		emailTF=new JTextField();
		emailTF.setPreferredSize(new Dimension(200,25));
		emailTF.setToolTipText("npr. ime.prezime@uns.ac.rs");
		
		email.add(emailL);
		email.add(emailTF);
		
		
		JPanel address = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel addressL= new JLabel("Adresa stanovanja:* ");
		addressL.setPreferredSize(dim);
		streetTF = new JTextField();
		streetTF.setPreferredSize(new Dimension(70,25));
		streetTF.setToolTipText("Ulica");
		numberTF = new JTextField();
		numberTF.setPreferredSize(new Dimension(30,25));
		numberTF.setToolTipText("Broj");
		cityTF = new JTextField();
		cityTF.setPreferredSize(new Dimension(50,25));
		cityTF.setToolTipText("Grad");
		stateTF = new JTextField();
		stateTF.setPreferredSize(new Dimension(50,25));
		stateTF.setToolTipText("Drzava");
		
		address.add(addressL);
		address.add(streetTF);
		address.add(numberTF);
		address.add(cityTF);
		address.add(stateTF);

		
		
		JPanel office = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel officeL=new JLabel("Adresa kancelarije: *");
		officeL.setPreferredSize(dim);
		streetOTF = new JTextField();
		streetOTF.setPreferredSize(new Dimension(70,25));
		streetOTF.setToolTipText("Ulica");
		numberOTF = new JTextField();
		numberOTF.setPreferredSize(new Dimension(30,25));
		numberOTF.setToolTipText("Broj");
		cityOTF = new JTextField();
		cityOTF.setPreferredSize(new Dimension(50,25));
		cityOTF.setToolTipText("Grad");
		stateOTF = new JTextField();
		stateOTF.setPreferredSize(new Dimension(50,25));
		stateOTF.setToolTipText("Drzava");

		
		office.add(officeL);
		office.add(streetOTF);
		office.add(numberOTF);
		office.add(cityOTF);
		office.add(stateOTF);
		
		JPanel id = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 , 0));
		JLabel idL=new JLabel("Broj liène karte:*");
		idL.setPreferredSize(dim);
		idTF=new JTextField();
		idTF.setPreferredSize(new Dimension(200,25));
		idTF.setToolTipText("npr. 123456789");
		
		id.add(idL);
		id.add(idTF);
		
		JPanel yearsOT = new JPanel(new FlowLayout(FlowLayout.LEFT, 30 ,0));
		JLabel yOTL=new JLabel("Godine staža:* ");
		yOTL.setPreferredSize(dim);
		yearsOfTrailTF=new JTextField();
		yearsOfTrailTF.setPreferredSize(new Dimension(200,25));
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
		nameTF.getDocument().addDocumentListener(new DocumentListener() {

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
		surnameTF.getDocument().addDocumentListener(new DocumentListener() {

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
		numberTF.getDocument().addDocumentListener(new DocumentListener() {

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
		stateTF.getDocument().addDocumentListener(new DocumentListener() {

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
		streetOTF.getDocument().addDocumentListener(new DocumentListener() {

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
		numberOTF.getDocument().addDocumentListener(new DocumentListener() {

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
		cityOTF.getDocument().addDocumentListener(new DocumentListener() {

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
		stateOTF.getDocument().addDocumentListener(new DocumentListener() {

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
		idTF.getDocument().addDocumentListener(new DocumentListener() {

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
		yearsOfTrailTF.getDocument().addDocumentListener(new DocumentListener() {

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
		
		JPanel odustanakPotvrda = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton odustani = new JButton("Odustani");
		potvrdi = new JButton("Potvrdi");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		potvrdi.addActionListener(new ActionListener() {
			String nameSurnameReg="[A-Ž][a-ž]+";
			String addressNumReg = "[0-9a-z]+";
			String addressReg="[a-žA-Ž ]+"; 
			String emailReg="[a-zA-Z0-9._]+@[a-zA-Z]+[.][a-zA-Z]+[.]?[a-zA-Z]*";
			String numbersReg="[0-9]+";
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!nameTF.getText().trim().matches(nameSurnameReg)){
					JOptionPane.showMessageDialog(null, "Ime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!surnameTF.getText().trim().matches(nameSurnameReg)){
					JOptionPane.showMessageDialog(null, "Prezime nije pravilno uneto!","",JOptionPane.ERROR_MESSAGE);
				}else if(!yearsOfTrailTF.getText().trim().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Godine radnog staza nisu pravilno unete!","",JOptionPane.ERROR_MESSAGE);
				}else if(!streetTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Ulica nije pravilno uneta! ","",JOptionPane.ERROR_MESSAGE);
				}else if(!numberTF.getText().trim().matches(addressNumReg)) {
					JOptionPane.showMessageDialog(null, "Broj nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!cityTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Grad nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!stateTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Drzava nije pravilno uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!streetOTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Ulica kancelarije nije pravilno uneta! ","",JOptionPane.ERROR_MESSAGE);
				}else if(!numberOTF.getText().trim().matches(addressNumReg)) {
					JOptionPane.showMessageDialog(null, "Broj kancelarije nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!cityOTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Grad kancelarije nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!stateOTF.getText().trim().matches(addressReg)) {
					JOptionPane.showMessageDialog(null, "Drzava kancelarije nije pravilno uneta!","",JOptionPane.ERROR_MESSAGE);
				}else if(!phoneTF.getText().matches(numbersReg)) {
					JOptionPane.showMessageDialog(null, "Telefon nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!emailTF.getText().matches(emailReg)) {
					JOptionPane.showMessageDialog(null, "Email nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!idTF.getText().matches(numbersReg)){
					JOptionPane.showMessageDialog(null, "Broj licne karte nije pravilno unet!","",JOptionPane.ERROR_MESSAGE);
				}else if(!validateJavaDate(dateOfBirthTF.getText())) {
					JOptionPane.showMessageDialog(null, "Datum nije pravilno unet (dd.MM.yy)","",JOptionPane.ERROR_MESSAGE);
				}else {
				String [] date = dateOfBirthTF.getText().split("\\.");
				LocalDate dOB = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				
				Address a = new Address(streetTF.getText(), numberTF.getText(), cityTF.getText(), stateTF.getText());
				Address aO = new Address(streetOTF.getText(), numberOTF.getText(), cityOTF.getText(), stateOTF.getText());
				
				titleP=(String)titleCB.getSelectedItem();
				Title t;

				if(titleP.equals("Asistent"))
					t = Title.ASISTANT_PROFESSOR;
				else if (titleP.equals("Docent"))
					t = Title.ASSOCIATE_PROFESSOR;
				else
					t = Title.PROFESSOR;
				ProfessorsController.getInstance().editProfessor(TabbedPane.getInstance().getTableProfessors().getSelectedRow(), nameTF.getText(), surnameTF.getText(), dOB, phoneTF.getText(), emailTF.getText(), a, aO, idTF.getText(), Integer.parseInt(yearsOfTrailTF.getText()), t);
				dispose();
				}
			}
			public boolean validateJavaDate(String strDate)
			   {
				if (strDate.trim().equals(""))
				{
				    return true;
				}
				else
				{
				    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd.MM.yyyy");
				    sdfrmt.setLenient(false);
				    try
				    {
				        Date javaDate = sdfrmt.parse(strDate); 
				    }
				    catch (ParseException e)
				    {
				        return false;
				    }
				    return true;
				}
			   }

		}); 
		Professor prof = new Professor(ProfessorsController.getInstance().getProfessor(TabbedPane.getInstance().getTableProfessors().getSelectedRow()));
		nameTF.setText(prof.getName());
		surnameTF.setText(prof.getSurname());
		dateOfBirthTF.setText(prof.getDateofbirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
		Address a = prof.getAddress();
		streetTF.setText(a.getStreet());
		numberTF.setText(a.getNumber());
		cityTF.setText(a.getCity());
		stateTF.setText(a.getState());
		phoneTF.setText(prof.getPhone());
		emailTF.setText(prof.getEmail());
		Address aO = prof.getOfficeAdress();
		streetOTF.setText(aO.getStreet());
		numberOTF.setText(aO.getNumber());
		cityOTF.setText(aO.getCity());
		stateOTF.setText(aO.getState());
		idTF.setText(prof.getId());
		yearsOfTrailTF.setText(String.valueOf(prof.getYearsOfTrail()));
		int inx=prof.getTitle().ordinal();
		titleCB.setSelectedIndex(inx);
		
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
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nije selektovan profesor!","",JOptionPane.ERROR_MESSAGE);
		} 
	}
	public void check() {
		if(!(nameTF.getText().equals("") || surnameTF.getText().equals("") || dateOfBirthTF.getText().equals("") || streetTF.getText().equals("")|| numberTF.getText().equals("") || cityTF.getText().equals("")|| stateTF.getText().equals("")|| 
				phoneTF.getText().equals("") || emailTF.getText().equals("") || streetOTF.getText().equals("")|| numberOTF.getText().equals("") || cityOTF.getText().equals("")|| stateOTF.getText().equals("")  || idTF.getText().equals("")|| yearsOfTrailTF.getText().equals(""))) {
			potvrdi.setEnabled(true);
		} else potvrdi.setEnabled(false);
	}
}
