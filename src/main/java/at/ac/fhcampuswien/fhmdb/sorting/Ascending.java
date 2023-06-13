package at.ac.fhcampuswien.fhmdb.sorting;

import java.util.Comparator;
import java.util.List;

public class Ascending implements SortingStrategy {
    @Override
    public void sort(List<at.ac.fhcampuswien.fhmdb.model.Movie> movies) {
        movies.sort(Comparator.comparing(at.ac.fhcampuswien.fhmdb.model.Movie::getTitle));
    }
}