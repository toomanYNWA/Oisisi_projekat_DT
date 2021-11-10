package model;
import java.util.ArrayList;
import java.util.List;
public class Cathedra {

	private String cathedraID;
	private String cathedraName;
	private String cathedraChief;
	private List<String> profesori = new ArrayList<String>();
	
	public Cathedra(String cathedraID, String cathedraName, String cathedraChief, List<String> profesori) {
		super();
		this.cathedraID = cathedraID;
		this.cathedraName = cathedraName;
		this.cathedraChief = cathedraChief;
		this.profesori = profesori;
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

	public List<String> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<String> profesori) {
		this.profesori = profesori;
	}

	@Override
	public String toString() {
		return "Cathedra [cathedraID=" + cathedraID + ", cathedraName=" + cathedraName + ", cathedraChief="
				+ cathedraChief + ", profesori=" + profesori + "]";
	}
	
	
	
}
