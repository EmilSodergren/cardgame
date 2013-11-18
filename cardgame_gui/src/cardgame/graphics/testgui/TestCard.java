/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.testgui;

import java.awt.Dimension;
import java.awt.Point;

import cardgame.cards.cardtypes.AttackerCard;

public class TestCard extends AttackerCard {
	
	private static final long serialVersionUID = 3059182549896122482L;

	public TestCard() {
		super();
	}
	
	@Override
	public void setDefaults() {
		super.setDefaults();
		controller.onViewEvent("MainImagePath", "cardgame/cards/resources/card.png");
		controller.onViewEvent("GlowImagePath", "cardgame/cards/resources/card_glow_overlay.png");
		controller.onViewEvent("Pos", new Point(110,110));
		controller.onViewEvent("Size", new Dimension(96,144));
	}
}
