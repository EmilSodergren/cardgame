/**
 * Created by MrE on 1 okt 2013
 */
package test;

import java.awt.Color;

import cardgame.mouse.interaction.CardGameMouseAdapter;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel {

	private static final long serialVersionUID = 9066548687077615194L;
	
	private CardGameLogger logger = CardGameLogger.getInstance();
	
	CardGameMouseAdapter mouseListener;
	
	public TestGameBoard() {
		setName(TestGameBoard.class.getName());
		logger.info("TestGameBoard panel created");
		
		mouseListener = new CardGameMouseAdapter();
		initMouseInteractions(mouseListener);
		
		TestCard card = new TestCard();
		add(card);
		setBackground(Color.LIGHT_GRAY);
	}
}
