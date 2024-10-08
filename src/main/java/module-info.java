module com.example.mazebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.mazebank to javafx.fxml;
    exports com.example.mazebank;
    exports com.example.mazebank.Controllers;
    exports com.example.mazebank.Controllers.Admin;
    exports com.example.mazebank.Controllers.Client;
    exports com.example.mazebank.Models;
    exports com.example.mazebank.Views;
}