package Action.MovieList;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MoviePage {
    protected Stage window = new Stage();

    protected Button actorsButton = new Button("Actors");

    protected TextField movieYear = new TextField();
    protected TextField movieName = new TextField();
    protected TextField movieRate = new TextField();

    protected Label allowed = new Label();

    protected void newWindow(Button btn) {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(movieName, movieRate, movieYear);

        VBox layout = new VBox(15);
        layout.getChildren().addAll(hBox, btn,allowed);
        Scene scene = new Scene(layout, hBox.getMinWidth(), layout.getMinHeight());

        window.setScene(scene);
        window.setTitle(btn.getText());
        window.show();
    }

    protected void clearMovieFields() {
        movieName.setText("");
        movieRate.setText("");
        movieYear.setText("");
        movieName.requestFocus();
    }
}
