package ch.hackaton.apme;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author apme
 *
 */
@CDIUI("")
@Theme("apme_flat")
@SuppressWarnings("serial")
public class PublicUI extends UI {

    @Inject
    private CDIViewProvider cdiViewProvider;

    @PostConstruct
    public void initialize() {

        final Navigator navigator = new Navigator(this, this);
        navigator.addProvider(this.cdiViewProvider);
    }

    @Override
    protected void init(final VaadinRequest request) {

        if (request.getUserPrincipal() != null) {
            Page.getCurrent().setLocation("./app");
        } else {
            Page.getCurrent().setLocation("./login");
        }
    }
}
