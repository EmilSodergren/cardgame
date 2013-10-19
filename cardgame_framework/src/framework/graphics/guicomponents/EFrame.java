/**
 * 
 */
package framework.graphics.guicomponents;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;

import framework.cardgame.mvcbase.abstracts.AbstractView;
import framework.cardgame.mvcbase.interfaces.IViewListener;

/**
 * @author MrE
 *
 */
public abstract class EFrame extends JFrame implements AbstractView {

	private static final long serialVersionUID = 5143544822454599810L;
	
	protected IViewListener controller;
	
	protected EFrame() {
		super();
	}
	
	protected EFrame(String s) {
		super(s);
	}
	
	/**
	 * 
	  * {@inheritDoc}
	  * 
	  * Override it if you have the PropertyChangeEvent.
	 */
	@Override
	public void update(PropertyChangeEvent evt) {
		// Don't do anything
	}

	@Override
	public void addViewListener(IViewListener vl) {
		controller = vl;
	}
	
	public void setDefaults() {
		// Don't do anything
	}
}
