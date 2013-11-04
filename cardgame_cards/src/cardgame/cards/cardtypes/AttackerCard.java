/**
 * Created by MrE on 4 nov 2013
 */
package cardgame.cards.cardtypes;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import cardgame.gui.base.CardGuiBase;
import framework.logging.logger.CardGameLogger;

public class AttackerCard extends CardGuiBase {

	private static final long serialVersionUID = 2045534418775837138L;

	CardGameLogger logger = new CardGameLogger(AttackerCard.class);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BufferedImage getImageWithPath(String imagePath) {
		BufferedImage image;
		try {
			image = ImageIO.read(CardGuiBase.class.getClassLoader().getResource(imagePath));
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.err(String.format("The file on path: %s can not be found!", imagePath));
		}
		return null;
	}

	
}
