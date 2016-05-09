package org.vaadin.mvp.vaadinmvp;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class LoginAwareUIProvider extends DefaultUIProvider {

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		return VaadinSession.getCurrent().getAttribute("user") == null ? LoginUI.class : MainUI.class;
	}
	
}
