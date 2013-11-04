/**
 * Created by MrE on 20 okt 2013
 */
package framework.graphics.guicomponents;

import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;

import framework.cardgame.mvcbase.abstracts.AbstractView;
import framework.cardgame.mvcbase.interfaces.IViewListener;

public class EComponent extends JComponent implements AbstractView {

	private static final long serialVersionUID = -2596660223403790964L;

	protected IViewListener controller;

	public EComponent() {
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
