package Action.AccountAccess;

import Access.Paths;
import Database.UserDatabase;
import Entity.User;
import Listener.IUserPass;
import Service.UserService;
import UI.MovieList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.util.List;

public class Login {
    private IUserPass listener;
    private Button login = new Button("Login");
    private UserDatabase userDatabase = UserDatabase.getInstance(Paths.usersPath);
    private List<User> users = userDatabase.read();

    public Login(IUserPass listener){
        this.listener = listener;
    }

    public Button loginButton(){
        login.setOnAction(this::handler);

        login.setTooltip(new Tooltip("Login"));

        return login;
    }

    private void handler(ActionEvent event){
        UserService userService = new UserService(listener);

        try {

            if (userService.isUser(users)) {
                userService.access();
                Stage newWindow = new Stage();
                MovieList movieList = new MovieList();
                movieList.start(newWindow);
            }else
                throw new Exception();

        }catch(Exception e){
            userService.accessDenied();
        }finally {
            userService.clear();
        }
    }
}
