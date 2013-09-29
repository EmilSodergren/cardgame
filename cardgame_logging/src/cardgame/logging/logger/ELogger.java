/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;

public class ELogger {

	Logger logger = Logger.getLogger(ELogger.class.getName());
	
	public ELogger(JTextArea textArea) {
		logger.addHandler(new TextAreaHandler(textArea));
	}
	
	public void log(Level lvl, String msg) {
		logger.log(lvl, msg);
	}
	
	

}
