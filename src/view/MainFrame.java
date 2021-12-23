package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
	if (instance == null) {
	instance = new MainFrame();
	}
	return instance;
	}
	
	
	public MainFrame() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int newWidth =  (int)(width *0.75);
		int newHeight =  (int) (height *0.75);
		
		setSize(newWidth ,newHeight);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Studentska služba");
		Image img = kit.getImage("icons/ssluzba2.png");
		setIconImage(img);
		getContentPane().setBackground(Color.WHITE);
		
		MenuBar menuBar = new MenuBar();
		setJMenuBar(menuBar);

		ToolBar toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		StatusBar statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		add(TabbedPane.getInstance(), BorderLayout.CENTER);
		
	}
	
}
