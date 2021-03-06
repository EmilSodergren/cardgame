/**
 * Created by MrE on 20 nov 2013
 */
package cardgame.graphics.testgui;

import java.awt.Point;

import cardgame.common.CommonConstants;
import cardgame.gui.base.SnapAreaGuiBase;

public class TestSnapArea extends SnapAreaGuiBase {

	private static final long serialVersionUID = 513353417626945782L;

	private Point initPos;
	
	public TestSnapArea(Point pos) {
		initPos = pos;
	}
	
	@Override
	public void setDefaults() {
		super.setDefaults();
		controller.onViewEvent("Pos", initPos);
		controller.onViewEvent("Size", CommonConstants.SNAP_AREA_SIZE);
		controller.onViewEvent("Occupied", Boolean.FALSE);
		controller.onViewEvent("OnTarget", Boolean.FALSE);
		controller.onViewEvent("CorrectPath", "cardgame/graphics/resources/snap_area_correct.png");
		controller.onViewEvent("WrongPath", "cardgame/graphics/resources/snap_area_wrong.png");
	}
}
