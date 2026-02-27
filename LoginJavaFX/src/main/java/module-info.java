module com.example.loginjavafx {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.loginjavafx to javafx.fxml;
    opens com.example.loginjavafx.controllers to javafx.fxml;

    exports com.example.loginjavafx;
}