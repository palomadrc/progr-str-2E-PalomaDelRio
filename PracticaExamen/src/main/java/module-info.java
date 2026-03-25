module com.example.practicaexamen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.practicaexamen to javafx.fxml;
    opens com.example.practicaexamen.controllers to javafx.fxml;
    opens com.example.practicaexamen.contactos to javafx.fxml;
    opens com.example.practicaexamen.services to javafx.fxml;
    exports com.example.practicaexamen;
    exports com.example.practicaexamen.controllers;
    exports com.example.practicaexamen.contactos;
    exports com.example.practicaexamen.services;
}