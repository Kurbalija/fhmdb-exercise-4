package at.ac.fhcampuswien.fhmdb.ui;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class UserDialog {
    Dialog<String> dialog;

    public UserDialog(String title, String msg){
        dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setContentText(msg);

        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(type);
    }

    public void show() {
        dialog.showAndWait();
    }
}
