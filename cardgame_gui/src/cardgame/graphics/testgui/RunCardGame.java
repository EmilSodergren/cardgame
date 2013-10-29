/**
 * Created by MrE on 17 okt 2013
 */
package cardgame.graphics.testgui;

import java.util.logging.Level;

import cardgame.logging.controller.LoggerController;
import cardgame.logging.gui.LoggerWindow;
import framework.logging.logger.CardGameLogger;

public class RunCardGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CardGameLogger loggerModel = new CardGameLogger(TestWindow.class);
		LoggerWindow loggerView = new LoggerWindow(Level.INFO);
		loggerView.setVisible(true);
		new LoggerController(loggerModel, loggerView);
		
		TestWindow window = new TestWindow();
		TestGameBoard gameBoard = new TestGameBoard();
		window.setContentPane(gameBoard);
		window.setVisible(true);
	}
}
