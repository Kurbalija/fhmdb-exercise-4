package at.ac.fhcampuswien.fhmdb.exception;

import java.sql.SQLException;

public class DatabaseException extends SQLException {
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}