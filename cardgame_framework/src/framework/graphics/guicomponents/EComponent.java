/**
 * Created by MrE on 20 okt 2013
 */
package framework.graphics.guicomponents;

import java.awt.Dimension;
import java.awt.Point;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;

import framework.cardgame.mvcbase.abstracts.AbstractView;
import framework.cardgame.mvcbase.interfaces.IViewListener;

public class EComponent extends JComponent implements AbstractView {

	private static final long serialVersionUID = -2596660223403790964L;

	protected IViewListener controller;

	public EComponent() {
	}

	@Override
	public void update(PropertyChangeEvent evt) {
	}

	@Override
	public void addViewListener(IViewListener vl) {
		controller = vl;
	}

	@Override
	public void setDefaults() {
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
