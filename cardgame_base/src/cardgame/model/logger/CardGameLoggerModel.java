/**
 * Created by MrE on 2 okt 2013
 */
package cardgame.model.logger;

import java.util.logging.Level;

public class CardGameLoggerModel {
	
	private Level level; 
	
	public CardGameLoggerModel() {
		level = Level.OFF;
	}
	
	public void setLevel(Level l) {
		level = l;
	}
	
	public Level getLevel() {
		return level;
	}
}
