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
public class BrowsePurchasesPresenter implements DesignPresenter<DefaultBrowsePurchasesDesign> {

    private DefaultBrowsePurchasesDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultBrowsePurchasesDesign();
    }

    @Override
    public DefaultBrowsePurchasesDesign getDesign() {

        return this.design;
    }
}
