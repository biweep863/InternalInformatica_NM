package Screens;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import database.PaymentDatabase;

public class WindowHelper {
	
	
	/**
	 * Sets the location of the window in the center of the screen
	 * 
	 * @param frame Window Frame
	 */
	public static void centerOnScreen(JFrame frame) {
		Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenDimensions.getWidth() - frame.getWidth()) / 2;
		int y = (int) (screenDimensions.getHeight() - frame.getHeight()) / 2;
		frame.setLocation(x, y);
	}
	
	/**
	 * Loads a file and modifies the appropiate GUI
	 * 
	 * @param path File path string 
	 * @param progressBar ProgressBar to modify
	 * @param errorLabel ErrorLabel to show error output
	 * @param newWindow  New window to open once file loads
	 * @param currentWindow Current window to close once file loads
	 */

	public static void loadFile(File selectedFile) {

		if(selectedFile != null && selectedFile.exists()) {
			PaymentDatabase.getInstance(selectedFile.getPath());
        }
	}
	
	/**
	 * Loads a new Window
	 * 
	 * @param newWindow New Window
	 * @param currentWindow Current Window
	 * @param option 1 for asteroidDataWindow, 2 for databaseDataWindow, 3 selectionWindow
	 */
	public static void loadNewWindow(JFrame newWindow, JFrame currentWindow) {
		
		newWindow.setVisible(true);
		currentWindow.dispose();
	}
}