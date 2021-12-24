package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Professor.Title;

public class ProfessorsDatabase {
	private static ProfessorsDatabase instance = null;

	public static ProfessorsDatabase getInstance() {
		if (instance == null) {
			instance = new ProfessorsDatabase();
		}
		return instance;
	}

	private ArrayList<Professor> professors;
	private List<String> columns;

	private ProfessorsDatabase() {
		initProfessor();
		this.columns = new ArrayList<String>();
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Email");
		this.columns.add("Zvanje");
	}
	private void initProfessor() {
		
		this.professors = new ArrayList<Professor>();

		String next = null;
		String [] column = null;
		String [] date = null;
		String [] address=null;
		String [] officeAddress=null;
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("resources/Professors.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next = in.readLine()) != null) {
				if(next.equals("")) {
					continue;
				}
				
				column = next.split("\\|");
				date = column[2].split("\\.");
				address=column[5].split("\\,");
				officeAddress=column[6].split("\\,");

				/*String[] subjectIds=column[11].split("\\#");
				ArrayList<Subject> subjects=new ArrayList<Subject>();
				Subject subj;
				for(String subjsId:subjectIds) {
					subj=SubjectsDatabase.getInstance().getSubjById(subjsId);
					if(subj==null) {
						System.out.println("subj je null");
						//Ispisati nekako da je pogr predmet
						continue;
					}
					subjects.add(subj);
				}  */
				
				LocalDate ld = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				
				
				
				Address a = new Address(address[0], address[1], address[2], address[3]); // ulica, broj, grad, drzava
				Address aO = new Address(officeAddress[0], officeAddress[1], officeAddress[2], officeAddress[3]);
				
				Title t;

				if(column[9].trim().equals("ASISTANT PROFESSOR"))
					t = Title.ASISTANT_PROFESSOR;
				else if (column[10].equals("ASSOCIATE PROFESSOR"))
					t = Title.ASSOCIATE_PROFESSOR;
				else
					t = Title.PROFESSOR;
				
				int yOt= Integer.parseInt(column[8].trim());
				
				
				Professor prof=new Professor(column[0].trim(),column[1].trim(),ld, column[3].trim(), column[4].trim(), a, aO, column[7].trim(), yOt, t);
				// ime, prz, datumrodj, telefon, mejl, adresa, adrsa kanc, id, staz, titula, predmeti
				//prof.setSubjects(subjects); //PROVALI STO NE RADI(subj mi je null zato)
				professors.add(prof);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Professor> getProfessors() {
		return professors;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
	}
	public Object getValueAt(int row, int col) {
		Professor profesori=this.professors.get(row);
		switch(col) {
		case 0:
			return profesori.getName();
		case 1:
			return profesori.getSurname();
		case 2:
			return profesori.getEmail();
		case 3:
			return profesori.getTitle();
		default:
			return null;
		}
	
	}
	
	public void addProfessor(String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title) {
		this.professors.add(new Professor(name, surname, dateofbirth, phone, email, address, officeAdress, id, yearsOfTrail, title));
	}
	
	public void editProfessor(String id,String name, String surname, LocalDate dateofbirth, String phone, String email,
	Address address, Address officeAdress, String idNew, int yearsOfTrail, Title title) {
		for(Professor p: professors) {
			if (p.getId().equals(id)) {
				p.setName(name);
				p.setSurname(surname);
				p.setDateofbirth(dateofbirth);
				p.setPhone(phone);
				p.setEmail(email);
				p.setAddress(address);
				p.setOfficeAdress(officeAdress);
				p.setId(idNew);
				p.setYearsOfTrail(yearsOfTrail);
				p.setTitle(title);
			}
		}
	}
	public void deleteProfessor(String id) {
		for(Professor p: professors) {
			if(p.getId().equals(id)) {
				professors.remove(p);
				//mora da sadrzi i brisanje prof sa predmeta
				break;
			}
		}
	}
	
	public Professor getProfById(String id) {
		for (Professor p : professors) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
}
