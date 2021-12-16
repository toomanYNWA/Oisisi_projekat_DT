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
import model.User.Gender;

public class ProfessorsDatabase {
	private static ProfessorsDatabase instance = null;

	public static ProfessorsDatabase getInstance() {
		if (instance == null) {
			instance = new ProfessorsDatabase();
		}
		return instance;
	}

	private ArrayList<Professor> professors;
	//private ArrayList<Profesor> sviProfesori;
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
		//this.sviProfesori = new ArrayList<Profesor>();

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
				address=column[6].split("\\,");
				officeAddress=column[7].split("\\,");

				String[] subjectIds=column[11].split("\\#");
				ArrayList<Subject> subjects=new ArrayList<Subject>();
				Subject subj;
				/*for(String subjsId:subjectIds) {
					subj=SubjectsDatabase.getInstance().getSubjById(subjsId);
					System.out.println(subj.getEspb());
					if(subj==null) {
						System.out.println(subj.getEspb());
						//Ispisati nekako da je pogr predmet
						continue;
					}
					//subjects.add(subj);
				}  */
				
				LocalDate ld = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				
				Gender g;
				if(column[3].trim().equals("MALE"))
					g=Gender.MALE;
				else
					g=Gender.FEMALE;
				
				
				Address a = new Address(address[0], address[1], address[2], address[3]); // ulica, broj, grad, drzava
				Address aO = new Address(officeAddress[0], officeAddress[1], officeAddress[2], officeAddress[3]);
				
				Title t;

				if(column[10].trim().equals("ASISTANT PROFESSOR"))
					t = Title.ASISTANT_PROFESSOR;
				else if (column[10].equals("ASSOCIATE PROFESSOR"))
					t = Title.ASSOCIATE_PROFESSOR;
				else
					t = Title.PROFESSOR;
				
				int yOt= Integer.parseInt(column[9].trim());
				
				
				Professor prof=new Professor(column[0].trim(),column[1].trim(),ld, g, column[4].trim(), column[5].trim(), a, aO, column[8].trim(), yOt, t);
				// ime, prz, datumrodj, pol, telefon, mejl, adresa, adrsa kanc, id, staz, titula, predmeti
				//prof.setSubjects(subjects); PROVALI STO NE RADI(subj mi je null zato)
				professors.add(prof);
				//sviProfesori.add(profa);
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
			return profesori.getSurname();
		case 1:
			return profesori.getName();
		case 2:
			return profesori.getEmail();
		case 3:
			return profesori.getTitle();
		default:
			return null;
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
