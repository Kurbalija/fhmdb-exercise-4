package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.Comparator;
import java.util.List;

public class Descending implements SortingStrategy {
    @Override
    public void sort(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getTitle).reversed());
    }
}