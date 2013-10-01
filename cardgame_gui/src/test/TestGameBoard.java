/**
 * Created by MrE on 1 okt 2013
 */
package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import cardgame.mouse.interaction.CardGameMouseListener;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends JPanel {

	private static final long serialVersionUID = 9066548687077615194L;
	
	private CardGameLogger logger = CardGameLogger.getInstance();
	
	CardGameMouseListener mouseListener;
	
	public TestGameBoard() {
		setName(TestGameBoard.class.getName());
		logger.info("TestGameBoard panel created");
		setLayout(new BorderLayout());
		
		mouseListener = new CardGameMouseListener();
		addMouseListener(mouseListener);
		
		TestCard card = new TestCard();
		add(card);
		setBackground(Color.LIGHT_GRAY);
	}
}
