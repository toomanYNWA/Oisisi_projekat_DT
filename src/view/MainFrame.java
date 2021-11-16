package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
	
	private JPanel contentPane;
	
	public MainFrame() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int W = (int)screenSize.getWidth();
		int H = (int)screenSize.getHeight();
		int newW =  (int) (W *0.75);
		int newH =  (int) (H *0.75);
		
		setSize(newW ,newH);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Studentska služba");
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		
		
	}
	
}
