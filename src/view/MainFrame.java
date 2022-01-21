package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Menu;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	private static MainFrame instance = null;
	private ResourceBundle resourceBundle;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}

		return instance;
	}
	private MenuBar menuBar;
	private ToolBar toolBar;
	private StatusBar statusBar;
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
		//Locale.setDefault(new Locale("en","US"));
		//resourceBundle = ResourceBundle.getBundle("view.MessageResources.mr",Locale.getDefault());
		
		setTitle("Studentska služba");
		//setTitle(resourceBundle.getString("appTitle"));
		Image img = kit.getImage("icons/ssluzba2.png");
		setIconImage(img);
		getContentPane().setBackground(Color.WHITE);
		
		menuBar = new MenuBar();
		setJMenuBar(menuBar);

		toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		

		
		add(TabbedPane.getInstance(statusBar), BorderLayout.CENTER);
		
	}
	/*public void changeLanguageComponents() {
		resourceBundle = ResourceBundle.getBundle("view.MessageResources.mr",Locale.getDefault());
		setTitle(resourceBundle.getString("appTitle"));
		menuBar.init();
		toolBar.init();
		statusBar.init();
		
	}
	
	public ResourceBundle getResourcesBundle() {
		return resourceBundle;
	}
	public String getCurrentLocalValue(String key) {
		return this.resourceBundle.getString(key);
	}*/
	
}
