/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.model.cards;

import java.awt.Dimension;
import java.awt.Point;

import framework.cardgame.mvcbase.abstracts.AbstractModel;

public class CardModelBase extends AbstractModel {

	private Point pos;
	private Dimension size;
	private String mainImagePath;
	private String glowImagePath;
	private Boolean focused;

	public CardModelBase() {
	}
	
	public CardModelBase(Point position, Dimension size) {
		this.setPos(position);
		this.setSize(size);
	}

	public void setPos(Point newPos) {
		Point oldPos = pos;
		pos = newPos;
		propertyChangeSupport.firePropertyChange("pos", oldPos, pos);
	}
	
	public void setSize(Dimension newSize) {
		Dimension oldSize = size;
		size = newSize;
		propertyChangeSupport.firePropertyChange("size", oldSize, size);
	}

	public void setMainImagePath(String newMainImagePath) {
		String oldMainImagePath = mainImagePath;
		mainImagePath = newMainImagePath;
		propertyChangeSupport.firePropertyChange("mainImagePath", oldMainImagePath, mainImagePath);
	}

	public void setGlowImagePath(String newGlowImagePath) {
		String oldGlowImagePath = glowImagePath;
		glowImagePath = newGlowImagePath;
		propertyChangeSupport.firePropertyChange("glowImagePath", oldGlowImagePath, glowImagePath);
	}
	
	public void setFocused(Boolean newFocused) {
		Boolean oldFocused = focused;
		focused = newFocused;
		propertyChangeSupport.firePropertyChange("focused", oldFocused, focused);
	}
}
