package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.enums.UIComponent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FhmdbApplication extends Application {
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource(UIComponent.HOME.path));

        try{
            Scene scene = new Scene(fxmlLoader.load(), 890, 620);
            scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("/styles/styles.css")).toExternalForm());
            stage.setTitle("FHMDb!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Cannot load scene from " + UIComponent.HOME.path);
        } catch (NullPointerException e) {
            System.err.println("Path to stylesheet may be corrupt.");
        }

    }

    public static void main(String[] args) {
        launch();
    }
}