/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.gui.base;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JComponent;

/**
 * @author MrE
 *
 */
public class CardBase extends JComponent {

	private static final long serialVersionUID = 838972446142610186L;
	
	private Point pos;
	private Dimension dim;
	
	public CardBase() {
		this(null, null);
	}
	
	public CardBase(Point position, Dimension dimension) {
		this.pos = position;
		this.dim = dimension;
	}

	public Point getPos() {
		return pos;
	}

	public Dimension getDim() {
		return dim;
	}	
}
