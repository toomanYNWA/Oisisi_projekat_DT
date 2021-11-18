package model;
import java.util.ArrayList;
import java.util.List;
public class Cathedra {

	private String cathedraID;
	private String cathedraName;
	private String cathedraChief;
	private ArrayList<Professor> professors ;
	
	public Cathedra(String cathedraID, String cathedraName, String cathedraChief, ArrayList<Professor> profesori) {
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

	public String getCathedraChief() {
		return cathedraChief;
	}

	public void setCathedraChief(String cathedraChief) {
		this.cathedraChief = cathedraChief;
	}

	public List<Professor> getProfesori() {
		return professors;
	}

	public void setProfesori(ArrayList<String> profesori) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "Cathedra [cathedraID=" + cathedraID + ", cathedraName=" + cathedraName + ", cathedraChief="
				+ cathedraChief + ", profesori=" + professors + "]";
	}
	
	
	
}
