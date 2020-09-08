package UI;

import Action.AccountAccess.Login;
import Action.AccountAccess.ShowPassword;
import Action.AccountAccess.SignUp;
import Listener.IUserPass;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginAndSignUp implements IUserPass {
    private TextField usernameField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private TextField passwordFieldShown = new TextField();

    private Label authenticated = new Label();

    void start(Stage primaryStage){
        //create SignUp Object for add button to the Layout
        SignUp signUp = new SignUp(this);
        //create Login Object for add button to the Layout
        Login login = new Login(this);

        ShowPassword showPassword = new ShowPassword(this);

        // View
        usernameField.setTooltip(new Tooltip("Username"));
        usernameField.setPromptText("Username");

        passwordField.setTooltip(new Tooltip("Password"));
        passwordField.setPromptText("Password");

        // Label
        Label usernameLabel = new Label("Username : ");
        Label passwordLabel = new Label("Password : ");

        // Horizontal Layout for Username
        HBox usernameLayout = new HBox(30);
        usernameLayout.getChildren().addAll(usernameLabel,usernameField);
        usernameLayout.setAlignment(Pos.CENTER);

        //Horizontal Layout for Password
        HBox passwordLayout = new HBox(30);
        passwordLayout.getChildren().addAll(passwordLabel,passwordField,passwordFieldShown);
        passwordLayout.setAlignment(Pos.CENTER);

        //Horizontal Layout for Buttons
        HBox buttonsLayout = new HBox(30);
        buttonsLayout.getChildren().addAll(signUp.signUpButton(),login.loginButton());
        buttonsLayout.setAlignment(Pos.CENTER);

        // Vertical Layout
        VBox layout = new VBox(30);
        layout.getChildren().addAll(usernameLayout,passwordLayout,showPassword.showPasswordCheckBox(),buttonsLayout,authenticated);
        layout.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(layout,500,500);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login And Sign Up");
        primaryStage.show();
    }

    @Override
    public TextField getUsernameField() {
        return usernameField;
    }

    @Override
    public PasswordField getPasswordField() {
        return passwordField;
    }

    @Override
    public TextField getPasswordFieldShown() {
        return passwordFieldShown;
    }

    @Override
    public Label getAuthenticated() {
        return authenticated;
    }
}
