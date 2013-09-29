/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.gui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import framework.graphics.guicomponents.EFrame;

public class LoggerWindow extends EFrame{

	private static final long serialVersionUID = 2464154933560375812L;
	
	public LoggerWindow() {
		super("Log");
		setName("LoggerWindow");
		
		
		setSize(640, 320);
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		JScrollPane scrollpane = new JScrollPane();
		JTextArea textArea = new JTextArea();

		scrollpane.add(textArea);
		
		add(scrollpane);
	}
}
