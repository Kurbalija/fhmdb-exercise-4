package at.ac.fhcampuswien.fhmdb.provider.movie;

import at.ac.fhcampuswien.fhmdb.exception.MovieAPIException;
import at.ac.fhcampuswien.fhmdb.model.Movie;

import java.util.List;
import java.util.Map;

public interface MovieProvider {
    List<Movie> getMovies() throws MovieAPIException;

    List<Movie> getMoviesWithQuery(Map<String, String> queryMap) throws MovieAPIException;
}