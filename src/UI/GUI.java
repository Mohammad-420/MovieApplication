package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LoginAndSignUp loginAndSignUp = new LoginAndSignUp();
        loginAndSignUp.start(primaryStage);

//        MovieList movieList = new MovieList();
//        movieList.start(primaryStage);
    }
}
