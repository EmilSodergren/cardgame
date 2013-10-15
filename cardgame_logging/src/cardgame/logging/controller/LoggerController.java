/**
 * Created by MrE on 15 okt 2013
 */
package cardgame.logging.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;

import cardgame.logging.gui.LoggerWindow;
import cardgame.model.logger.CardGameLoggerModel;

public class LoggerController {
	
	LoggerWindow view;
	CardGameLoggerModel model;
	
	public LoggerController(LoggerWindow view, CardGameLoggerModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addLevelChangerListener(new LoggerLevelChanger());
		this.model.addLoggerModelListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("This Is Awesome!!! " + evt.getPropertyName());
				
			}
		});
	}
	
	public class LoggerLevelChanger implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Setting Off in Model");
			model.setLevel(Level.OFF);
		}
	}
}
