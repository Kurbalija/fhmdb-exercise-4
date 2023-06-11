package at.ac.fhcampuswien.fhmdb.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class ExceptionAlert {
    public static void show(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("An error occurred!");
        alert.setHeaderText(e.getMessage());
        String contentText = "Error caused by:\n" + e.getCause();
        ScrollPane scrollPane = new ScrollPane();
        TextArea textArea = new TextArea(contentText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        scrollPane.setContent(textArea);
        scrollPane.setPrefSize(400, 100);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        alert.getDialogPane().setContent(scrollPane);
        alert.showAndWait();
    }
}