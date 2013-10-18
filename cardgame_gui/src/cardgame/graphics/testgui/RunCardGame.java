/**
 * Created by MrE on 17 okt 2013
 */
package cardgame.graphics.testgui;

import cardgame.logging.controller.LoggerController;
import cardgame.logging.gui.LoggerWindow;
import framework.logging.logger.CardGameLogger;

public class RunCardGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CardGameLogger loggerModel = new CardGameLogger(TestWindow.class);
		LoggerWindow loggerView = new LoggerWindow();
		new LoggerController(loggerView, loggerModel);
		
		TestWindow window = new TestWindow();
		TestGameBoard gameBoard = new TestGameBoard();
		window.add(gameBoard);
	}
}
