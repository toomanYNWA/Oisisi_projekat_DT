package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
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
        this.col.add("Id");
        this.col.add("Ime katedre");
        this.col.add("Sef katedre");
        initialize();
        

    }
    public void initialize() {
		String next=null;
		String[] column=null;
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("resources/Cathedras.txt"),"utf-8"));
		}catch(UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while((next=in.readLine())!=null) {
				if(next.equals("")) {
					continue;
				}
				
				column=next.split("\\|");
				String cId = column[1].trim();
				String cName = column[2].trim();
				String chiefId = column[3].trim();
				Professor cC = ProfessorsDatabase.getInstance().getProfById(chiefId);
				Cathedra c = new Cathedra(cId,cName,cC);
				cate.add(c);
				
			} 
			
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
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
            return c.getCathedraChief().getName()+" "+c.getCathedraChief().getName();
       
        default:
            return null;
        }
    }


       
    }
