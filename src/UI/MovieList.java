package UI;

import Access.Paths;
import Action.MovieList.Add;
import Action.MovieList.Delete;
import Database.MovieDatabase;
import Entity.Movie;
import Listener.ITable;
import Service.MovieService;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieList implements ITable {
    private MovieDatabase movieDatabase = MovieDatabase.getInstance(Paths.moviesPath);
    private TableView<Movie> movieTableView = new TableView(MovieService.getMovies());
    public VBox layout = new VBox(15);

    public void start(Stage primaryStage){
        TableColumn<Movie,String> movieNameCol = new TableColumn("Movie Name");
        movieNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Movie,Double> rateCol = new TableColumn<>("Rate");
        rateCol.setCellValueFactory(new PropertyValueFactory<>("rate"));
        TableColumn<Movie,Integer> yearCol = new TableColumn<>("Year");
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

        movieTableView.getColumns().addAll(movieNameCol,rateCol,yearCol);

        Add addPage = new Add(this);
        Delete delete = new Delete(this);

        HBox buttons = new HBox(25);
        buttons.getChildren().addAll(addPage.getAdd(),delete.getDelete());

        layout.getChildren().addAll(movieTableView,buttons);

        Scene scene = new Scene(layout,500,500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Movie List");
        primaryStage.show();
    }

    @Override
    public TableView getTableView() {
        return movieTableView;
    }
}
