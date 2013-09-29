/**
 * 
 */
package cardgame.graphics.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import framework.graphics.guicomponents.EFrame;

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
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TestCard card = new TestCard();
		
		window.add(card);
	}
}
