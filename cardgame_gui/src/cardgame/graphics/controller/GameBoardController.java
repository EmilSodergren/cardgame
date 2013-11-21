/**
 * Created by MrE on 2 nov 2013
 */
package cardgame.graphics.controller;

import cardgame.controller.base.ControllerBase;
import cardgame.graphics.testgui.TestGameBoard;
import cardgame.model.gameboard.GameBoardModel;

public class GameBoardController extends ControllerBase {

	public GameBoardController(GameBoardModel model, TestGameBoard... views) {
		super(model, views);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onViewEvent(String propertyName, Object newValue) {
		setModelProperty(propertyName, newValue);
	}
}
