/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.gui;

import java.awt.Dimension;
import java.awt.Point;

import cardgame.graphics.base.CardBase;

/**
 * 
 */
public class Card extends CardBase {

	private static final long serialVersionUID = 7612816210853534664L;

	public Card() {
		super(new Point(30,30), new Dimension(60, 100));
	}
}
