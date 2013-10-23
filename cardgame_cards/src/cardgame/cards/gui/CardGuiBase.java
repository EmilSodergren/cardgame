/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.cards.gui;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import framework.graphics.guicomponents.EComponent;

public class CardGuiBase extends EComponent {

	private static final long serialVersionUID = 5322618823703871299L;
	
	protected Image bgImage;
	
	public CardGuiBase(String imageName) {
		super();
		try {
			bgImage = ImageIO.read(CardGuiBase.class.getClassLoader().getResource("cardgame/cards/resources/" + imageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
