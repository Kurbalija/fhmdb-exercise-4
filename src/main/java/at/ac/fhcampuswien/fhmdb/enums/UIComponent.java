package at.ac.fhcampuswien.fhmdb.enums;

public enum UIComponent {
    HOME("/fxml/home.fxml"),
    WATCHLIST("/fxml/watchlist.fxml"),
    MOVIELIST("/fxml/movie-list.fxml");

    public final String path;

    UIComponent(String path){
        this.path = path;
    }
}