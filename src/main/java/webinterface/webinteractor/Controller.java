package webinterface.webinteractor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import webinterface.webinteractor.Model.*;
public class Controller {
    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private TableColumn<Customer, Long> pnoColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

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
    private ObservableList<Customer> customers;
    public Controller() {
        this.database = new dbCommunication();

        Customer customer = new Customer(9904061234L, "Carl", "Gröning");
        customers = FXCollections.observableArrayList();
    }

    public void logInButtonClicked() throws DbException {
        if (!isLoggedIn) {
            System.out.println("User logged in...");
            logInButton.setText("logged in as:");
            String username = usernameField.getText();
            String password = passwordField.getText();
            logInButton.setText("logged in as: "+username);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            usernameField.setVisible(false);
            passwordField.setVisible(false);
            isLoggedIn = true;
            logOutMenuObj.setVisible(true);
            database.connect("TheZone",username,password);
        } else {
            System.out.println("Already logged in.");
        }
    }
    public void logOutMenuClicked() throws DbException {
        usernameField.setVisible(true);
        passwordField.setVisible(true);
        logInButton.setText("log In");
        isLoggedIn = false;
        logOutMenuObj.setVisible(false);
        database.disconnect("library");
        usernameField.setText("");
        passwordField.setText("");
    }


}