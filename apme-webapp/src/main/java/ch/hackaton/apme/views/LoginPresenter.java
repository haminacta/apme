package ch.hackaton.apme.views;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.servlet.ServletException;

import com.vaadin.cdi.ViewScoped;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.server.Page;

import ch.hackaton.apme.DesignPresenter;

/**
 * @author apme
 *
 */
@Default
@ViewScoped
public class LoginPresenter implements DesignPresenter<DefaultLoginDesign> {

    private DefaultLoginDesign design;

    @Inject
    private JaasAccessControl jaasAccessControl;

    @PostConstruct
    public void initialize() {

        this.design = new DefaultLoginDesign();

        this.design.getLoginButton().addClickListener(clickEvent -> {

            try {
                JaasAccessControl.login(this.design.getUsernameField().getValue(), this.design.getPasswordField().getValue());

                Page.getCurrent().setLocation("./app");
            } catch (final ServletException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Override
    public DefaultLoginDesign getDesign() {

        return this.design;
    }
}
