package framework.logging.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardGameLogger {

	private final static Logger logger = Logger.getLogger(CardGameLogger.class.getName());

	String className;
	String methodName = null;
	
	public CardGameLogger(Class<?> theClass) {
		this.className = theClass.getSimpleName();
	}

	public boolean addHandler(Handler loggerHandler) {
		for (Handler handler : logger.getHandlers()) {
			if (handler.equals(loggerHandler)) {
				return false;
			}
		}
		logger.addHandler(loggerHandler);
		return true;
	}

	public void removeHandler(Handler handler) {
		logger.removeHandler(handler);
	}

	public void log(Level lvl, String msg) {
		logger.logp(lvl, className, methodName, msg);
	}

	public void err(String msg) {
		logger.logp(Level.SEVERE, className, methodName, msg);
	}

	public void warn(String msg) {
		logger.logp(Level.WARNING, className, methodName, msg);
	}

	public void info(String msg) {
		logger.logp(Level.INFO, className, methodName, msg);
	}
	
	public void debug(String msg) {
		logger.logp(Level.FINE, className, methodName, msg);
	}
	
	public void trace(String msg) {
		logger.logp(Level.FINER, className, methodName, msg);
	}
	
	public void setOutStreamLevel(Level level) {
		logger.setLevel(level);
	}
}
