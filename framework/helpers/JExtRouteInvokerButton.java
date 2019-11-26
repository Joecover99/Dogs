package helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstracts.Controller.Verb;
import interfaces.IModel;

/**
 * Create a button that, when clicked, will invoke a route interpreted by the given controller and the given verb, with the given argument.
 * This element act like an href.
 * @author Benjamin Bergeron
 */
public class JExtRouteInvokerButton extends JExtButton {
	
	public JExtRouteInvokerButton(String label, Class<?> controllerClass, Verb verb) {
		this(label, controllerClass, verb, null);
	}
	
	public JExtRouteInvokerButton(String label, Class<?> controllerClass, Verb verb, IModel argument) {
		super(label, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationRouting.invoke(controllerClass, verb, argument);
			}
		});
	}
}