package model;

import java.util.ArrayList;

public class CatDatabase {
	public static CatDatabase instance = null;

    public static CatDatabase getInstance(){
        if (instance== null) {
            instance = new CatDatabase();
        }
        return instance;
    }

    private ArrayList<Cathedra> cate = new ArrayList<Cathedra>();
    private ArrayList<Cathedra> allCate = new ArrayList<Cathedra>();
    private ArrayList<String> col;

    public CatDatabase() {

        this.col = new ArrayList<String>();
        this.col.add("ID");
        this.col.add("IME");
        this.col.add("GAZDA");
       
        

    }
    public int getRowCount() {
        return cate.size();
    }

    public int getColumnCount() {
        return 3;
    }
    public String getColumnName(int index) {
        return this.col.get(index);
    }
    public Cathedra getRow(int rowIndex) {
        return this.cate.get(rowIndex);
    }

    public Object getValueAt(int row,int column) {
    	Cathedra c = this.cate.get(row);
        switch(column) {
        case 0:
            return c.getCathedraID();
        case 1:
            return c.getCathedraName();
        case 2:
            return c.getProfessors();
       
        default:
            return null;
        }
    }


       
    }
