package org.vaadin.test;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.AbstractComponent;

public class AbstractComponentTestView extends AbstractComponent {
	private void init(AbstractComponent abstractComponent) {
		AbstractComponent abstractComponent1 = new AbstractComponent() {
		};

		AbstractComponent abstractComponent2 = (AbstractComponent) this;
		Class<AbstractComponent> type = AbstractComponent.class;
		if(this instanceof AbstractComponent) {
		}
		if(this.getClass().isAssignableFrom(AbstractComponent.class)) {
		}
		List<AbstractComponent> list = new ArrayList<AbstractComponent>();
	}
	public AbstractComponentTestView() {
	}
}