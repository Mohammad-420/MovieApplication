package Action.AccountAccess;

import Access.Paths;
import Database.UserDatabase;
import Entity.User;
import Listener.IUserPass;
import Service.UserService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

import java.util.List;

public class SignUp {
    private IUserPass listener;
    private Button signUp = new Button("Sign Up");
    private UserDatabase userDatabase = UserDatabase.getInstance(Paths.usersPath);

    public SignUp(IUserPass listener) {
        this.listener = listener;
    }

    public Button signUpButton() {
        signUp.setOnAction(this::handler);

        signUp.setTooltip(new Tooltip("Sign Up"));

        return signUp;
    }

    public void handler(ActionEvent event) {
        UserService userService = new UserService(listener);

        try {
            if (userDatabase.read() != null) {
                if(userService.isUsername(userDatabase.read()))
                    throw new Exception();
            }
            userService.createAccount();
        }catch (Exception e){
            userService.createAccountFailed();
        }finally {
            userService.clear();
        }
    }
}
