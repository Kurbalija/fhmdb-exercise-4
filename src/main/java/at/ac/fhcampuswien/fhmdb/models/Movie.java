package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Movie {
    private final String id;
    private final String title;
    private final String description;
    private final List<Genre> genres;
    private final int releaseYear;
    private final String imgUrl;
    private final int lengthInMinutes; // in minutes
    private final List<String> directors = new ArrayList<>();
    private final List<String> writers = new ArrayList<>();
    private final List<String> mainCast = new ArrayList<>();
    private final double rating; // 0-10

    public Movie(String title, String description, List<Genre> genres) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = 0;
        this.imgUrl = "";
        this.lengthInMinutes = 0;
        this.rating = 0;
    }
    public Movie(String id, String title, String description, List<Genre> genres, int releaseYear, String imgUrl, int lengthInMinutes, double rating) {
        if(id == null) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        this.title = title;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.imgUrl = imgUrl;
        this.lengthInMinutes = lengthInMinutes;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Movie other)) {
            return false;
        }
        return this.title.equals(other.title) && this.description.equals(other.description) && this.genres.equals(other.genres);
    }

    public String getId() {return id; }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<String> getMainCast() {
        return mainCast;
    }

    public double getRating() {
        return rating;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                null,
                "Life Is Beautiful",
                "When an open-minded Jewish librarian and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp." ,
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE),
                1997,
                "https://upload.wikimedia.org/wikipedia/en/7/7c/Life_is_Beautiful.jpg",
                116,
                8.6));
        movies.add(new Movie(
                null,
                "The Usual Suspects",
                "A sole survivor tells of the twisty events leading up to a horrific gun battle on a boat, which begin when five criminals meet at a seemingly random police lineup.",
                Arrays.asList(Genre.CRIME, Genre.DRAMA, Genre.MYSTERY),
                1995,
                "https://upload.wikimedia.org/wikipedia/en/9/9c/Usual_suspects_ver1.jpg",
                106,
                8.6));
        movies.add(new Movie(
                null,
                "Puss in Boots",
                "An outlaw cat, his childhood egg-friend, and a seductive thief kitty set out in search for the eggs of the fabled Golden Goose to clear his name, restore his lost honor, and regain the trust of his mother and town.",
                Arrays.asList(Genre.COMEDY, Genre.FAMILY, Genre.ANIMATION),
                2011,
                "",
                90,
                6.6
                ));
        movies.add(new Movie(
                null,
                "Avatar",
                "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
                Arrays.asList(Genre.ANIMATION, Genre.DRAMA, Genre.ACTION),
                2009,
                "",
                162,
                7.8));
        movies.add(new Movie(
                null,
                "The Wolf of Wall Street",
                "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE, Genre.BIOGRAPHY),
                2013,
                "",
                180,
                8.2));

        return movies;
    }
}
