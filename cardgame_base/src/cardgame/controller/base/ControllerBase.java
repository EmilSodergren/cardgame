/**
 * Created by MrE on 2 okt 2013
 */
package cardgame.controller.base;

import framework.cardgame.mvcbase.abstracts.AbstractController;
import framework.cardgame.mvcbase.abstracts.AbstractModel;
import framework.cardgame.mvcbase.abstracts.AbstractView;

public abstract class ControllerBase extends AbstractController{
	
	public ControllerBase(AbstractModel model, AbstractView... views) {
		super();
		addModel(model);
		for (AbstractView view : views) {
			addView(view);
		}
	}	
}
