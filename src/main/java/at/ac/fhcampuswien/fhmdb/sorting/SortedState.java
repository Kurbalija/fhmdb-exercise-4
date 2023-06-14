package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.List;

public abstract class SortedState {
    HomeController homeController;
    protected SortedState(HomeController homeController){
        this.homeController = homeController;
    }

    public abstract void sortDescending(List<Movie> movies);
    public abstract void sortAscending(List<Movie> movies);
}