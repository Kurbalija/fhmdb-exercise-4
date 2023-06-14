package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.Collections;
import java.util.List;

public class Descending extends SortedState {
    public Descending(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void sortDescending(List<Movie> movies) {}

    @Override
    public void sortAscending(List<Movie> movies){
        Collections.reverse(movies);
        homeController.setSortState(new Ascending(homeController));
    }

}
