package webinterface.webinteractor;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import webinterface.webinteractor.Model.*;
public class Controller {
    @FXML
    private Button logInButton;
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private MenuItem logOutMenuObj;

    private boolean isLoggedIn = false;
    private dbCommunication database;

    public void logInButtonClicked(){
        if (!isLoggedIn) {
            System.out.println("User logged in...");
            logInButton.setText("logged in");
            String username = usernameField.getText(); // Retrieve the text from the username field
            String password = passwordField.getText(); // Retrieve the text from the password field
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            usernameField.setVisible(false);
            passwordField.setVisible(false);
            isLoggedIn = true;
            logOutMenuObj.setVisible(true);
        } else {
            // Already logged in, do nothing or provide feedback
            System.out.println("Already logged in.");
        }
    }
    public void logOutMenuClicked(){
        usernameField.setVisible(true);
        passwordField.setVisible(true);
        logInButton.setText("log In");
        isLoggedIn = false;
        logOutMenuObj.setVisible(false);
    }


}