package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.Comparator;
import java.util.List;

public class Unsorted extends SortedState {
    public Unsorted(HomeController homeController) {
        super(homeController);
    }

    @Override
    public void sortAscending(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getTitle));
        homeController.setSortState(new Ascending(homeController));
    }

    public void sortDescending(List<Movie> movies){
        movies.sort(Comparator.comparing(Movie::getTitle).reversed());
        homeController.setSortState(new Descending(homeController));
    }
}