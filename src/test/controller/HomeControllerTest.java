package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.model.Movie;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeControllerTest {
    private final HomeController controller = new HomeController();
    private final List<Movie> movies = Arrays.asList(
            new Movie("1", "Movie1", Arrays.asList("Action", "Adventure"), 2021, "Test description", "http://test.com",
                    120, List.of("Director 1"), List.of("Writer 1"), Arrays.asList("Actor 1", "Actor 2"), 8.0),
            new Movie("2", "Movie2", List.of("Comedy"), 2022, "Test description", "http://test.com",
                    90, List.of("Director 2"), List.of("Writer 2"), List.of("Actor 1"), 7.5),
            new Movie("3", "Movie3_Part1", List.of("Drama"), 2020, "Test description", "http://test.com",
                    150, Arrays.asList("Director 1", "Director 2"), Arrays.asList("Writer 1", "Writer 2"), List.of("Actor 3"), 9.0)
    );

    @Test
    public void isGetMostPopularActor_Actor_1() {
        String mostPopularActor = controller.getMostPopularActor(movies);
        assertEquals("Actor 1", mostPopularActor);
    }

    @Test
    public void isGetLongestMovieTitle_12() {
        int longestTitleLength = controller.getLongestMovieTitle(movies);
        assertEquals(12, longestTitleLength);
    }

    @Test
    public void isCountMoviesFrom_director1_2() {
        long moviesFromDirector1 = controller.countMoviesFrom(movies, "Director 1");
        assertEquals(2, moviesFromDirector1);
    }

    @Test
    public void isGetMoviesBetweenYears_2020_2021_2() {
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);
        assertEquals(2, moviesBetweenYears.size());
        assertTrue(moviesBetweenYears.contains(movies.get(0)));
        assertTrue(moviesBetweenYears.contains(movies.get(2)));
    }

    @Test
    public void doesGetMoviesBetweenYears_2020_2021_contains_first_movie() {
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);
        assertTrue(moviesBetweenYears.contains(movies.get(0)));
    }

    @Test
    public void doesGetMoviesBetweenYears_2020_2021_contains_second_movie() {
        List<Movie> moviesBetweenYears = controller.getMoviesBetweenYears(movies, 2020, 2021);
        assertTrue(moviesBetweenYears.contains(movies.get(2)));
    }
}