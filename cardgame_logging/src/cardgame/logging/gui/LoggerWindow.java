/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.logging.Level;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;
//import net.miginfocom.swing.MigLayout;
import cardgame.logging.utils.TextAreaHandler;
import framework.graphics.guicomponents.EFrame;
import framework.logging.logger.CardGameLogger;

public class LoggerWindow extends EFrame {

	private static final long serialVersionUID = 2464154933560375812L;

	private JTextArea loggerTextArea;
	private JScrollPane loggerScrollPane;
	private CardGameLogger logger;

	private TextAreaHandler textAreaHandler;
	private JRadioButton radioButtonError;
	private JRadioButton radioButtonWarning;
	private JRadioButton radioButtonInfo;
	private JRadioButton radioButtonDebug;
	private JRadioButton radioButtonTrace;
	private JPanel panelButtons;
	private JRadioButton radioButtonOff;

	public LoggerWindow() {
		super("Log");
		setName(getName());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(640, 320);
		setLocation(screenSize.width - 640, 600);
		getContentPane().setLayout(new MigLayout("insets 0 0 0 0", "[65][grow]", "[grow]"));

		initComponents();

		this.setVisible(true);
	}

	private void initComponents() {

		panelButtons = new JPanel();
		panelButtons.setName("panelButtons");
		getContentPane().add(panelButtons, "cell 0 0,growy");
		panelButtons.setLayout(new MigLayout("insets 5 0 5 0, gapy 15", "[65]", "[24px][24px][24px][24px][24px][24px][grow]"));
		
		radioButtonOff = new JRadioButton("Off");
		radioButtonOff.setName("radioButtonOff");
		panelButtons.add(radioButtonOff, "cell 0 0");

		radioButtonError = new JRadioButton("Error");
		panelButtons.add(radioButtonError, "cell 0 1");
		radioButtonError.setName("radiobuttonError");

		radioButtonWarning = new JRadioButton("Warning");
		panelButtons.add(radioButtonWarning, "cell 0 2");
		radioButtonWarning.setName("radioButtonWarning");

		radioButtonInfo = new JRadioButton("Info");
		panelButtons.add(radioButtonInfo, "cell 0 3");
		radioButtonInfo.setName("radioButtonInfo");

		radioButtonDebug = new JRadioButton("Debug");
		panelButtons.add(radioButtonDebug, "cell 0 4");
		radioButtonDebug.setName("radioButtonDebug");

		radioButtonTrace = new JRadioButton("Trace");
		panelButtons.add(radioButtonTrace, "cell 0 5");
		radioButtonTrace.setName("radioButtonTrace");
		
		loggerTextArea = new JTextArea();
		loggerTextArea.setName("textArea");

		loggerScrollPane = new JScrollPane();
		getContentPane().add(loggerScrollPane, "cell 1 0,grow");
		loggerScrollPane.setName("scrollPane");
		loggerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		textAreaHandler = new TextAreaHandler(loggerTextArea);
		
		logger = new CardGameLogger(getClass());// TODO: Start the logger service before the GUI component
		logger.addHandler(textAreaHandler);

		loggerScrollPane.setViewportView(loggerTextArea);
		logger.info("Initiate the Logger Window");
	}
	
	public void setLoggerLevel(Level lvl) {
		logger.setLevel(lvl);
	}
	
	public void addLevelChangerListener(ActionListener l) {
		radioButtonOff.addActionListener(l);
	}
}
