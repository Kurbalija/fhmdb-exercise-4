package at.ac.fhcampuswien.fhmdb.model;

import static org.junit.jupiter.api.Assertions.*;

import at.ac.fhcampuswien.fhmdb.model.Movie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MovieTest {
    @Test
    public void does_create() {
        assertDoesNotThrow(() -> {
            Movie mov = new Movie("1", "Test", new ArrayList<>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_id(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie(null, "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_genres(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", null, 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_releaseYear(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2024, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_releaseYear_2(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 1959, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_description(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, null, "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_imageUrl(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", null,
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_lengthInMinutes(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    -1, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_directors(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, null, new ArrayList<String>(), new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_writers(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), null, new ArrayList<String>(), 10.0);
        });
    }

    @Test
    public void invalid_mainCast(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), null, 10.0);
        });
    }

    @Test
    public void invalid_rating(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), -1.0);
        });
    }

    @Test
    public void invalid_rating_2(){
        assertThrows(IllegalArgumentException.class, () -> {
            Movie mov = new Movie("1", "Test", new ArrayList<String>(), 2021, "Test", "http://test.com",
                    120, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), 11.0);
        });
    }
}