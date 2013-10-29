/**
 * Created by MrE on 1 okt 2013
 */
package cardgame.graphics.testgui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import cardgame.cards.controller.CardController;
import cardgame.cards.gui.CardGuiBase;
import cardgame.model.cards.CardModelBase;
import cardgame.mouse.interaction.CardGameMouseAdapter;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel {

	private static final long serialVersionUID = 9066548687077615194L;

	private CardGameLogger logger = new CardGameLogger(TestGameBoard.class);
	private CardGameMouseAdapter mouseListener = new CardGameMouseAdapter();
	
	private Image boardImage;
	private ArrayList<CardController> cards = new ArrayList<CardController>();

	public TestGameBoard() {
		super();
		cards.add(new CardController(new CardModelBase(), new CardGuiBase("card.png")));
		cards.add(new CardController(new CardModelBase(), new CardGuiBase("card-v2.png")));
		String filePath = "cardgame/graphics/resources/background-small.png";
		try {
			boardImage = ImageIO.read(TestGameBoard.class.getClassLoader().getResource(filePath));
		} catch (IOException e) {
			logger.err(String.format("The file %s can not be found!", filePath));
		}
		initComponents();
	}

	private void initComponents() {
		setName(TestGameBoard.class.getName());
		logger.info("TestGameBoard panel created");
		initMouseInteractions(mouseListener);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(boardImage, 0, 0, null);
		for (CardController controller : cards) {
			for (CardGuiBase view : controller.getViews()) {
				view.paint(g);
			}
		}
	}
}
