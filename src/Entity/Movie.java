package Entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Movie implements Serializable,Model {
    private transient UUID id = UUID.randomUUID();
    private String name;
    private double rate;
    private int year;
    private transient List<Actor> actors;

    public Movie(String name, double rate, int year) {
        this.name = name;
        this.rate = rate;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id.toString();
    }

    private void match(Movie anotherMovie){
        if(this.name.equals(anotherMovie.name) & this.rate == anotherMovie.rate & this.year == anotherMovie.year)
            this.id = anotherMovie.id;
    }

    public boolean equals(Movie anotherMovie) {
        match(anotherMovie);
        if (anotherMovie.id.equals(this.id))
            return true;
        else
            return false;
    }
}
