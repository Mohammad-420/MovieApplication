package Service;

import Access.Paths;
import Database.MovieDatabase;
import Database.UserDatabase;
import Entity.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class MovieService {
    public static ObservableList<Movie> getMovies(){
        MovieDatabase movieDatabase = MovieDatabase.getInstance(Paths.moviesPath);

        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();

        List<Movie> movies;

        if(movieDatabase.read() != null) {
            movies = movieDatabase.read();
            movieObservableList.addAll(movies);
        }

        return movieObservableList;
    }
}
