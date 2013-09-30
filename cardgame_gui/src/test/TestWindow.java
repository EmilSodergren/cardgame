/**
 * 
 */
package test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import cardgame.logging.gui.LoggerWindow;
import framework.graphics.guicomponents.EFrame;
import framework.logging.logger.CardGameLogger;

/**
 * @author MrE
 * 
 */
public class TestWindow extends EFrame {

	private static final long serialVersionUID = 1742936565714076461L;
	
	public CardGameLogger logger = CardGameLogger.getInstance();

	public TestWindow() {
		super("TestWindow");
		setName(TestWindow.class.getName());
		logger.info("Main window created");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width - 800, 0);
		setSize(new Dimension(800, 600));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LoggerWindow();
		TestWindow window = new TestWindow();
		TestCard card = new TestCard();
		window.add(card);
	}
}
