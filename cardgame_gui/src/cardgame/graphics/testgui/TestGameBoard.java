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
import cardgame.graphics.controller.SnapAreaController;
import cardgame.gui.base.CardGuiBase;
import cardgame.gui.base.SnapAreaGuiBase;
import cardgame.model.cards.CardModelBase;
import cardgame.model.gameboard.SnapAreaModel;
import framework.graphics.guicomponents.EPanel;
import framework.logging.logger.CardGameLogger;

public class TestGameBoard extends EPanel implements MouseListener, MouseMotionListener { //, MouseWheelListener {

	private static final long serialVersionUID = 9066548687077615194L;
	private CardGameLogger logger = new CardGameLogger(TestGameBoard.class);
	
	private Image boardImage;
	private ArrayList<CardGuiBase> cards;
	private ArrayList<SnapAreaGuiBase> snapAreas;
	
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
		if (snapAreas != null) {
			for (SnapAreaGuiBase snapArea : snapAreas) {
				snapArea.paint(g);
			}
		}
		if (cards != null) { // cards are painted backwards since the last card will be on top
			for (int i = cards.size() ; i > 0 ; i--) {
				CardGuiBase card = cards.get(i-1);
				card.paint(g);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
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
				logger.err(String.format("The file on path: %s can not be found by %s!", filePath, getClass()));
			}
		} else
		if (evt.getPropertyName().equalsIgnoreCase("Cards")) {
			cards = (ArrayList<CardGuiBase>) evt.getNewValue();
			for (CardGuiBase card : cards) {
				new CardController(new CardModelBase(), card);
			}
		}
		if (evt.getPropertyName().equalsIgnoreCase("SnapAreas")) {
			snapAreas = (ArrayList<SnapAreaGuiBase>) evt.getNewValue();
			for (SnapAreaGuiBase snapArea : snapAreas) {
				new SnapAreaController(new SnapAreaModel(), snapArea);
			}
		}
	}
	
	@Override
	public void setDefaults() {
		super.setDefaults();
		controller.onViewEvent("BoardImage", "cardgame/graphics/resources/background_small.png");
		
		ArrayList<CardGuiBase> cards = new ArrayList<CardGuiBase>();
		cards.add(new TestCard());
		cards.add(new TestCardV2());
		controller.onViewEvent("Cards", cards);
		
		ArrayList<SnapAreaGuiBase> snapAreas = new ArrayList<SnapAreaGuiBase>();
		snapAreas.add(new TestSnapArea(new Point(100,100)));
		snapAreas.add(new TestSnapArea(new Point(100,320)));
		snapAreas.add(new TestSnapArea(new Point(580,100)));
		snapAreas.add(new TestSnapArea(new Point(580,320)));
		controller.onViewEvent("SnapAreas", snapAreas);
	}
	
	/**
	 * 
	 * MOUSE INTERACTIONS
	 * 
	 */
	
	private void initMouseListeners() {
		super.addMouseListener(this);
		super.addMouseMotionListener(this);
//		super.addMouseWheelListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		logger.trace("mouseDragged: " + e.getPoint().toString());
		if (cards != null) {
			for (CardGuiBase card : cards) {
				card.doDrag(e);
			}
		} else {
			logger.warn("The  cards  parameter is null!");
		}
		if (snapAreas != null) {
			for (SnapAreaGuiBase snapArea: snapAreas) {
				snapArea.doDrag(e);
			}
		} else {
			logger.warn("The  snapAreas  parameter is null!");
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
		for (SnapAreaGuiBase snapArea : snapAreas) {
			snapArea.doRelease(e);
		}
		repaint();
		logger.debug("mouseReleased: " + e.getPoint().toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {
		logger.trace("Out of window");
	}
}
