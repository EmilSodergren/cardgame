/**
 * Created by MrE on 29 sep 2013
 */
package cardgame.logging.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextAreaHandler extends Handler {

	JTextArea textArea;

	public TextAreaHandler(JTextArea textArea) {
		this.textArea = textArea;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void publish(final LogRecord record) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				StringWriter text = new StringWriter();
				PrintWriter out = new PrintWriter(text);
				out.println(textArea.getText());
				out.printf("[%s] [Thread-%d] %s: -> %s", record.getLevel(), record.getThreadID(), record.getSourceClassName(), record.getMessage());
				textArea.setText(text.toString());
			}
		});
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() throws SecurityException {
	}
}
