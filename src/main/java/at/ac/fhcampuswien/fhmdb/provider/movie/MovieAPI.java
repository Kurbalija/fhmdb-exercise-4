package at.ac.fhcampuswien.fhmdb.provider.movie;

import at.ac.fhcampuswien.fhmdb.exception.MovieAPIException;
import at.ac.fhcampuswien.fhmdb.model.Movie;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class MovieAPI implements MovieProvider {
    private static final String BASE_URL = "https://prog2.fh-campuswien.ac.at";
    private static final String ENDPOINT_MOVIES = "/movies";
    private final OkHttpClient client;
    private final Gson gson;

    public MovieAPI() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    @Override
    public List<Movie> getMovies() throws MovieAPIException {
        return this.getMoviesWithQuery(null);
    }

    public List<Movie> getMoviesWithQuery(Map<String, String> queryMap) throws MovieAPIException {
        MovieAPIURLBuilder builder = new MovieAPIURLBuilder(BASE_URL + ENDPOINT_MOVIES);

        if(queryMap != null){
            for (String key: queryMap.keySet()) {
                switch (key) {
                    case "query" -> builder.query(queryMap.get(key));
                    case "genre" -> builder.genre(queryMap.get(key));
                    case "releaseYear" -> builder.releaseYear(queryMap.get(key));
                    case "ratingFrom" -> builder.ratingFrom(queryMap.get(key));
                }
            }
        }

        return requestMovieList(builder.build());
    }

    private List<Movie> requestMovieList(HttpUrl url) throws MovieAPIException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", "http.agent")
                .build();
        try (Response response = client.newCall(request).execute()) {
            String json = response.body().string();
            return Arrays.asList(gson.fromJson(json, Movie[].class));
        }
        catch(IOException | NullPointerException | IllegalArgumentException e) {
            throw new MovieAPIException("Error fetching data from resource.", e);
        }
    }
}