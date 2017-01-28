package ch.hackaton.apme;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;

import com.vaadin.cdi.UIScoped;
import com.vaadin.navigator.Navigator;

/**
 * @author apme
 *
 */
@Default
@UIScoped
public class ApplicationDesignPresenter implements DesignPresenter<DefaultApplicationDesign>, CanNavigate {

    private DefaultApplicationDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultApplicationDesign();
    }

    @Override
    public DefaultApplicationDesign getDesign() {

        return this.design;
    }

    @Override
    public void initialize(final Navigator navigator) {

        this.design.searchContentButton.addClickListener(clickEvent -> {

            navigator.navigateTo("search");
        });

        this.design.browsePurchasesButton.addClickListener(clickEvent -> {

            navigator.navigateTo("purchases");
        });

        this.design.browseBuyersButton.addClickListener(clickEvent -> {

            navigator.navigateTo("buyers");
        });

        this.design.provideConentButton.addClickListener(clickEvent -> {

            navigator.navigateTo("provide");
        });
    }
}
