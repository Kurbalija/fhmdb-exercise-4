package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.Collections;
import java.util.List;

public class Ascending extends SortedState {
    public Ascending(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void sortDescending(List<Movie> movies) {
        Collections.reverse(movies);
        homeController.setSortState(new Descending(homeController));
    }

    @Override
    public void sortAscending(List<Movie> movies){

    }
}