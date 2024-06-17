module webinterface.webinteractor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens webinterface.webinteractor to javafx.fxml;
    exports webinterface.webinteractor;
}