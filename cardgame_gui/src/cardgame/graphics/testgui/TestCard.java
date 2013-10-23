/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.testgui;

import java.awt.Image;

import cardgame.cards.gui.CardGuiBase;

public class TestCard extends CardGuiBase{
	
	private static final long serialVersionUID = 3059182549896122482L;

	public TestCard() {
		super("Card.png");
	}
	
	public Image getImage() {
		return bgImage;
	}
}
