package ch.hackaton.apme.views;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;

import com.vaadin.cdi.ViewScoped;

import ch.hackaton.apme.DesignPresenter;

/**
 * @author apme
 *
 */
@Default
@ViewScoped
public class SearchContentPresenter implements DesignPresenter<DefaultSearchContentDesign> {

    private DefaultSearchContentDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultSearchContentDesign();
    }

    @Override
    public DefaultSearchContentDesign getDesign() {

        return this.design;
    }
}
