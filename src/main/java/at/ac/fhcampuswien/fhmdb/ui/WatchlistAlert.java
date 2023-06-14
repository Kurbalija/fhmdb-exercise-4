package at.ac.fhcampuswien.fhmdb.ui;

import javafx.scene.control.Alert;

public class WatchlistAlert {
    public static void show(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}