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
	private boolean focused;

	public CardModelBase() {
	}

	public CardModelBase(Point position, Dimension size) {
		this.setPos(position);
		this.setSize(size);
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public boolean isFocused() {
		return focused;
	}

	public void setFocused(boolean focused) {
		this.focused = focused;
	}
}
