/**
 * Created by MrE on 2 okt 2013
 */
package cardgame.model.logger;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Handler;
import java.util.logging.Level;

public class CardGameLoggerModel {
	
	private Level level;
	private Handler loggerHandler;
	private PropertyChangeSupport pcs;
	
	public CardGameLoggerModel() {
		level = Level.OFF;
		pcs = new PropertyChangeSupport(this.level);
	}
	
	public void setLevel(Level l) {
		level = l;
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
	
	public void addLoggerModelListener(PropertyChangeListener pce) {
		pcs.addPropertyChangeListener(pce);
	}
}
