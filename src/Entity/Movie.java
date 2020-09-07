package Entity;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable,Model {
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
}
