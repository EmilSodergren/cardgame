/**
 * 
 */
package cardgame.graphics.testgui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import cardgame.logging.controller.LoggerController;
import cardgame.logging.gui.LoggerWindow;
import cardgame.model.logger.CardGameLoggerModel;
import framework.graphics.guicomponents.EFrame;
import framework.logging.logger.CardGameLogger;

/**
 * @author MrE
 * 
 */
public class TestWindow extends EFrame {

	private static final long serialVersionUID = 1742936565714076461L;
	
	private CardGameLogger logger = new CardGameLogger(getClass());

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
		CardGameLoggerModel loggerModel = new CardGameLoggerModel();
		LoggerWindow loggerView = new LoggerWindow();
		LoggerController loggerController = new LoggerController(loggerView, loggerModel);
		
		TestWindow window = new TestWindow();
		TestGameBoard gameBoard = new TestGameBoard();
		window.add(gameBoard);
	}
}
