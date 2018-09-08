package FX.Utils;

import javafx.scene.control.Alert;

public class Dialog1 {
public Dialog1() {}

public void showErrorDialog(String title, String text) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(text);
    alert.setHeaderText("");
    alert.showAndWait();
}

public void showInfoDialog(String title, String text) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setContentText(text);
    alert.setHeaderText("");
    alert.showAndWait();
}
}
