package Listener;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface IUserPass {

    TextField getUsernameField();
    PasswordField getPasswordField();
    TextField getPasswordFieldShown();

    Label getAuthenticated();
}
