package webinterface.webinteractor;

import javafx.scene.control.Alert;

public class GeneralMessages {
    protected static void showAlertAndWait(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type, msg);
        alert.showAndWait();
    }
}
