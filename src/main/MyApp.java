package main;

import java.awt.EventQueue;

import view.MainFrame;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Proba");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
