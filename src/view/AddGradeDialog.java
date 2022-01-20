package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

import controller.ProfessorsController;
import controller.SubjectsController;
import model.NotPassedSubjectsDatabase;
import model.Subject;
import model.SubjectsDatabase;
import model.Professor.Title;

public class AddGradeDialog extends JDialog{
	public static JTextField idTF;
	public static JTextField nameTF;
	public static JTextField dateTF;
	public static String gradeP;
	public JButton yes;
	
	public AddGradeDialog() {
		setModal(true);
		setSize(300,300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Unos ocene");
		Image img = kit.getImage("icons/new.png");
		setIconImage(img);
		
		Dimension dim = new Dimension(120, 20);
		
		JPanel id = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel idL=new JLabel("Sifra: *");
		idL.setPreferredSize(dim);
		idTF=new JTextField();
		idTF.setPreferredSize(new Dimension(200,25));
		idTF.setToolTipText("Sifra predmeta");
		idTF.setEditable(false);
		
		id.add(idL);
		id.add(idTF);
		
		JPanel name = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel nameL=new JLabel("Naziv: *");
		nameL.setPreferredSize(dim);
		nameTF=new JTextField();
		nameTF.setPreferredSize(new Dimension(200,25));
		nameTF.setToolTipText("Naziv predmeta");
		nameTF.setEditable(false);
		
		name.add(nameL);
		name.add(nameTF);
		
		JPanel grade = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel gradeL=new JLabel("Ocena:*");
		gradeL.setPreferredSize(dim);
		String[] gradeS= {"6", "7", "8", "9", "10"};
		JComboBox<Object> gradeCB=new JComboBox<Object>(gradeS);
		gradeCB.setPreferredSize(new Dimension(200,25));
		gradeCB.setMaximumSize(gradeCB.getPreferredSize());
		grade.add(gradeL);
		grade.add(gradeCB);
		
		JPanel date = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
		JLabel dateL=new JLabel("Datum: *");
		dateL.setPreferredSize(dim);
		dateTF=new JTextField();
		dateTF.setPreferredSize(new Dimension(200,25));
		dateTF.setToolTipText("Datum polaganja ispita");
		
		dateTF.getDocument().addDocumentListener(new DocumentListener() {

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
		
		date.add(dateL);
		date.add(dateTF);
		
		JPanel yesNo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton no = new JButton("Odustani");
		yes = new JButton("Potvrdi");
		yes.setEnabled(false);
		
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!validateJavaDate(dateTF.getText())) {
					JOptionPane.showMessageDialog(null, "Datum nije pravilno unet (dd.MM.yy)","",JOptionPane.ERROR_MESSAGE);
				} else {
					String [] date = dateTF.getText().split("\\.");
					LocalDate examDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
					gradeP=(String)gradeCB.getSelectedItem();
					int grade;

					if(gradeP.equals("10"))
						grade = 10;
					else if (gradeP.equals("9"))
						grade = 9;
					else if (gradeP.equals("8"))
						grade = 8;
					else if (gradeP.equals("7"))
						grade = 7;
					else 
						grade = 6;
					int SubjId = (int) NotPassedSubjectsDatabase.getInstance().getValueAt(NotPassedSubjectsTable.rowSelectedIndex, 0);
					//int SubjId = (int) SubjectsDatabase.getInstance().getValueAtNotPassed(NotPassedSubjectsTable.rowSelectedIndex, 0);
					SubjectsController.getInstance().passExam(SubjId, grade, examDate);
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
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}
		});
		yesNo.add(yes);
		yesNo.add(no);
		
		Subject subj = new Subject(SubjectsController.getInstance().getSubject(NotPassedSubjectsTable.rowSelectedIndex));
		idTF.setText(String.valueOf(subj.getSubjectID()));
		nameTF.setText(subj.getSubjectName());
		
		Box pattern = Box.createVerticalBox();
		pattern.add(Box.createVerticalStrut(10));
		pattern.add(id);
		pattern.add(name);
		pattern.add(grade);
		pattern.add(date);
		pattern.add(yesNo);
		pattern.add(Box.createGlue());
		
		
		this.add(pattern,BorderLayout.CENTER);
	}
	public void check() {
		if(!(nameTF.getText().equals("") || dateTF.getText().equals("") || idTF.getText().equals(""))) {
			yes.setEnabled(true);
		} else yes.setEnabled(false);
	}
}
