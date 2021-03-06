/**
 * Created by MrE on 17 okt 2013
 */
package cardgame.graphics.testgui;

import java.util.logging.Level;

import cardgame.common.CommonConstants;
import cardgame.graphics.controller.GameBoardController;
import cardgame.logging.controller.LoggerController;
import cardgame.logging.gui.LoggerWindow;
import cardgame.model.gameboard.GameBoardModel;
import framework.logging.logger.CardGameLogger;

public class RunCardGame {

	public static void main(String[] args) {
		
		CardGameLogger loggerModel = new CardGameLogger(TestWindow.class);
		LoggerWindow loggerView = new LoggerWindow(Level.INFO);
		loggerView.setVisible(true);
		new LoggerController(loggerModel, loggerView);
		
		TestGameBoard gameBoard = new TestGameBoard();
		new GameBoardController(new GameBoardModel(), gameBoard);
		
		TestWindow window = new TestWindow(CommonConstants.RESOLUTION);
		window.setContentPane(gameBoard);
		window.setVisible(true);
	}
}
