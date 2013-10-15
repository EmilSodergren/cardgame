/**
 * Created by MrE on 10 okt 2013
 */
package framework.cardgame.mvcbase;

import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;

public class AbstractView extends JComponent {

	private static final long serialVersionUID = -6020340794725165604L;

	public void addModelListener(AbstractView view) {
		
	}
	
	public void update(PropertyChangeEvent evt){
		
	}
}
