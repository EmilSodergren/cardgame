/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.graphics.base;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

/**
 * @author MrE
 *
 */
public class CardBase extends JComponent {

	private static final long serialVersionUID = 838972446142610186L;
	
	Point pos;
	Dimension dim;
	
	public CardBase() {
		this(null, null);
	}
	
	public CardBase(Point position, Dimension dimension) {
		this.pos = position;
		this.dim = dimension;
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			g.drawRect(pos.x, pos.x, dim.width, dim.height);
		} catch (NullPointerException e) {
			System.out.println("CardBase.paint() : The position and dimension is not correctly set!");
			e.fillInStackTrace();
		}
	}

}
