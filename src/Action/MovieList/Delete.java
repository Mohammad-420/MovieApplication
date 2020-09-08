package Action.MovieList;

import Access.Paths;
import Database.MovieDatabase;
import Entity.Movie;
import Listener.ITable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.List;

public class Delete{
    private ITable listener;
    private MovieDatabase movieDatabase = MovieDatabase.getInstance(Paths.moviesPath);

    private Button delete = new Button("Delete");

    public Delete(ITable listener) {
        this.listener = listener;
    }

    public Button getDelete(){
        delete.setOnAction(this::deleteHandler);

        return delete;
    }

    private void deleteHandler(ActionEvent event){
        movieDatabase.delete(listener.getTableView().getSelectionModel().getSelectedIndex());

        ObservableList<Movie> allMovie = listener.getTableView().getItems();
        ObservableList<Movie> selectedMovie = listener.getTableView().getSelectionModel().getSelectedItems();
        selectedMovie.forEach(allMovie::remove);
    }
}
