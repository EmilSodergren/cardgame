/**
 * Created by MrE on 12 nov 2013
 */
package cardgame.model.gameboard;

import java.awt.Dimension;
import java.awt.Point;

import framework.cardgame.mvcbase.abstracts.AbstractModel;

public class SnapAreaModel extends AbstractModel {
	
	Point pos;
	Dimension size;
	Boolean onTarget;
	Boolean occupied;
	String correctPath;
	String wrongPath;
	
	public void setPos(Point newPos) {
		Point oldPos = pos;
		pos = newPos;
		firePropertyChange("pos", oldPos, pos);
	}
	
	public void setSize(Dimension newSize) {
		Dimension oldSize = size;
		size = newSize;
		firePropertyChange("size", oldSize, size);
	}
	
	public void setOccupied(Boolean newOccupied) {
		Boolean oldOccupied = occupied;
		occupied = newOccupied;
		firePropertyChange("occupied", oldOccupied, occupied);
	}
	
	public void setOnTarget(Boolean newOnTarget) {
		Boolean oldOnTarget = onTarget;
		onTarget = newOnTarget;
		firePropertyChange("onTarget", oldOnTarget, onTarget);
	}
	
	public void setCorrectPath(String newCorrectPath) {
		String oldCorrectPath = correctPath;
		correctPath = newCorrectPath;
		firePropertyChange("correctPath", oldCorrectPath, correctPath);
	}

	public void setWrongPath(String newWrongPath) {
		String oldWrongPath = wrongPath;
		wrongPath = newWrongPath;
		firePropertyChange("wrongPath", oldWrongPath, wrongPath);
	}
}
