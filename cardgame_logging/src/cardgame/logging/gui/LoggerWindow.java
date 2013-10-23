/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.HashMap;
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
	private CardGameLogger logger = new CardGameLogger(LoggerWindow.class);

	private TextAreaHandler textAreaHandler;

	private JPanel panelButtons;

	private HashMap<Level, JRadioButton> radioButtonMap;

	private JRadioButton radioButtonError;
	private JRadioButton radioButtonWarning;
	private JRadioButton radioButtonInfo;
	private JRadioButton radioButtonDebug;
	private JRadioButton radioButtonTrace;
	private JRadioButton radioButtonOff;
	private JRadioButton radioButtonAll;

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
		panelButtons.setLayout(new MigLayout("insets 5 0 5 0, gapy 15", "[65]", "[24px][24px][24px][24px][24px][24px][24px]"));

		radioButtonMap = new HashMap<Level, JRadioButton>(6);

		radioButtonOff = new JRadioButton("Off");
		radioButtonOff.setName("radioButtonOff");
		radioButtonOff.addActionListener(new ButtonAL(Level.OFF));
		radioButtonMap.put(Level.OFF, radioButtonOff);
		panelButtons.add(radioButtonOff, "cell 0 0");

		radioButtonError = new JRadioButton("Error");
		panelButtons.add(radioButtonError, "cell 0 1");
		radioButtonError.setName("radiobuttonError");
		radioButtonMap.put(Level.SEVERE, radioButtonError);
		radioButtonError.addActionListener(new ButtonAL(Level.SEVERE));

		radioButtonWarning = new JRadioButton("Warning");
		panelButtons.add(radioButtonWarning, "cell 0 2");
		radioButtonWarning.setName("radioButtonWarning");
		radioButtonMap.put(Level.WARNING, radioButtonWarning);
		radioButtonWarning.addActionListener(new ButtonAL(Level.WARNING));

		radioButtonInfo = new JRadioButton("Info");
		panelButtons.add(radioButtonInfo, "cell 0 3");
		radioButtonInfo.setName("radioButtonInfo");
		radioButtonMap.put(Level.INFO, radioButtonInfo);
		radioButtonInfo.addActionListener(new ButtonAL(Level.INFO));

		radioButtonDebug = new JRadioButton("Debug");
		panelButtons.add(radioButtonDebug, "cell 0 4");
		radioButtonDebug.setName("radioButtonDebug");
		radioButtonMap.put(Level.FINE, radioButtonDebug);
		radioButtonDebug.addActionListener(new ButtonAL(Level.FINE));

		radioButtonTrace = new JRadioButton("Trace");
		panelButtons.add(radioButtonTrace, "cell 0 5");
		radioButtonTrace.setName("radioButtonTrace");
		radioButtonMap.put(Level.FINER, radioButtonTrace);
		radioButtonTrace.addActionListener(new ButtonAL(Level.FINER));

		radioButtonAll = new JRadioButton("All");
		radioButtonAll.setName("radioButtonAll");
		panelButtons.add(radioButtonAll, "cell 0 6");
		radioButtonMap.put(Level.ALL, radioButtonAll);
		radioButtonAll.addActionListener(new ButtonAL(Level.ALL));

		loggerTextArea = new JTextArea();
		loggerTextArea.setName("textArea");

		loggerScrollPane = new JScrollPane();
		getContentPane().add(loggerScrollPane, "cell 1 0,grow");
		loggerScrollPane.setName("scrollPane");
		loggerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textAreaHandler = new TextAreaHandler(loggerTextArea);

		logger.addHandler(textAreaHandler);

		loggerScrollPane.setViewportView(loggerTextArea);
		logger.info("Initiate the Logger Window");
	}

	private class ButtonAL implements ActionListener {

		Level level;

		ButtonAL(Level level) {
			this.level = level;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			logger.log(Level.OFF, "Pressed " + level.toString());
			controller.onViewEvent("Level", level);
		}
	}

	@Override
	public void update(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof Level) {
			Level newLevel = (Level) evt.getNewValue();
			for (Level level : radioButtonMap.keySet()) {
				if (level.equals(newLevel)) {
					radioButtonMap.get(level).setSelected(true);
				} else {
					radioButtonMap.get(level).setSelected(false);
				}
			}
		}
	}

	@Override
	public void setDefaults() {
		controller.onViewEvent("Level", Level.ALL);
	}
}
