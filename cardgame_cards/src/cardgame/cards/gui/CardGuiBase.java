/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.cards.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import framework.graphics.guicomponents.EComponent;
import framework.logging.logger.CardGameLogger;

public class CardGuiBase extends EComponent {

	private static final long serialVersionUID = 5322618823703871299L;
	
	private CardGameLogger logger = new CardGameLogger(CardGuiBase.class);
	
	protected Image bgImage;
	
	public CardGuiBase(String imageName) {
		super();
		String filePath = String.format("cardgame/cards/resources/%s", imageName);
		try {
			bgImage = ImageIO.read(CardGuiBase.class.getClassLoader().getResource(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			logger.err(String.format("The file on path: \n%s\n can not be found!", filePath));
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bgImage, 100, 100, null);
	}
}
