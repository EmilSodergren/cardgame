/**
 * Created by MrE on 2 okt 2013
 */
package cardgame.model.logger;

import java.beans.PropertyChangeEvent;
import java.util.logging.Handler;
import java.util.logging.Level;

import framework.cardgame.mvcbase.abstracts.AbstractModel;
import framework.logging.logger.CardGameLogger;

public class CardGameLoggerModel extends AbstractModel {
	
	private Level level;
	private Handler loggerHandler;
	CardGameLogger logger = new CardGameLogger(CardGameLoggerModel.class);
	
	public CardGameLoggerModel() {
		super();
		level = Level.OFF;
	}
	
	public void setLevel(Level newLevel) {
		Level oldValue = level;
		level = newLevel;
		PropertyChangeEvent pce = new PropertyChangeEvent(this, "level", oldValue, level);
		propertyChangeSupport.firePropertyChange(pce);
	}
	
	public Level getLevel() {
		return level;
	}

	public Handler getLoggerHandler() {
		return loggerHandler;
	}

	public void setLoggerHandler(Handler loggerHandler) {
		this.loggerHandler = loggerHandler;
	}
}
