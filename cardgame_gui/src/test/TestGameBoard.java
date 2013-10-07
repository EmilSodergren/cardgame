/**
 * Created by MrE on 1 okt 2013
 */
package test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.border.BevelBorder;

import cardgame.mouse.interaction.CardGameMouseAdapter;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel {

	private static final long serialVersionUID = 9066548687077615194L;
	
	private CardGameLogger logger = new CardGameLogger(getClass());
	
	CardGameMouseAdapter mouseListener;
	
	public TestGameBoard() {
		setName(TestGameBoard.class.getName());
		logger.info("TestGameBoard panel created");
		setLayout(new BorderLayout());
		setBorder(new BevelBorder(BevelBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
		
		mouseListener = new CardGameMouseAdapter();
		initMouseInteractions(mouseListener);
		
		TestCard card = new TestCard();
		add(card);
		
	}
}
