package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Address;
import model.Professor;
import model.Professor.Title;
import model.ProfessorsDatabase;
import view.TabbedPane;

public class ProfessorsController {
	private static ProfessorsController instance = null;
	private boolean found = false;
	
	public static ProfessorsController getInstance() {
		if(instance==null) {
			instance = new ProfessorsController();
		}
		return instance;
	}
	private ProfessorsController() {}
	
	public void addProfessor(String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title) {
		ProfessorsDatabase.getInstance().addProfessor(name, surname, dateofbirth, phone, email, address, officeAdress, id, yearsOfTrail, title);
		TabbedPane.getInstance().updateProfessors();
	}
	public void editProfessor(int rowSelectedIndex, String name, String surname, LocalDate dateofbirth, String phone, String email,
			Address address, Address officeAdress, String id, int yearsOfTrail, Title title) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Professor prof = ProfessorsDatabase.getInstance().getRow(rowSelectedIndex);
		ProfessorsDatabase.getInstance().editProfessor(prof.getId(), name, surname, dateofbirth, phone, email,
				address, officeAdress, id, yearsOfTrail, title);
		TabbedPane.getInstance().updateProfessors();
	}
	
	 public void deleteProfessor(int rowSelectedIndex) {
	    	if (rowSelectedIndex < 0) {
				return;
			}
	    	Professor prof = ProfessorsDatabase.getInstance().getRow(rowSelectedIndex);
			ProfessorsDatabase.getInstance().deleteProfessor(prof.getId());
			TabbedPane.getInstance().updateProfessors();
	    }
	 public Professor getProfessor(int rowSelectedIndex) {
		 Professor prof = ProfessorsDatabase.getInstance().getRow(rowSelectedIndex);
		 return prof;
	 }
	 public void findBySurname(String surname) {
			found = ProfessorsDatabase.getInstance().findBySurname(surname);
			if(found) {
				TabbedPane.getInstance().updateProfessors();
			} else {
				JOptionPane.showMessageDialog(null, "Ne postoji profesor sa unetim prezimenom");
				TabbedPane.getInstance().updateProfessors();
			}
		}
	 public void findByName(String name) {
			found = ProfessorsDatabase.getInstance().findByName(name);
			if(found) {
				TabbedPane.getInstance().updateProfessors();
			} else {
				JOptionPane.showMessageDialog(null, "Ne postoji profesor sa unetim imenom");
				TabbedPane.getInstance().updateProfessors();
			}
		}
	 public void findBySurnameAndName(String surname, String name) {
			found = ProfessorsDatabase.getInstance().findBySurnameAndName(surname, name);
			if(found) {
				TabbedPane.getInstance().updateProfessors();
			} else {
				JOptionPane.showMessageDialog(null, "Ne postoji profesor sa unetim imenom i prezimenom!");
				TabbedPane.getInstance().updateProfessors();
			}
		}

	 public boolean isFound() {
			return found;
		}

	 public void setFound(boolean found) {
			this.found = found;
		}
}
