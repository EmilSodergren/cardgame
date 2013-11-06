/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.gui.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;

import framework.graphics.guicomponents.EComponent;
import framework.logging.logger.CardGameLogger;

public abstract class CardGuiBase extends EComponent {

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
	
	public abstract BufferedImage getImageWithPath(String imagePath);
	
	/**
	 * 
	 * MOUSE INTERACTIONS
	 * 
	 */
	public void mouseMoved(MouseEvent e) {
		if (!e.isConsumed()) {
			boolean isHit = this.contains(e.getPoint());
			controller.onViewEvent("Focused", Boolean.valueOf(isHit));
			if (isHit) {
				e.consume();
			}
		} else {
			controller.onViewEvent("Focused", Boolean.FALSE);
		}
	}
	
	// MouseDragging is overriding MVC to make the card follow the mouse without messing with the model
	
	// TODO: Maybe override Point to get an offsetWith method 
	public void mouseDragging(MouseEvent e) {
		if (!isDragging) {
			mouseOffset = new Point(e.getX() - getLocation().x, e.getY() - getLocation().y);
		}
		if (focused) {
			isDragging = Boolean.TRUE;
			setLocation(e.getPoint().x - mouseOffset.x, e.getPoint().y - mouseOffset.y);
		}
	}
	// update the position in the model and let the card react to the position change
	public void mouseReleased(MouseEvent e) {
		if (isDragging) {
			controller.onViewEvent("Pos", new Point(e.getPoint().x - mouseOffset.x, e.getPoint().y - mouseOffset.y));
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
}
