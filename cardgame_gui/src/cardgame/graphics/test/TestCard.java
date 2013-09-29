/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import cardgame.graphics.base.CardBase;

/**
 * 
 */
public class TestCard extends CardBase {

	private static final long serialVersionUID = 7612816210853534664L;

	public TestCard() {
		super(new Point(30,30), new Dimension(60, 100));
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			g.setColor(new Color(0xFF0000));
			g.fillRect(pos.x, pos.x, dim.width, dim.height);
			g.setColor(new Color(0x00FF00));
			g.drawRect(pos.x, pos.x, dim.width, dim.height);
		} catch (NullPointerException e) {
			System.out.println("CardBase.paint() : The position and dimension is not correctly set!");
			e.fillInStackTrace();
		}
	}
}
