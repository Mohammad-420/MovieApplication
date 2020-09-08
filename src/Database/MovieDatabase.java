package Database;

import Entity.Movie;
import Entity.User;

import java.util.List;

public class MovieDatabase extends Database<Movie>{
    private static MovieDatabase instance;

    private MovieDatabase(String path){
        super(path);
    }

    public static MovieDatabase getInstance(String path) {
        if(instance == null)
            instance = new MovieDatabase(path);
        return instance;
    }

    public void create(Movie movie){
        super.create(movie);
    }

    public List<Movie> read(){
        return super.read();
    }

    public void update(int oldMovieIndex,Movie newMovie){
        super.update(oldMovieIndex,newMovie);
    }

    public void delete(int index){
        super.delete(index);
    }
}
