package ch.hackaton.apme.views;

import javax.annotation.PostConstruct;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CssLayout;

/**
 * @author apme
 */
@CDIView("provide")
@SuppressWarnings("serial")
public class ProvideContentView extends CssLayout implements View {

    @PostConstruct
    public void initialize() {

        setSizeFull();
    }

    @Override
    public void enter(final ViewChangeEvent event) {

    }
}
