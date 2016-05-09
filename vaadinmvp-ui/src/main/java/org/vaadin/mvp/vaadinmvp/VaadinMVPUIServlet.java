package org.vaadin.mvp.vaadinmvp;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/*", name = "VaadinMVPUIServlet", asyncSupported = true, initParams = {@WebInitParam(name = "UIProvider", value = "org.vaadin.mvp.vaadinmvp.LoginAwareUIProvider")})
@VaadinServletConfiguration(ui = LoginUI.class, productionMode = false, widgetset = "org.vaadin.mvp.vaadinmvp.VaadinMVPAppWidgetset")
public class VaadinMVPUIServlet extends VaadinServlet {
}