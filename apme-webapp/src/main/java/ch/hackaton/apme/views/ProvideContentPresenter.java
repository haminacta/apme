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
public class ProvideContentPresenter implements DesignPresenter<DefaultProvideContentDesign> {

    private DefaultProvideContentDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultProvideContentDesign();
    }

    @Override
    public DefaultProvideContentDesign getDesign() {

        return this.design;
    }
}
