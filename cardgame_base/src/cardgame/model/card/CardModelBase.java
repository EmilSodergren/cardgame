/**
 * Created by MrE on 20 okt 2013
 */
package cardgame.model.card;

import java.awt.Dimension;
import java.awt.Point;

import framework.cardgame.mvcbase.abstracts.AbstractModel;

public class CardModelBase extends AbstractModel{

	private Point pos;
	private Dimension size;

	public CardModelBase() {
	}

	public CardModelBase(Point position, Dimension size) {
		this.pos = position;
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
}
