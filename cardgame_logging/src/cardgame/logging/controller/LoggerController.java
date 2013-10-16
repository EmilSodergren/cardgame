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
import framework.logging.logger.CardGameLogger;

public class LoggerController {
	
	LoggerWindow view;
	CardGameLogger model;
	
	public LoggerController(LoggerWindow view, CardGameLogger model) {
		this.view = view;
		this.model = model;
		
		view.addLevelChangerListener(new LoggerLevelChanger());
		model.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("This Is Awesome!!! " + evt.getPropertyName());	
			}
		});
	}
	
	private class LoggerLevelChanger implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Setting Off in Model");
			model.setLevel(Level.FINER);
		}
	}
}
