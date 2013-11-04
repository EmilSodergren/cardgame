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
		controller.onViewEvent("Focused", Boolean.valueOf(this.contains(e.getPoint())));
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
