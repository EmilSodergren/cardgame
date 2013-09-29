/**
 * 
 */
package gui.test;

import java.awt.Dimension;

import gui.base.EFrame;

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
		TestWindow tw = new TestWindow();
		tw.setLocation(1920-800, 0);
		tw.setSize(new Dimension(800, 600));
		tw.setVisible(true);
	}
}
