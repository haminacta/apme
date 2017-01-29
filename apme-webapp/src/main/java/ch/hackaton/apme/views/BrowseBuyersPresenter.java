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
public class BrowseBuyersPresenter implements DesignPresenter<DefaultBrowseBuyersDesign> {

    private DefaultBrowseBuyersDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultBrowseBuyersDesign();
    }

    @Override
    public DefaultBrowseBuyersDesign getDesign() {

        return this.design;
    }
}
