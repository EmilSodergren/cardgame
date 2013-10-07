/**
 * Created by MrE on 1 okt 2013
 */
package cardgame.mouse.interaction;

import java.awt.event.MouseEvent;

import framework.logging.logger.CardGameLogger;
import framework.mouse.EMouseAdapter;

public class CardGameMouseAdapter extends EMouseAdapter {
	
	private CardGameLogger logger = new CardGameLogger(getClass());
	
	public CardGameMouseAdapter() {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		logger.trace(e.getPoint().toString());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		logger.trace(e.getPoint().toString());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		logger.trace("Out of window");
	}
}
