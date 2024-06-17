package webinterface.webinteractor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import webinterface.webinteractor.Model.*;


public class defaultViewController {
    @FXML
    private TableView<Customer> customerTableView;

    @FXML
    private Button UserButton;

    @FXML
    private MenuItem logOutMenuObj;

    private dbCommunication database;
    private ObservableList<Customer> customers;

    public defaultViewController() {
        this.database = new dbCommunication();
        customerTableView = new TableView<>();
        customers = FXCollections.observableArrayList(
                new Customer(9904061234L, "Carl", "Gröning"),
                new Customer(1234567890L, "John", "Doe"),
                new Customer(9876543210L, "Jane", "Smith")
        );
        initOrderView();
    }
    private void initOrderView(){
        customerTableView.setItems(customers);

    }

    public void displayName(String userName) throws DbException {
            System.out.println("User logged in as: "+userName);
            UserButton.setText("logged in as:"+userName);
    }
    public void logOutMenuClicked() throws DbException {
        UserButton.setText("log In");
        database.disconnect("library");
        //ChangeScene( (Stage) usernameField.getScene().getWindow(),"logInScreen");
    }

}