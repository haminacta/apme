package ch.hackaton.apme.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

/**
 * @author apme
 *
 */
@SuppressWarnings("serial")
public class DefaultLoginDesign extends LoginDesign {

    public DefaultLoginDesign() {

        super();
    }

    public Button getLoginButton() {

        return this.loginButton;
    }

    public TextField getUsernameField() {

        return this.usernameField;
    }

    public PasswordField getPasswordField() {

        return this.passwordField;
    }
}
