/**
 * 
 */
package test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import cardgame.logging.gui.LoggerWindow;
import framework.graphics.guicomponents.EFrame;

/**
 * @author MrE
 *
 */
public class TestWindow extends EFrame {

	private static final long serialVersionUID = 1742936565714076461L;

	
	public TestWindow() {
		super("TestWindow");
		setName(TestWindow.class.getName());
		
		new LoggerWindow();
		
	}
	
	
	public static void main(String[] args) {
		TestWindow window = new TestWindow();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(screenSize.width-800, 0);
		window.setSize(new Dimension(800, 600));
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TestCard card = new TestCard();
		
		window.add(card);
	}
}
