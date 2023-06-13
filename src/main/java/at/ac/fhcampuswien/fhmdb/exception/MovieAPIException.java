package at.ac.fhcampuswien.fhmdb.exception;

import java.io.IOException;

public class MovieAPIException extends IOException {
    public MovieAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}