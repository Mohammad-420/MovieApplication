package Action.AccountAccess;

import Listener.IUserPass;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tooltip;

public class ShowPassword {
    private IUserPass listener;
    private CheckBox showPassword = new CheckBox("Show Password");

    public ShowPassword(IUserPass listener){
        this.listener = listener;
    }

    public CheckBox showPasswordCheckBox(){

        listener.getPasswordFieldShown().setManaged(false);
        listener.getPasswordFieldShown().setVisible(false);


        listener.getPasswordFieldShown().managedProperty().bind(showPassword.selectedProperty());
        listener.getPasswordFieldShown().visibleProperty().bind(showPassword.selectedProperty());

        listener.getPasswordField().managedProperty().bind(showPassword.selectedProperty().not());
        listener.getPasswordField().visibleProperty().bind(showPassword.selectedProperty().not());

        listener.getPasswordFieldShown().textProperty().bindBidirectional(listener.getPasswordField().textProperty());

        showPassword.setTooltip(new Tooltip("Show Password"));
        return showPassword;
    }
}
