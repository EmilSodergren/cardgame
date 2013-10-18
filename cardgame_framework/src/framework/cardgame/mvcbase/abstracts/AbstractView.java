/**
 * Created by MrE on 10 okt 2013
 */
package framework.cardgame.mvcbase.abstracts;

import java.beans.PropertyChangeEvent;

import framework.cardgame.mvcbase.interfaces.IViewListener;

public interface AbstractView {

	/**
	 * The update method is used to forward the <code>PropertyChangeEvent</code> events occurring
	 * in the model to the view. 
	 * @param evt
	 */
	public void update(PropertyChangeEvent evt);
	
	public void addViewListener(IViewListener vl);
}
