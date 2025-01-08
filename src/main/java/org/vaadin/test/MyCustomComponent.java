package org.vaadin.test;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

public class MyCustomComponent extends CustomComponent {

    public MyCustomComponent() {
        setCompositionRoot(new Label("Foo"));
    }

    public Component getRoot() {
        return getCompositionRoot();
    }
}
