/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.testgui;

import java.awt.Point;

import cardgame.cards.cardtypes.AttackerCard;
import cardgame.common.CommonConstants;

public class TestCardV2 extends AttackerCard {
	
	private static final long serialVersionUID = 3059182549896122482L;

	public TestCardV2() {
		super();
	}
	
	@Override
	public void setDefaults() {
		super.setDefaults();
		controller.onViewEvent("MainImagePath", "cardgame/cards/resources/card_v2.png");
		controller.onViewEvent("GlowImagePath", "cardgame/cards/resources/card_glow_overlay.png");
		controller.onViewEvent("Pos", new Point(130,100));
		controller.onViewEvent("Size", CommonConstants.CARD_SIZE);
	}
}
