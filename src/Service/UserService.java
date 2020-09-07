package Service;

import Access.Paths;
import Database.UserDatabase;
import Entity.User;
import Listener.IUserPass;
import javafx.stage.Stage;

import java.util.List;

public class UserService{
    private IUserPass listener;
    private UserDatabase userDatabase = UserDatabase.getInstance(Paths.usersPath);

    public UserService(IUserPass listener){
        this.listener = listener;
    }

    public boolean isUsername(List<User> users){
        return users.stream().anyMatch(user -> {
            if(user.getUsername().equals(listener.getUsernameField().getText()))
                return true;
            else
                return false;
        });
    }

    public boolean isUser(List<User> users){
        return users.stream().anyMatch(user -> {
            if(user.getUsername().equals(listener.getUsernameField().getText()) &
                    (user.getPassword().equals(listener.getPasswordFieldShown()) ||
                user.getPassword().equals(listener.getPasswordField().getText())))
                return true;
            else
                return false;
        });
    }

    public void createAccount(){
        userDatabase.create(new User(listener.getUsernameField().getText(),listener.getPasswordField().getText()));

        listener.getAuthenticated().setText("The Account has been created successfully ...");
        listener.getAuthenticated().setStyle("-fx-background-color: green");

        clear();
    }

    public void createAccountFailed(){
        listener.getAuthenticated().setText("The Account has been already created ...");
        listener.getAuthenticated().setStyle("-fx-background-color: red");
    }

    public void access(){
        listener.getAuthenticated().setText("Authenticated ...");
        listener.getAuthenticated().setStyle("-fx-background-color: green");
    }

    public void accessDenied(){
        listener.getAuthenticated().setText("Not Authenticated ...");
        listener.getAuthenticated().setStyle("-fx-background-color: red");
    }

    public void clear(){
        listener.getUsernameField().setText("");
        listener.getPasswordField().setText("");
        listener.getUsernameField().requestFocus();
    }
}