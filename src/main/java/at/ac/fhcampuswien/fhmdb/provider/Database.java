package at.ac.fhcampuswien.fhmdb.provider;

import at.ac.fhcampuswien.fhmdb.exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.model.WatchlistEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database {
    private final String DB_URL = "jdbc:h2:file:./db/fhmdb;DB_CLOSE_DELAY=-1"; // For in-memory database
    private final String username = "";
    private final String password = "";
    private ConnectionSource connectionSource;
    private Dao<WatchlistEntity, Long> dao;

    public Database() throws DatabaseException {
        createConnectionSource();
        createTables();
    }

    private void createConnectionSource() throws DatabaseException {
        try {
            connectionSource = new JdbcConnectionSource(DB_URL, username, password);
        } catch (SQLException | NullPointerException | IllegalArgumentException e) {
            throw new DatabaseException("Failed to create a database connection.", e);
        }
    }

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    private void createTables() throws DatabaseException {
        try {
            TableUtils.createTableIfNotExists(connectionSource, WatchlistEntity.class);
            dao = DaoManager.createDao(connectionSource, WatchlistEntity.class);
        } catch (SQLException | NullPointerException | IllegalArgumentException e) {
            throw new DatabaseException("Failed to create tables in the database.", e);
        }
    }

    public Dao<WatchlistEntity, Long> getWatchlistDao() {
        return dao;
    }
}