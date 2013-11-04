/**
 * Created by MrE on 10 okt 2013
 */
package framework.cardgame.mvcbase.abstracts;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

import framework.logging.logger.CardGameLogger;

public abstract class AbstractModel {
	
	protected static final Logger logger = Logger.getLogger(CardGameLogger.class.getName());

	protected PropertyChangeSupport propertyChangeSupport;

	public AbstractModel() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
		logger.logp(Level.FINE, AbstractModel.class.getSimpleName(), "firePropertyChange", "firePropertyChange");
	}
}
