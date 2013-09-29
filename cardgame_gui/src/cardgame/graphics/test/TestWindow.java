/**
 * 
 */
package cardgame.graphics.test;

import java.awt.Dimension;

import cardgame.graphics.base.EFrame;
import cardgame.graphics.gui.Card;

/**
 * @author MrE
 *
 */
public class TestWindow extends EFrame {

	private static final long serialVersionUID = 1742936565714076461L;

	
	public TestWindow() {
		super("TestWindow");
	}
	
	
	public static void main(String[] args) {
		TestWindow window = new TestWindow();
		window.setLocation(1920-800, 0);
		window.setSize(new Dimension(800, 600));
		window.setVisible(true);
		
		Card card = new Card();
		
		window.add(card);
	}
}
