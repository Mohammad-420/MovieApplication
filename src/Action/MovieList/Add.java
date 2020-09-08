package Action.MovieList;

import Access.Paths;
import Database.MovieDatabase;
import Entity.Movie;
import Listener.ITable;
import javafx.scene.control.Button;

public class Add extends MoviePage {
    private ITable listener;
    private MovieDatabase movieDatabase = MovieDatabase.getInstance(Paths.moviesPath);

    public Add(ITable listener) {
        this.listener = listener;
    }

    public Button getAdd() {
        Button add = new Button("Add");
        add.setOnAction(event -> newWindow(getAddList()));

        return add;
    }

    private Button getAddList() {
        Button add = new Button("Add");

        add.setOnAction(event -> {


            try {
                Movie movie = new Movie(movieName.getText(),
                        Double.parseDouble(movieRate.getText()),
                        Integer.parseInt(movieYear.getText()));

                if (movieDatabase.read() != null) {
                    if (movieDatabase.read().stream().findAny().get().equals(movie))
                        throw new ClassNotFoundException();
                }

                allowed.setText("This Movie has been added on the list ...");
                allowed.setStyle("-fx-background-color: green");

                movieDatabase.create(movie);

                listener.getTableView().getItems().addAll(movie);

                clearMovieFields();

            } catch (ClassNotFoundException e) {
                allowed.setText("The Movie has been already added ...");
                allowed.setStyle("-fx-background-color: red");
            }catch (NumberFormatException e){
                allowed.setText("There isn't any Movie ...");
                allowed.setStyle("-fx-background-color: red");
            }
        });

        return add;
    }
}