/**
 * Created by MrE on 18 nov 2013
 */
package cardgame.graphics.controller;

import cardgame.controller.base.ControllerBase;
import cardgame.gui.base.SnapAreaGuiBase;
import cardgame.model.gameboard.SnapAreaModel;

public class SnapAreaController extends ControllerBase {

	public SnapAreaController(SnapAreaModel model, SnapAreaGuiBase ... views) {
		super(model, views);
	}
}
