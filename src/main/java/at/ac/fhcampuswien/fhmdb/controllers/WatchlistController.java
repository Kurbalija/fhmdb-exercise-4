package at.ac.fhcampuswien.fhmdb.controllers;

import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.database.DataBaseException;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import at.ac.fhcampuswien.fhmdb.database.WatchlistRepository;
import at.ac.fhcampuswien.fhmdb.ui.UserDialog;
import at.ac.fhcampuswien.fhmdb.ui.WatchlistCell;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WatchlistController implements Initializable {

    @FXML
    public JFXListView watchlistView;

    private WatchlistRepository watchlistRepository;

    protected ObservableList<WatchlistMovieEntity> observableWatchlist = FXCollections.observableArrayList();

    private final ClickEventHandler onRemoveFromWatchlistClicked = (o) -> {
        if (o instanceof WatchlistMovieEntity) {
            WatchlistMovieEntity watchlistMovieEntity = (WatchlistMovieEntity) o;

            try {
                WatchlistRepository watchlistRepository = new WatchlistRepository();
                watchlistRepository.removeFromWatchlist(watchlistMovieEntity);
                observableWatchlist.remove(watchlistMovieEntity);
            } catch (DataBaseException e) {
                UserDialog dialog = new UserDialog("Database Error", "Could not remove movie from watchlist");
                dialog.show();
                e.printStackTrace();
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<WatchlistMovieEntity> watchlist = new ArrayList<>();
        try {
            watchlistRepository = new WatchlistRepository();
            watchlist = getWatchlist();
            observableWatchlist.addAll(getWatchlist());
            watchlistView.setItems(observableWatchlist);
            watchlistView.setCellFactory(movieListView -> new WatchlistCell(onRemoveFromWatchlistClicked));

        } catch (DataBaseException e) {
            UserDialog dialog = new UserDialog("Database Error", "Could not read movies from DB");
            dialog.show();
            e.printStackTrace();
        }

        if(watchlist.size() == 0) {
            watchlistView.setPlaceholder(new javafx.scene.control.Label("Watchlist is empty"));
        }


        System.out.println("WatchlistController initialized");
    }

    private List<WatchlistMovieEntity> getWatchlist() throws DataBaseException {
        return watchlistRepository.readWatchlist();
    }
}
