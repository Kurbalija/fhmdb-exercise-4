package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:h2:file:./db/fhmdb"; // in memory: jdbc:h2:mem:fhmdb
    public static final String user = "admin";
    public static final String pass = "pass";

    private static ConnectionSource connectionSource;
    private static DatabaseManager instance;

    private final Dao<WatchlistMovieEntity, Long> watchlistMovieDao;

    private DatabaseManager() throws DataBaseException {
        try {
            createConnectionSource();
            watchlistMovieDao = DaoManager.createDao(connectionSource, WatchlistMovieEntity.class);
            createTables();
        } catch (SQLException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    // get singleton database instance
    public static DatabaseManager getInstance() throws DataBaseException {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public static ConnectionSource getConnectionSource() throws DataBaseException {
        if (connectionSource == null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    private static void createConnectionSource() throws DataBaseException {
        try {
            connectionSource = new JdbcConnectionSource(DB_URL, user, pass);
        } catch (SQLException e) {
            throw new DataBaseException(e.getMessage());
        }

    }

    // close the db connection
    public static void closeConnectionSource() throws DataBaseException {
        if(connectionSource != null){
            try {
                connectionSource.close();
            } catch (Exception e) {
                e.printStackTrace();
                throw new DataBaseException(e.getMessage());
            }
        }
    }

    // creates the tables in the database
    private static void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, WatchlistMovieEntity.class);
    }

    // removes tables from database
    private static void dropTables() throws SQLException {
        TableUtils.dropTable(connectionSource, WatchlistMovieEntity.class, true);
    }

    public Dao<WatchlistMovieEntity, Long> getWatchlistDao() {
        return watchlistMovieDao;
    }
}
