package at.ac.fhcampuswien.fhmdb.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String id;
    private final String title;
    private final List<String> genres;
    private final int releaseYear;
    private final String description;
    private final String imgUrl;
    private final int lengthInMinutes;
    private final List<String> directors;
    private final List<String> writers;
    private final List<String> mainCast;
    private final double rating;
    private boolean isInWatchlist;

    public Movie(String id, String title, List<String> genres, int releaseYear, String description, String imgUrl,
                 int lengthInMinutes, List<String> directors, List<String> writers, List<String> mainCast, double rating) {

        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID may not be null or empty");
        }
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title may not be null or empty");
        }
        if(genres == null) {
            throw new IllegalArgumentException("Genre-List may not be null");
        }
        if(releaseYear < 1970 || releaseYear > 2023) {
            throw new IllegalArgumentException("Invalid releaseYear");
        }
        if(description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description may not be null or empty");
        }
        if(imgUrl == null || imgUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL may not be null or empty");
        }
        if(lengthInMinutes < 0) {
            throw new IllegalArgumentException("Invalid length in minutes");
        }
        if(directors == null) {
            throw new IllegalArgumentException("Directors-List may not be null");
        }
        if(writers == null) {
            throw new IllegalArgumentException("Writers-List may not be null");
        }
        if(mainCast == null) {
            throw new IllegalArgumentException("MainCast-List may not be null");
        }
        if(rating < 0.0 || rating > 10.0) {
            throw new IllegalArgumentException("Invalid rating");
        }

        this.id = id;
        this.title = title;
        this.genres = new ArrayList<>(genres);
        this.releaseYear = releaseYear;
        this.description = description;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.directors = new ArrayList<>(directors);
        this.writers = new ArrayList<>(writers);
        this.mainCast = new ArrayList<>(mainCast);
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres() {
        return new ArrayList<>(genres);
    }

    public List<String> getMainCast() {
        return new ArrayList<>(mainCast);
    }

    public List<String> getDirectors() {
        return new ArrayList<>(directors);
    }

    public List<String> getWriters() {
        return new ArrayList<>(writers);
    }

    public String getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isInWatchlist() {
        return isInWatchlist;
    }

    public void setInWatchlist(boolean value) {
        this.isInWatchlist = value;
    }
}
