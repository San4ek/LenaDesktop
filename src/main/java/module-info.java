module com.example.lenadesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.example.lenadesktop to javafx.fxml;
    exports com.example.lenadesktop;
    exports com.example.lenadesktop.models;
    exports com.example.lenadesktop.controllers;
    opens com.example.lenadesktop.controllers to javafx.fxml;
    exports com.example.lenadesktop.exceptions;
    opens com.example.lenadesktop.exceptions to javafx.fxml;
}