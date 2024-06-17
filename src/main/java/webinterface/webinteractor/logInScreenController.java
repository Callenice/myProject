package webinterface.webinteractor;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import webinterface.webinteractor.Model.DbException;
import webinterface.webinteractor.Model.dbCommunication;


import static webinterface.webinteractor.SceneChanger.ChangeToDefaultScene;

public class logInScreenController {
    private dbCommunication database;

    @FXML
    private Button logInButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    public logInScreenController() {
        this.database = new dbCommunication();
    }

    public void logInButtonClicked() throws DbException {
        System.out.println("User logged in...");
        logInButton.setText("logged in as:");
        String username = usernameField.getText();
        String password = passwordField.getText();
        try{
            if(database.connect("TheZone", username, password)){
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                ChangeToDefaultScene( (Stage) logInButton.getScene().getWindow(),username);
            }else{
                GeneralMessages.showAlertAndWait("Invalid log in", Alert.AlertType.ERROR);
            }
        } catch (DbException e) {
            GeneralMessages.showAlertAndWait(e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}
