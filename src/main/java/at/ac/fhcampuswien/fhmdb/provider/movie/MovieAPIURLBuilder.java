package at.ac.fhcampuswien.fhmdb.provider.movie;

import okhttp3.HttpUrl;
import java.util.Objects;

public class MovieAPIURLBuilder {
    private HttpUrl.Builder urlBuilder;

    public MovieAPIURLBuilder(String baseUrl) {
        this.urlBuilder = Objects.requireNonNull(HttpUrl.parse(baseUrl)).newBuilder();
    }

    public MovieAPIURLBuilder query(String query) {
        this.urlBuilder.addQueryParameter("query", query);
        return this;
    }

    public MovieAPIURLBuilder genre(String genre) {
        this.urlBuilder.addQueryParameter("genre", genre);
        return this;
    }

    public MovieAPIURLBuilder releaseYear(String year) {
        this.urlBuilder.addQueryParameter("releaseYear", year);
        return this;
    }

    public MovieAPIURLBuilder ratingFrom(String rating) {
        this.urlBuilder.addQueryParameter("ratingFrom", rating);
        return this;
    }

    public HttpUrl build() {
        return this.urlBuilder.build();
    }
}