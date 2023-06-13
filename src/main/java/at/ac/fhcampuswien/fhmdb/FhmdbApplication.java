package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.factory.ControllerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ControllerFactory factory = new ControllerFactory();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
        fxmlLoader.setControllerFactory(factory);
        Scene scene = new Scene(fxmlLoader.load(), 910, 620);
        scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
        stage.setTitle("FHMDb");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}