/**
 * Created by MrE on 15 okt 2013
 */
package cardgame.logging.controller;

import cardgame.controller.base.ControllerBase;
import framework.cardgame.mvcbase.abstracts.AbstractModel;
import framework.cardgame.mvcbase.abstracts.AbstractView;

public class LoggerController extends ControllerBase {
	
	public LoggerController(AbstractModel model, AbstractView view) {
		super(model, view);
	}

	@Override
	public void onViewEvent(String propertyName, Object newValue) {
		setModelProperty(propertyName, newValue);
	}
}
