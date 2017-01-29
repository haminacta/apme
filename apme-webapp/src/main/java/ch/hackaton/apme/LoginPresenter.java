package ch.hackaton.apme;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;

import com.vaadin.cdi.UIScoped;

/**
 * @author apme
 *
 */
@Default
@UIScoped
public class LoginPresenter implements DesignPresenter<DefaultLoginDesign> {

    private DefaultLoginDesign design;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultLoginDesign();
    }

    @Override
    public DefaultLoginDesign getDesign() {

        return this.design;
    }
}
