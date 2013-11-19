/**
 * Created by MrE on 18 nov 2013
 */
package cardgame.gui.base;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import framework.graphics.guicomponents.EComponent;
import framework.logging.logger.CardGameLogger;

public class CardGameImageComponent extends EComponent {

	private static final long serialVersionUID = 1201154364811850291L;

	private CardGameLogger logger = new CardGameLogger(CardGameImageComponent.class);
	
	protected BufferedImage getImageWithPath(String imagePath) {
		try {
			return ImageIO.read(getClass().getClassLoader().getResource(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.err(String.format("The file on path: %s can not be found by %s!", imagePath, getClass()));
		}
		return null;
	}
}
