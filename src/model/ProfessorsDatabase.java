package model;

import java.util.ArrayList;
import java.util.List;

public class ProfessorsDatabase {
	private static ProfessorsDatabase instance = null;

	public static ProfessorsDatabase getInstance() {
		if (instance == null) {
			instance = new ProfessorsDatabase();
		}
		return instance;
	}

	private ArrayList<Professor> profesori;
	//private ArrayList<Profesor> sviProfesori;
	private List<String> kolone;

	private ProfessorsDatabase() {
		initProfessor();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("PREZIME");
		this.kolone.add("IME");
		this.kolone.add("DATUM RODJENJA");
		this.kolone.add("ADRESA STANOVANJA");
		this.kolone.add("TELEFON");
		this.kolone.add("EMAIL");
		this.kolone.add("ADRESA KANCELARIJE");
		this.kolone.add("BR LK");
		this.kolone.add("ZVANJE");
		this.kolone.add("GODINE STAZA");
		this.kolone.add("PREDMETI");
	}
	private void initProfessor() {}
	
	public ArrayList<Professor> getProfesori() {
		return profesori;
	}
	
	public int getColumnCount() {
		return 11;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public Object getValueAt(int row, int col) {
		Professor profesori=this.profesori.get(row);
		switch(col) {
		case 0:
			return profesori.getSurname();
		case 1:
			return profesori.getName();
		case 2:
			return profesori.getDateofbirth();//.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		case 3:
			return profesori.getAddress();
		case 4:
			return profesori.getPhone();
		case 5:
			return profesori.getEmail();
		case 6:
			return profesori.getOfficeAdress();
		case 7:
			return profesori.getId();
		case 8:
			return profesori.getTitle();
		case 9:
			return profesori.getYearsOfTrail();
			
		default:
			return null;
		}
	}
	
	
}
