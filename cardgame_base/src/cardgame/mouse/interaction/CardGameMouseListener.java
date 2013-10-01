/**
 * Created by MrE on 1 okt 2013
 */
package cardgame.mouse.interaction;

import java.awt.event.MouseEvent;

import framework.logging.logger.CardGameLogger;
import framework.mouse.EMouseAdapter;

public class CardGameMouseListener extends EMouseAdapter {
	
	CardGameLogger logger = CardGameLogger.getInstance();
	
	public CardGameMouseListener() {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("HEJ!");
		logger.info(e.getPoint().toString());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("HEJ!");
		logger.info(e.getPoint().toString());
	}
}
