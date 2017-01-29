package ch.hackaton.apme;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or some part of a html page where a Vaadin application
 * is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@CDIUI("login")
@Theme("apme_flat")
@SuppressWarnings("serial")
public class LoginUI extends UI {

    @Inject
    private CDIViewProvider cdiViewProvider;

    @Inject
    private DesignPresenter<DefaultLoginDesign> presenter;

    @PostConstruct
    public void initialize() {

        setContent(this.presenter.getDesign());

        final Navigator navigator = new Navigator(this, this);
        navigator.addProvider(this.cdiViewProvider);
    }

    @Override
    protected void init(final VaadinRequest vaadinRequest) {

    }
}
