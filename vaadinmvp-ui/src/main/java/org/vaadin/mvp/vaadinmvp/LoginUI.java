package org.vaadin.mvp.vaadinmvp;

import org.vaadin.mvp.vaadinmvp.samples.authentication.AccessControl;
import org.vaadin.mvp.vaadinmvp.samples.authentication.BasicAccessControl;
import org.vaadin.mvp.vaadinmvp.samples.authentication.LoginScreen;
import org.vaadin.mvp.vaadinmvp.samples.authentication.LoginScreen.LoginListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@Viewport("user-scalable=no,initial-scale=1.0")
@Theme("vaadinmvptheme")
@Title("LoginUI")
@SuppressWarnings("serial")
public class LoginUI extends UI {

	private AccessControl accessControl = new BasicAccessControl();

	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		setLocale(request.getLocale());
		setContent(new LoginScreen(accessControl, new LoginListener() {
			@Override
			public void loginSuccessful() {
				VaadinSession.getCurrent().setAttribute("user", accessControl.getPrincipalName());
				Page.getCurrent().reload();
			}
		}));
	}

}
