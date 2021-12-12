package main;

import model.StudentDatabase;
import view.MainFrame;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Proba");
	
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		StudentDatabase.getInstance();
		
	}

}
