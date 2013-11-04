/**
 * Created by MrE on 27 okt 2013
 */
package cardgame.cards.controller;

import cardgame.controller.base.ControllerBase;
import cardgame.gui.base.CardGuiBase;
import framework.cardgame.mvcbase.abstracts.AbstractModel;

// TODO: Maybe make this class templated to avoid the unchecked cast??

public class CardController extends ControllerBase {

	public CardController(AbstractModel model, CardGuiBase... views) {
		super(model, views);
	}

	@Override
	public void onViewEvent(String propertyName, Object newValue) {
		setModelProperty(propertyName, newValue);
	}
}
