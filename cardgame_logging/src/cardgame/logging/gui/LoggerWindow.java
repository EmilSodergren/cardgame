/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import cardgame.logging.logger.TextAreaHandler;

public class LoggerWindow extends JFrame{

	private static final long serialVersionUID = 2464154933560375812L;

	private JTextArea textArea;
	private JScrollPane scrollPane;
	private Logger logger = Logger.getLogger(LoggerWindow.class.getName());
	
	private TextAreaHandler textAreaHandler;
	
	public LoggerWindow() {
		super("Log");
		setName(LoggerWindow.class.getName());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(640, 320);
		setLocation(screenSize.width-640, 600);
		
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		
		textArea = new JTextArea();
		textArea.setName("textArea");
//		textArea.setText("Hej fuling!");
		textArea.setVisible(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setName("scrollPane");
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);

		textAreaHandler = new TextAreaHandler(textArea);
		logger.addHandler(textAreaHandler);
		getContentPane().add(scrollPane);	
		scrollPane.getViewport().add(textArea);
	}
}
