package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.model.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.stream.Collectors;

public class MovieCell extends ListCell<Movie> {
    private final ClickEventHandler<Movie> onRemoveFromWatchlistClicked;
    private final ClickEventHandler<Movie> onAddToWatchlistClicked;
    private final Label title = new Label();
    private final Label detail = new Label();
    private final Label genres = new Label();
    private final Label rating = new Label();
    private final Label releaseYear = new Label();
    private final Label lengthInMinutes = new Label();
    private final Label directors = new Label();
    private final Label writers = new Label();
    private final Label mainCast = new Label();
    private final StackPane stackPane = new StackPane();
    private final Button detailButton = new Button("Show details");
    private final Button watchlistButton = new Button("Add to watchlist");
    private final VBox buttons = new VBox(detailButton, watchlistButton);
    private final VBox layout = new VBox(title, detail, genres, releaseYear, lengthInMinutes, directors, writers, mainCast, rating, buttons);

    public MovieCell(ClickEventHandler<Movie> onAddToWatchlistClicked, ClickEventHandler<Movie> onRemoveFromWatchlistClicked) {
        super();
        this.onAddToWatchlistClicked = onAddToWatchlistClicked;
        this.onRemoveFromWatchlistClicked = onRemoveFromWatchlistClicked;
        detailButton.setOnMouseClicked(mouseEvent -> toggleDetails());
        watchlistButton.setOnMouseClicked(mouseEvent -> this.onAddToWatchlistClicked.onClick(getItem()));
    }

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setText(null);
            setGraphic(null);
        } else {
            this.getStyleClass().add("movie-cell");

            // stack pane config
            StackPane.setAlignment(buttons, Pos.CENTER_RIGHT);
            StackPane.setMargin(buttons, new Insets(0, 10, 0, 0));
            stackPane.getChildren().setAll(layout, buttons);

            // buttons config
            buttons.setSpacing(10);
            buttons.setPadding(new Insets(0, 0, 0, 0));
            buttons.setAlignment(Pos.CENTER_RIGHT);

            // detail button
            detailButton.getStyleClass().add("background-yellow");

            // watchlist button
            watchlistButton.getStyleClass().add("background-yellow");

            if(movie.isInWatchlist()) {
                watchlistButton.setText("Remove from watchlist");
                watchlistButton.setOnMouseClicked(mouseEvent -> this.onRemoveFromWatchlistClicked.onClick(getItem()));
            } else {
                watchlistButton.setText("Add to watchlist");
                watchlistButton.setOnMouseClicked(mouseEvent -> this.onAddToWatchlistClicked.onClick(getItem()));
            }

            // set labels
            setTitleLabel(movie);
            setDetailLabel(movie);
            setGenresLabel(movie);
            setReleaseYearLabel(movie);
            setLengthInMinutesLabel(movie);
            setDirectorsLabel(movie);
            setWritersLabel(movie);
            setMainCastLabel(movie);
            setRatingLabel(movie);

            bindManagedProperties();

            // color scheme
            title.getStyleClass().add("text-yellow");
            detail.getStyleClass().add("text-white");
            genres.getStyleClass().addAll("text-white", "text-italic");
            rating.getStyleClass().add("text-white");
            releaseYear.getStyleClass().add("text-white");
            lengthInMinutes.getStyleClass().add("text-white");
            directors.getStyleClass().addAll("text-white", "text-italic");
            writers.getStyleClass().addAll("text-white", "text-italic");
            mainCast.getStyleClass().addAll("text-white", "text-italic");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // layout
            title.getFont();
            title.fontProperty().set(Font.font(20));
            detail.setMaxWidth(this.getScene().getWidth() - 200);
            detail.setWrapText(true);
            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);

            setGraphic(stackPane);
        }
    }

    private void setTitleLabel(Movie movie) {
        title.setText(movie.getTitle());
    }

    private void setDetailLabel(Movie movie) {
        detail.setText(
                movie.getDescription() != null
                        ? movie.getDescription()
                        : "No description available"
        );
    }

    private void setGenresLabel(Movie movie) {
        genres.setText(
                movie.getGenres() != null
                        ? ("Genres: " + movie.getGenres().stream().map(String::toString).collect(Collectors.joining(", ")))
                        : ("No genres available")
        );
    }

    private void setRatingLabel(Movie movie) {
        rating.setText(
                movie.getRating() != 0
                        ? ("Rating: " + movie.getRating())
                        : ("No rating available")
        );

        rating.setVisible(false);
    }

    private void setReleaseYearLabel(Movie movie) {
        releaseYear.setText(
                movie.getReleaseYear() != 0
                        ? ("Release Year: " + movie.getReleaseYear())
                        : ("No release year available")
        );

        releaseYear.setVisible(false);
    }

    private void setLengthInMinutesLabel(Movie movie) {
        lengthInMinutes.setText(
                movie.getLengthInMinutes() != 0
                        ? ("Length in minutes: " + movie.getLengthInMinutes())
                        : ("No length in minutes available")
        );

        lengthInMinutes.setVisible(false);
    }

    private void setDirectorsLabel(Movie movie) {
        directors.setText(
                movie.getDirectors() != null
                        ? ("Directors: " + movie.getDirectors().stream().map(String::toString).collect(Collectors.joining(", ")))
                        : ("No Directors available")
        );

        directors.setVisible(false);
    }

    private void setWritersLabel(Movie movie) {
        writers.setText(
                movie.getWriters() != null
                        ? ("Writers: " + movie.getWriters().stream().map(String::toString).collect(Collectors.joining(", ")))
                        : ("No Writers available")
        );

        writers.setVisible(false);
    }

    private void setMainCastLabel(Movie movie) {
        mainCast.setText(
                movie.getMainCast() != null
                        ? ("Main Cast: " + movie.getMainCast().stream().map(String::toString).collect(Collectors.joining(", ")))
                        : ("No Main Cast available")
        );

        mainCast.setVisible(false);
    }

    public void toggleDetails() {
        if(detailButton.getText().equals("Show details")){
            detailButton.setText("Hide details");
            releaseYear.setVisible(true);
            lengthInMinutes.setVisible(true);
            directors.setVisible(true);
            writers.setVisible(true);
            mainCast.setVisible(true);
            rating.setVisible(true);
        } else {
            detailButton.setText("Show details");
            releaseYear.setVisible(false);
            lengthInMinutes.setVisible(false);
            directors.setVisible(false);
            writers.setVisible(false);
            mainCast.setVisible(false);
            rating.setVisible(false);
        }
    }

    private void bindManagedProperties() {
        releaseYear.managedProperty().bind(releaseYear.visibleProperty());
        lengthInMinutes.managedProperty().bind(lengthInMinutes.visibleProperty());
        directors.managedProperty().bind(directors.visibleProperty());
        writers.managedProperty().bind(writers.visibleProperty());
        mainCast.managedProperty().bind(mainCast.visibleProperty());
        rating.managedProperty().bind(rating.visibleProperty());
    }
}