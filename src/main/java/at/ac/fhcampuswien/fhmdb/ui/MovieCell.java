package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.ClickEventHandler;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.stream.Collectors;

public class MovieCell extends ListCell<Movie> {
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genre = new Label();
    private final JFXButton detailBtn = new JFXButton("Show Details");
    private final JFXButton watchlistBtn = new JFXButton("Watchlist");
    private final HBox header = new HBox(title, detailBtn, watchlistBtn);
    private final VBox layout = new VBox(header, detail, genre);
    private boolean collapsedDetails = true;

    public MovieCell(ClickEventHandler<Movie> addToWatchlistClicked) {
        super();
        // color scheme
        detailBtn.setStyle("-fx-background-color: #f5c518;");
        // set margin of detailBtn
        HBox.setMargin(detailBtn, new Insets(0, 10, 0, 10));
        watchlistBtn.setStyle("-fx-background-color: #f5c518;");
        title.getStyleClass().add("text-yellow");
        detail.getStyleClass().add("text-white");
        genre.getStyleClass().add("text-white");
        genre.setStyle("-fx-font-style: italic");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setHgrow(title, Priority.ALWAYS);
        header.setHgrow(detailBtn, Priority.ALWAYS);
        title.setMaxWidth(Double.MAX_VALUE);
        //detailBtn.setMaxWidth(Double.MAX_VALUE);

        // layout
        title.fontProperty().set(title.getFont().font(20));
        detail.setWrapText(true);
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

        watchlistBtn.setOnMouseClicked(mouseEvent -> {
            addToWatchlistClicked.onClick(getItem());
        });
    }

    private VBox getDetails() {
        VBox details = new VBox();
        Label releaseYear = new Label("Release Year: " + getItem().getReleaseYear());
        Label length = new Label("Length: " + getItem().getLengthInMinutes() + " minutes");
        Label rating = new Label("Rating: " + getItem().getRating() + "/10");

        Label directors = new Label("Directors: " + String.join(", ", getItem().getDirectors()));
        Label writers = new Label("Writers: " + String.join(", ", getItem().getWriters()));
        Label mainCast = new Label("Main Cast: " + String.join(", ", getItem().getMainCast()));

        releaseYear.getStyleClass().add("text-white");
        length.getStyleClass().add("text-white");
        rating.getStyleClass().add("text-white");
        directors.getStyleClass().add("text-white");
        writers.getStyleClass().add("text-white");
        mainCast.getStyleClass().add("text-white");

        details.getChildren().add(releaseYear);
        details.getChildren().add(rating);
        details.getChildren().add(length);
        details.getChildren().add(directors);
        details.getChildren().add(writers);
        details.getChildren().add(mainCast);
        return details;
    }
    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setGraphic(null);
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");
            title.setText(movie.getTitle());
            detail.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );

            String genres = movie.getGenres()
                    .stream()
                    .map(Enum::toString)
                    .collect(Collectors.joining(", "));
            genre.setText(genres);

            detail.setMaxWidth(this.getScene().getWidth() - 30);

            setGraphic(layout);
        }
    }
}

