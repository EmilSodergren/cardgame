/**
 * Created by MrE on 29 sep 2013
 */
package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import cardgame.gui.base.CardBase;
import framework.logging.logger.CardGameLogger;

/**
 * 
 */
public class TestCard extends CardBase {

	private static final long serialVersionUID = 7612816210853534664L;
	
	private CardGameLogger logger = CardGameLogger.getInstance();

	public TestCard() {
		super(new Point(30,30), new Dimension(60, 100));
		logger.info("TestCard created");
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			g.setColor(new Color(0xFF0000));
			g.fillRect(getPos().x, getPos().x, getDim().width, getDim().height);
			g.setColor(new Color(0x00FF00));
			g.drawRect(getPos().x, getPos().x, getDim().width, getDim().height);
		} catch (NullPointerException e) {
			System.out.println("CardBase.paint() : The position and dimension is not correctly set!");
			e.fillInStackTrace();
		}
	}
}
