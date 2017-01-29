package ch.hackaton.apme.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

import ch.hackaton.apme.DesignPresenter;

/**
 * @author apme
 */
@CDIView("search")
@SuppressWarnings("serial")
public class SearchContentView extends VerticalLayout implements View {

    @Inject
    private DesignPresenter<DefaultSearchContentDesign> presenter;

    @PostConstruct
    public void initialize() {

        setSizeFull();

        addComponent(this.presenter.getDesign());
    }

    @Override
    public void enter(final ViewChangeEvent event) {

    }
}
