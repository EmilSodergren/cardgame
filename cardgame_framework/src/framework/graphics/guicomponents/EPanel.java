/**
 * Created by MrE on 1 okt 2013
 */
package framework.graphics.guicomponents;

import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;

import framework.cardgame.mvcbase.abstracts.AbstractView;
import framework.cardgame.mvcbase.interfaces.IViewListener;
import framework.mouse.EMouseAdapter;

public class EPanel extends JPanel implements AbstractView{

	private static final long serialVersionUID = -5019510726621546268L;

	protected IViewListener controller;
	
	public EPanel() {
		super();
	}
	
	public void initMouseInteractions(EMouseAdapter adapter) {
		super.addMouseListener(adapter);
		super.addMouseMotionListener(adapter);
		super.addMouseWheelListener(adapter);
	}

	@Override
	public void update(PropertyChangeEvent evt) {
	}

	@Override
	public void addViewListener(IViewListener vl) {
		controller = vl;
	}

	@Override
	public void setDefaults() {
	}
}
