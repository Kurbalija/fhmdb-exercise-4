package at.ac.fhcampuswien.fhmdb.database;

public class DataBaseException extends Exception{
    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException() {
        super();
    }

    public DataBaseException(Exception e) {
        super(e);
    }
}
