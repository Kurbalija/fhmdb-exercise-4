package at.ac.fhcampuswien.fhmdb.api;

public class MovieApiException extends Exception{
    public MovieApiException() {
        super();
    }

    public MovieApiException(String message) {
        super(message);
    }
}
