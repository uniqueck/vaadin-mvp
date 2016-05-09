package org.vaadin.mvp.vaadinmvp;

import org.vaadin.mvp.vaadinmvp.samples.MainScreen;
import org.vaadin.mvp.vaadinmvp.samples.authentication.AccessControl;
import org.vaadin.mvp.vaadinmvp.samples.authentication.BasicAccessControl;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Main UI class of the application that shows either the login screen or the
 * main view of the application depending on whether a user is signed in.
 *
 * The @Viewport annotation configures the viewport meta tags appropriately on
 * mobile devices. Instead of device based scaling (default), using responsive
 * layouts.
 */
@SuppressWarnings("serial")
@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("vaadinmvptheme")
@Title("MainUI")
public class MainUI extends UI {

	private AccessControl accessControl = new BasicAccessControl();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		Responsive.makeResponsive(this);
		setLocale(vaadinRequest.getLocale());
		addStyleName(ValoTheme.UI_WITH_MENU);
		setContent(new MainScreen(MainUI.this));
		getNavigator().navigateTo(getNavigator().getState());
	}

	public static MainUI get() {
		return (MainUI) UI.getCurrent();
	}

	public AccessControl getAccessControl() {
		return accessControl;
	}

}
