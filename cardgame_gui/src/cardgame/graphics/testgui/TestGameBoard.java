/**
 * Created by MrE on 1 okt 2013
 */
package cardgame.graphics.testgui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import cardgame.cards.controller.CardController;
import cardgame.gui.base.CardGuiBase;
import cardgame.model.cards.CardModelBase;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel implements MouseListener, MouseMotionListener { //, MouseWheelListener {

	private static final long serialVersionUID = 9066548687077615194L;
	private CardGameLogger logger = new CardGameLogger(TestGameBoard.class);
	
	private Image boardImage;
	private ArrayList<CardGuiBase> cards;
	
	public TestGameBoard() {
		super();
		setName(TestGameBoard.class.getName());
		initMouseListeners();
		
		this.setVisible(true);
		logger.info("TestGameBoard panel created");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(boardImage, 0, 0, null);
		if (cards != null) { // cards are painted backwards since the last card will be on top
			for (int i = cards.size() ; i > 0 ; i--) {
				CardGuiBase card = cards.get(i-1);
				card.paint(g);
			}
		}
	}
	
	@Override
	public void update(PropertyChangeEvent evt) {
		super.update(evt);
		if (evt.getPropertyName().equalsIgnoreCase("BoardImage")) {
			String filePath = (String) evt.getNewValue();
			try {
				boardImage = ImageIO.read(CardGuiBase.class.getClassLoader().getResource(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				logger.err(String.format("The file on path: %s can not be found!", filePath));
			}
		} else
		if (evt.getPropertyName().equalsIgnoreCase("Cards")) {
			cards = (ArrayList<CardGuiBase>) evt.getNewValue();
			for (CardGuiBase card : cards) {
				new CardController(new CardModelBase(), card);
			}
		}
	}
	
	@Override
	public void setDefaults() {
		super.setDefaults();
		controller.onViewEvent("BoardImage", "cardgame/graphics/resources/background-small.png");
		ArrayList<CardGuiBase> cards = new ArrayList<CardGuiBase>();
		cards.add(new TestCard());
		cards.add(new TestCardV2());
		controller.onViewEvent("Cards", cards);
	}
	
	/**
	 * 
	 * MOUSE INTERACTIONS
	 * 
	 */
	
	private void initMouseListeners() {
		super.addMouseListener(this);
		super.addMouseMotionListener(this);
//		super.addMouseWheelListener(adapter);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		logger.trace("mouseDragged: " + e.getPoint().toString());
		if (this.contains(e.getPoint())) {
			for (CardGuiBase card : cards) {
				card.mouseDragging(e);
			}
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Point currPoint = e.getPoint();
		logger.trace(currPoint.toString());
		if (cards != null) {
			for (CardGuiBase card : cards) {
				card.mouseMoved(e);
			}
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		logger.debug("mouseClicked: " + e.getPoint().toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		logger.debug("mousePressed: " + e.getPoint().toString());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (CardGuiBase card : cards) {
			card.mouseReleased(e);
		}
		logger.debug("mouseReleased: " + e.getPoint().toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {
		logger.trace("Out of window");
	}
}
