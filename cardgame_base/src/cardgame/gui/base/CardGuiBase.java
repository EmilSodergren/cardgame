/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.gui.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;

import cardgame.common.CommonConstants;
import framework.logging.logger.CardGameLogger;

public abstract class CardGuiBase extends CardGameImageComponent {

	private static final long serialVersionUID = 5322618823703871299L;
	
	private CardGameLogger logger = new CardGameLogger(CardGuiBase.class);

	private Image mainImage;
	private Image glowImage;
	private Boolean focused = Boolean.FALSE;
	private Boolean isDragging = Boolean.FALSE;
	
	private Point mouseOffset;
	
	public CardGuiBase() {
		super();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (mainImage != null && getLocation() != null && getSize() != null) {
			g.drawImage(mainImage, getLocation().x, getLocation().y, getSize().width, getSize().height, null);
			if (glowImage != null) {
				if (focused) {
					g.drawImage(glowImage, getLocation().x, getLocation().y, getSize().width, getSize().height, null);
				}
			}
		}
	}
	
	@Override
	public void update(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equalsIgnoreCase("pos")) {
			setLocation((Point) evt.getNewValue());
		} else
		if (evt.getPropertyName().equalsIgnoreCase("size")) {
			setSize((Dimension) evt.getNewValue());
		} else
		if (evt.getPropertyName().equalsIgnoreCase("focused")) {
			focused = (Boolean) evt.getNewValue();
			logger.debug("Focus changed to " + focused);
		} else
		if (evt.getPropertyName().equalsIgnoreCase("mainImagePath")) {
			String imagePath = (String) evt.getNewValue();
			mainImage = getImageWithPath(imagePath);
		} else
		if (evt.getPropertyName().equalsIgnoreCase("glowImagePath")) {
			String imagePath = (String) evt.getNewValue();
			glowImage = getImageWithPath(imagePath);
		}
	}
	
	/**
	 * 
	 * MOUSE INTERACTIONS
	 * 
	 */
	public void mouseMoved(MouseEvent e) {
		if (!e.isConsumed()) { // check isConsumed() to only allow top card to trigger "Focused" 
			boolean isHit = this.contains(e.getPoint());
			controller.onViewEvent("Focused", Boolean.valueOf(isHit));
			if (isHit) {
				e.consume();
			}
		} else {
			controller.onViewEvent("Focused", Boolean.FALSE);
		}
	}
	
	
	
	// TODO: Maybe override Point to get an offsetWith method 
	public void doDrag(MouseEvent e) {
		if (focused) {
			if (!isDragging) {
				mouseOffset = new Point(e.getX() - getLocation().x, e.getY() - getLocation().y);
			}
			isDragging = Boolean.TRUE;
			// MouseDragging is overriding MVC to make the card follow the mouse without messing with the model
			setLocation(e.getPoint().x - mouseOffset.x, e.getPoint().y - mouseOffset.y);
		}
	}

	// update the position in the model and let the card react to the position change
	public void mouseReleased(MouseEvent e) {
		if (isDragging) {
			controller.onViewEvent("Pos", confineToRectangle(e.getPoint().x - mouseOffset.x, e.getPoint().y - mouseOffset.y, CommonConstants.CARD_LIMIT_RECTANGLE));
			isDragging = Boolean.FALSE;
		}
	}
	
	// TODO: Not memory efficient!!! This method will be triggered very often.
	// Rewrite with local variables or something!
	@Override
	public boolean contains(Point currPoint) {
		Point pos = getLocation();
		Dimension size = getSize();
		if ((currPoint.x > pos.x) && (currPoint.x < pos.x + size.width) && 
		    (currPoint.y > pos.y) && (currPoint.y < pos.y + size.height)) {
			return true;
		}
		return false;
	}
	
	private Point confineToRectangle(int x, int y, Rectangle r) {
		int newX, newY;
		
		// Make sure x is within the rectangle r
		if (x < r.x) {
			newX = r.x;
		} else
		if (x > r.width) {
			newX = r.width;
		} else {
			newX = x;
		}
		
		// Make sure y is within the rectangle r
		if (y < r.y) {
			newY = r.y;
		} else
		if (y > r.height) {
			newY = r.height;
		} else {
			newY = y;
		}
		
		return new Point(newX,newY);
	}
}
