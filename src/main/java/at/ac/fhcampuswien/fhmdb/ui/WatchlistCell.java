package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.database.WatchlistMovieEntity;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.stream.Collectors;

public class WatchlistCell extends ListCell<WatchlistMovieEntity> {
    private final Label title = new Label();
    private final Label description = new Label();
    private final Label genre = new Label();
    private final JFXButton detailBtn = new JFXButton("Show Details");
    private final JFXButton removeBtn = new JFXButton("Remove");
    private final HBox header = new HBox(title, detailBtn, removeBtn);
    private final VBox layout = new VBox(header, description, genre);
    private boolean collapsedDetails = true;

    public WatchlistCell(ClickEventHandler removeFromWatchlistClick) {
        super();
        // color scheme
        detailBtn.setStyle("-fx-background-color: #f5c518;");
        HBox.setMargin(detailBtn, new Insets(0, 10, 0, 10));
        removeBtn.setStyle("-fx-background-color: #f5c518;");
        title.getStyleClass().add("text-yellow");
        description.getStyleClass().add("text-white");
        genre.getStyleClass().add("text-white");
        genre.setStyle("-fx-font-style: italic");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setHgrow(title, Priority.ALWAYS);
        header.setHgrow(detailBtn, Priority.ALWAYS);
        title.setMaxWidth(Double.MAX_VALUE);

        // layout
        title.fontProperty().set(title.getFont().font(20));
        description.setWrapText(true);
        layout.setPadding(new Insets(10));

        detailBtn.setOnMouseClicked(mouseEvent -> {
            if (collapsedDetails) {
                layout.getChildren().add(getDetails());
                collapsedDetails = false;
                detailBtn.setText("Hide Details");
            } else {
                layout.getChildren().remove(3);
                collapsedDetails = true;
                detailBtn.setText("Show Details");
            }
            setGraphic(layout);
        });

        removeBtn.setOnMouseClicked(mouseEvent -> {
            removeFromWatchlistClick.onClick(getItem());
        });
    }

    private VBox getDetails() {
        VBox details = new VBox();
        Label releaseYear = new Label("Release Year: " + getItem().getReleaseYear());
        Label length = new Label("Length: " + getItem().getLengthInMinutes() + " minutes");
        Label rating = new Label("Rating: " + getItem().getRating());

        releaseYear.getStyleClass().add("text-white");
        length.getStyleClass().add("text-white");
        rating.getStyleClass().add("text-white");

        details.getChildren().add(releaseYear);
        details.getChildren().add(rating);
        details.getChildren().add(length);
        return details;
    }
    @Override
    protected void updateItem(WatchlistMovieEntity watchlistMovieEntity, boolean empty) {
        super.updateItem(watchlistMovieEntity, empty);

        if (empty || watchlistMovieEntity == null) {
            setGraphic(null);
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(watchlistMovieEntity.getTitle());
            description.setText(
                    watchlistMovieEntity.getDescription() != null
                            ? watchlistMovieEntity.getDescription()
                            : "No description available"
            );

            description.setMaxWidth(this.getScene().getWidth() - 30);

            String genres = watchlistMovieEntity.getGenres()
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.joining(", "));
            genre.setText(genres);
            setGraphic(layout);
        }
    }
}

