package at.ac.fhcampuswien.fhmdb.controller;

import at.ac.fhcampuswien.fhmdb.exception.DatabaseException;
import at.ac.fhcampuswien.fhmdb.model.WatchlistEntity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Observable {
    private static WatchlistRepository instance = null;
    private final Dao<WatchlistEntity, Long> dao;
    private List<Observer> observers = new ArrayList<>();
    private boolean changed = false;

    private WatchlistRepository( Dao<WatchlistEntity, Long> dao ) {
        this.dao = dao;
    }

    public static WatchlistRepository getInstance(Dao<WatchlistEntity, Long> dao) {
        if (instance == null) {
            if (dao != null)
                instance = new WatchlistRepository(dao);
            else
                instance = new WatchlistRepository(null);
        }
        return instance;
    }

    public void removeFromWatchlist(WatchlistEntity movie) throws DatabaseException {
        try {
            String apiId = movie.getApiId();
            DeleteBuilder<WatchlistEntity, Long> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.where().eq("apiId", apiId);
            dao.delete(deleteBuilder.prepare());
        } catch (SQLException | NullPointerException | IllegalArgumentException e) {
            throw new DatabaseException("Failed to remove entity from database.", e);
        }
    }

    public List<WatchlistEntity> getAll() throws DatabaseException {
        try {
            return dao.queryForAll();
        } catch (SQLException | NullPointerException | IllegalArgumentException e) {
            throw new DatabaseException("Failed to fetch entities from database.", e);
        }
    }

    public void addToWatchlist(WatchlistEntity movie) throws DatabaseException {
        try {
            if(dao.queryForEq("apiId", movie.getApiId()).size() < 1) {
                dao.create(movie);
                setChanged();
                notifyObservers();
            }
            else {
                notifyObservers();
            }
        } catch (SQLException | NullPointerException | IllegalArgumentException e) {
            throw new DatabaseException("Failed to add entity to database.", e);
        }
    }

    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if(!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.changed);
        }
        clearChanged();
    }

    protected void setChanged() {
        this.changed = true;
    }

    protected void clearChanged() {
        this.changed = false;
    }
}