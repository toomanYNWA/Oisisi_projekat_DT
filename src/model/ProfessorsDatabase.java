package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
	private ArrayList<Professor> foundProf = new ArrayList<Professor>();
	private ArrayList<Professor> allProfs;

	private ProfessorsDatabase() {
		initProfessor();
		this.columns = new ArrayList<String>();
		this.columns.add("Ime");
		this.columns.add("Prezime");
		this.columns.add("Email");
		this.columns.add("Zvanje");
		allProfs = professors;
	}
	private void initProfessor() {
		
		this.professors = new ArrayList<Professor>();
		//this.allProfs = new ArrayList<Professor>();

		String next = null;
		String [] column = null;
		String [] date = null;
		String [] address=null;
		String [] officeAddress=null;
		
		BufferedReader in = null;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Professors.txt"),"utf-8"));
		}catch(UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next = in.readLine()) != null) {
				if(next.equals("")) {
					continue;
				}
				
				column = next.split("\\|");
				date = column[4].split("\\.");
				address=column[5].split("\\,");
				officeAddress=column[8].split("\\,");
				
				LocalDate ld = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				
				
				
				
				Address a = new Address(address[0], address[1], address[2], address[3]); // ulica, broj, grad, drzava
				Address aO = new Address(officeAddress[0], officeAddress[1], officeAddress[2], officeAddress[3]);
				
				Title t;

				if(column[10].trim().equals("ASISTENT"))
					t = Title.ASISTANT_PROFESSOR;
				else if (column[10].equals("DOCENT"))
					t = Title.ASSOCIATE_PROFESSOR;
				else
					t = Title.PROFESSOR;
				
				int yOt= Integer.parseInt(column[9].trim());
				
				
				Professor prof=new Professor(column[2].trim(),column[3].trim(),ld, column[6].trim(), column[7].trim(), a, aO, column[1].trim(), yOt, t);
				// ime, prz, datumrodj, telefon, mejl, adresa, adrsa kanc, id, staz, titula, predmeti
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
			Title temp = profesori.getTitle();
			String t;
			if(temp==Title.ASISTANT_PROFESSOR)
				t = "Asistent";
			else if (temp==Title.ASSOCIATE_PROFESSOR)
				t = "Docent";
			else
				t = "Profesor";
			return t;
		default:
			return null;
		}
	
	}
	
	public void addProfessor(String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title) {
		//this.professors.add(new Professor(name, surname, dateofbirth, phone, email, address, officeAdress, id, yearsOfTrail, title));
		this.allProfs.add(new Professor(name, surname, dateofbirth, phone, email, address, officeAdress, id, yearsOfTrail, title));
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
	public boolean findByName(String name) {
		boolean found = false;
		ArrayList<Professor> fp = new ArrayList<Professor>();
		for (Professor prof: professors) {
			
			if(prof.getName().toUpperCase().contains(name.toUpperCase())) {
				foundProf.add(prof);
				fp.add(prof);
				found = true;
			}
		}
		professors = fp;
		return found;
	}
	public boolean findBySurname(String surname) {
		boolean found = false;
		ArrayList<Professor> fp = new ArrayList<Professor>();
		for (Professor prof: professors) {
			if(prof.getSurname().toUpperCase().contains(surname.toUpperCase())) {
				foundProf.add(prof);
				fp.add(prof);
				found = true;
			}
		}
		professors = fp;
		return found;
	}
	
	public boolean findBySurnameAndName(String surname, String name){
		boolean found = false;
		ArrayList<Professor> fp = new ArrayList<Professor>();
		for (Professor prof: professors) {
			if(prof.getSurname().toUpperCase().contains(surname.toUpperCase()) && prof.getName().toUpperCase().contains(name.toUpperCase())) {
				foundProf.add(prof);
				fp.add(prof);
				found = true;
			}
		}
		professors = fp;
		return found;
	}
	
	public void switchBetweenFoundAndAll() {
		ArrayList<Professor> temp = new ArrayList<Professor>();
		temp = professors;
		professors = foundProf;
		foundProf = temp;
		
	}
	public void emptySearch() {
		professors = allProfs;
	} 
	
}
