/**
 * Created by MrE on 18 nov 2013
 */
package cardgame.gui.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;

import framework.logging.logger.CardGameLogger;

public class SnapAreaGuiBase extends CardGameImageComponent {

	private static final long serialVersionUID = -6198185426946497951L;
	
	private CardGameLogger logger = new CardGameLogger(SnapAreaGuiBase.class);
	
	private Boolean isOnTarget;
	private Boolean isOccupied;
	private Image correctImage;
	private Image wrongImage;
	
	public SnapAreaGuiBase(Point pos) {
		super();
		setLocation(pos); // temporary storage of position in local 'Location' to be used when setting up defaults
	}
	
	@Override
	public void update(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equalsIgnoreCase("pos")) {
			setLocation((Point) evt.getNewValue());
		} else
		if (evt.getPropertyName().equalsIgnoreCase("size")) {
			setSize((Dimension) evt.getNewValue());
		} else
		if (evt.getPropertyName().equalsIgnoreCase("occupied")) {
			isOccupied = (Boolean) evt.getNewValue();
			logger.debug("Occupied changed to " + isOccupied);
		} else
		if (evt.getPropertyName().equalsIgnoreCase("onTarget")) {
			isOnTarget = (Boolean) evt.getNewValue();
			logger.debug("OnTarget changed to " + isOnTarget);
		} else
		if (evt.getPropertyName().equalsIgnoreCase("correctPath")) {
			String imagePath = (String) evt.getNewValue();
			correctImage = getImageWithPath(imagePath);
		} else
		if (evt.getPropertyName().equalsIgnoreCase("wrongPath")) {
			String imagePath = (String) evt.getNewValue();
			wrongImage = getImageWithPath(imagePath);
		}
	}
	
	public void doDrag(MouseEvent e) {
		controller.onViewEvent("OnTarget", Boolean.valueOf(this.contains(e.getPoint())));
	}
	
	public void doRelease(MouseEvent e) {
		controller.onViewEvent("Occupied", this.contains(e.getPoint()));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if( isOnTarget != null && 
		    isOccupied != null && 
		    correctImage != null && 
		    wrongImage != null) {
			if (!isOccupied) {
				g.drawImage(correctImage, getLocation().x, getLocation().y, getSize().width, getSize().height, null);
			} else 
			if (isOnTarget) {
				g.drawImage(wrongImage, getLocation().x, getLocation().y, getSize().width, getSize().height, null);
			}
		}
	}
}
