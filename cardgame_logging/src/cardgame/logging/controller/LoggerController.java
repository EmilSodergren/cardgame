/**
 * Created by MrE on 15 okt 2013
 */
package cardgame.logging.controller;

import framework.cardgame.mvcbase.abstracts.AbstractController;
import framework.cardgame.mvcbase.abstracts.AbstractModel;
import framework.cardgame.mvcbase.abstracts.AbstractView;

public class LoggerController extends AbstractController {
	
	public LoggerController(AbstractView view, AbstractModel model) {
		addModel(model);
		addView(view);
	}

	@Override
	public void onViewEvent(String propertyName, Object newValue) {
		setModelProperty(propertyName, newValue);
	}
}
