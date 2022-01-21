package view;


import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.JLabel;


public class StatusBar extends JMenuBar {
	 
	private SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss        dd.MM.yyyy.     "); 
	private JLabel statusLabel; // nn
	public StatusBar() {
		JPanel statusBL = new JPanel();
		statusBL.setLayout(new FlowLayout(FlowLayout.LEFT));
		statusLabel = new JLabel(" Studentska služba - Student ");
		statusBL.add(statusLabel);
		
		add(statusBL);
		
		JPanel statusBD = new JPanel();
		statusBD.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel statusLabel1 = new JLabel();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					Date date = new Date();
					String dateString = simpleDateFormat.format(date);
					statusLabel1.setText(dateString);
					try {
						Thread.sleep(1000);
					} 
					catch(InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
			};
		Thread t=new Thread(runnable);
		t.start();
		
		statusBD.add(statusLabel1);
		add(statusBD);
	}
	public JLabel getStatusLabel() {
		return statusLabel;
	}
	public void init() {}
	
}


