package model;
import java.util.ArrayList;
import java.util.List;
public class Cathedra {

	private String cathedraID;
	private String cathedraName;
	private Professor cathedraChief;
	private ArrayList<Professor> professors ;
	
	public Cathedra(String cathedraID, String cathedraName, Professor cathedraChief) {
		super();
		this.cathedraID = cathedraID;
		this.cathedraName = cathedraName;
		this.cathedraChief = cathedraChief;
	}
	
	public Cathedra(String cathedraID, String cathedraName, Professor cathedraChief, ArrayList<Professor> professors) {
		super();
		this.cathedraID = cathedraID;
		this.cathedraName = cathedraName;
		this.cathedraChief = cathedraChief;
		this.professors = professors;
	}
	public Cathedra(Cathedra c) {
		this.cathedraID = c.cathedraID;
		this.cathedraName = c.cathedraName;
		this.cathedraChief = c.cathedraChief;
		this.professors = c.professors;
	}

	public String getCathedraID() {
		return cathedraID;
	}

	public void setCathedraID(String cathedraID) {
		this.cathedraID = cathedraID;
	}

	public String getCathedraName() {
		return cathedraName;
	}

	public void setCathedraName(String cathedraName) {
		this.cathedraName = cathedraName;
	}

	public Professor getCathedraChief() {
		return cathedraChief;
	}

	public void setCathedraChief(Professor cathedraChief) {
		this.cathedraChief = cathedraChief;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "Cathedra [cathedraID=" + cathedraID + ", cathedraName=" + cathedraName + ", cathedraChief="
				+ cathedraChief + ", professors=" + professors + "]";
	}
	
	
	
}
