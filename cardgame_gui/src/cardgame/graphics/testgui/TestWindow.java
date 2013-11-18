/**
 * 
 */
package cardgame.graphics.testgui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import framework.graphics.guicomponents.EFrame;
import framework.logging.logger.CardGameLogger;

/**
 * @author MrE
 * 
 */
public class TestWindow extends EFrame {

	private static final long serialVersionUID = 1742936565714076461L;
	
	private CardGameLogger logger = new CardGameLogger(getClass());

	public TestWindow(Dimension resolution) {
		super("TestWindow");
		setName(TestWindow.class.getName());
		logger.info("Main window created");
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width - resolution.width, 0);
		setSize(resolution);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
