package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class FocusListenerProfessors implements FocusListener {
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) arg0.getComponent();
		

		if (txt.getName().equals("txtRequired")) {

			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Obavezan unos...")) {
				txt.setText("Obavezan unos...");
				txt.setForeground(Color.RED);
			} else {
				txt.setForeground(Color.BLACK);
			}
		}
	}
}
