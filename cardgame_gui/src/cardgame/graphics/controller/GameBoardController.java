/**
 * Created by MrE on 2 nov 2013
 */
package cardgame.graphics.controller;

import cardgame.controller.base.ControllerBase;
import framework.cardgame.mvcbase.abstracts.AbstractModel;
import framework.cardgame.mvcbase.abstracts.AbstractView;

public class GameBoardController extends ControllerBase {

	public GameBoardController(AbstractModel model, AbstractView... views) {
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
