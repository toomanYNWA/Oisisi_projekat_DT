package view;


import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;

import javax.swing.JLabel;



public class StatusBar extends JMenuBar {
	 
	public StatusBar() {
	JPanel statusBL = new JPanel();
	statusBL.setLayout(new FlowLayout(FlowLayout.LEFT));
	JLabel statusLabel = new JLabel("  Studentska služba");
	statusBL.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.BLUE));
	statusBL.add(statusLabel);
	
	add(statusBL);
	
	JPanel statusBD = new JPanel();
	statusBD.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	DateFormat dateFormat = new SimpleDateFormat("HH:mm        dd.MM.yyyy.        ");
	Date date = new Date();
	JLabel statusLabel1 = new JLabel(dateFormat.format(date));
	statusBD.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.BLUE));
	statusBD.add(statusLabel1);
	
	
	
	add(statusBD);
	
	}
}
