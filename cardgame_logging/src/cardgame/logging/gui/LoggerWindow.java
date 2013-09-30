/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import cardgame.logging.logger.TextAreaHandler;
import framework.logging.logger.CardGameLogger;

public class LoggerWindow extends JFrame{

	private static final long serialVersionUID = 2464154933560375812L;

	private JTextArea loggerTextArea;
	private JScrollPane loggerScrollPane;
	private CardGameLogger logger;
	
	private TextAreaHandler textAreaHandler;
	
	public LoggerWindow() {
		super("Log");
		setName(getName());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(640, 320);
		setLocation(screenSize.width-640, 600);
		
		initComponents();
		
		this.setVisible(true);
	}

	private void initComponents() {
		logger = CardGameLogger.getInstance(); //TODO: Start the logger service before the GUI component
		loggerTextArea = new JTextArea();
		loggerTextArea.setName("textArea");
		loggerTextArea.setVisible(true);
		
		loggerScrollPane = new JScrollPane();
		loggerScrollPane.setName("scrollPane");
		loggerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		loggerScrollPane.setVisible(true);

		textAreaHandler = new TextAreaHandler(loggerTextArea);
		logger.addHandler(textAreaHandler);
		getContentPane().add(loggerScrollPane);	
		loggerScrollPane.getViewport().add(loggerTextArea);
		
		logger.info("Initiate the Logger Window");
	}
}
