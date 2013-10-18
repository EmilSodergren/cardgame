/**
 * Created by MrE on 15 okt 2013
 */
package cardgame.logging.controller;

import cardgame.logging.gui.LoggerWindow;
import framework.cardgame.mvcbase.abstracts.AbstractController;
import framework.logging.logger.CardGameLogger;

public class LoggerController extends AbstractController {
	
	public LoggerController(LoggerWindow view, CardGameLogger model) {
		addView(view);
		addModel(model);
	}

	@Override
	public void onViewEvent(String propertyName, Object newValue) {
		setModelProperty(propertyName, newValue);
	}
}
