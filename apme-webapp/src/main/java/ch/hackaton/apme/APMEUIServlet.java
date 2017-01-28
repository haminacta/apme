package ch.hackaton.apme;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.server.VaadinCDIServlet;

@WebServlet(urlPatterns = "/*",
        name = "APMEUIServlet",
        asyncSupported = true)
@VaadinServletConfiguration(ui = APMEUI.class,
        productionMode = false)
public class APMEUIServlet extends VaadinCDIServlet {

}
