package framework.logging.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CardGameLogger {

	public final static Logger logger = Logger.getLogger(CardGameLogger.class.getName());

	private static CardGameLogger cgLogger;

	private CardGameLogger() {
	}

	public static CardGameLogger getInstance() {
		if (cgLogger == null) {
			cgLogger = new CardGameLogger();
		}
		return cgLogger;
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
		logger.log(lvl, msg);
	}

	public void err(String msg) {
		logger.log(Level.SEVERE, msg);
	}

	public void warn(String msg) {
		logger.log(Level.WARNING, msg);
	}

	public void info(String msg) {
		logger.log(Level.INFO, msg);
	}
}
