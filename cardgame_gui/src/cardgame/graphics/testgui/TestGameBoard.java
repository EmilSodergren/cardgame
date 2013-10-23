/**
 * Created by MrE on 1 okt 2013
 */
package cardgame.graphics.testgui;

import java.awt.Color;
import java.awt.Graphics;

import cardgame.mouse.interaction.CardGameMouseAdapter;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel {

	private static final long serialVersionUID = 9066548687077615194L;

	private CardGameLogger logger = new CardGameLogger(TestGameBoard.class);

	private CardGameMouseAdapter mouseListener = new CardGameMouseAdapter();
	
	TestCard tc;

	public TestGameBoard() {
		super();
		tc = new TestCard();
		initComponents();
	}

	private void initComponents() {
		setName(TestGameBoard.class.getName());
		logger.info("TestGameBoard panel created");
		initMouseInteractions(mouseListener);
		setBackground(Color.yellow);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(tc.getImage(), 100, 100, null);
	}
}
