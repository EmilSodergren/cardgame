/**
 * Created by MrE on 1 okt 2013
 */
package framework.graphics.guicomponents;

import javax.swing.JPanel;

import framework.mouse.EMouseAdapter;

public class EPanel extends JPanel {

	private static final long serialVersionUID = -5019510726621546268L;

	public EPanel() {
		super();
	}
	
	public void initMouseInteractions(EMouseAdapter adapter) {
		super.addMouseListener(adapter);
		super.addMouseMotionListener(adapter);
		super.addMouseWheelListener(adapter);
	}
}
