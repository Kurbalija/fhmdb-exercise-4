package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Movie> movies);
}