package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExamsPassedDatabase {
	
	public static ExamsPassedDatabase instance = null;
	
	public static ExamsPassedDatabase getInstance(){
		if (instance== null) {
			instance = new ExamsPassedDatabase();
		}
		return instance;		
	}
	
	private ArrayList<Grade> subGr = new ArrayList<Grade>();
	private ArrayList<String> col;

	public ExamsPassedDatabase() {
	
		col = new ArrayList<String>();
		col.add("ID");
		col.add("IME");
		col.add("ESPB");
		col.add("OCENA");
		col.add("DATUM");
		
	}
//	public void initialize(ArrayList<Grade> grades) {
//		subGr = grades;
//		//subGr.add(new Grade(new Student("ra12/12",12,1,"Asd","asd",LocalDate.parse("1111-11-11"),new Address("","","",""),"",2019,""), new Subject(100,"Nuklearna Pekezcina",1,12,40), 8, LocalDate.parse("1111-11-11")));
//		
//	}
	public int getRowCount() {
		return subGr.size();
	}
	
	public int getColumnCount() {
		return 5;
	}
	public String getColumnName(int index) {
		return this.col.get(index);
	}
	public Grade getRow(int rowIndex) {
		return this.subGr.get(rowIndex);
	}
	
	public Object getValueAt(int row,int column) {
		Grade gr = this.subGr.get(row);
		switch(column) {
		case 0:
			return gr.getSubject().getSubjectID();
		case 1:
			return gr.getSubject().getSubjectName();
		case 2:
			return gr.getSubject().getEspb();
		case 3:
			return gr.getValue();
		case 4:
			return gr.getDateofExam().toString();
		
		default:
			return null;
		}
	}
}
