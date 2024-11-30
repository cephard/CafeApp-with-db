module com.example.cafesystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.slf4j;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;

    opens com.example.cafesystem to javafx.fxml;
    opens com.example.cafesystem.Controllers to javafx.fxml;
    exports com.example.cafesystem;
    exports com.example.cafesystem.Controllers to javafx.fxml;
    exports com.example.cafesystem.Models;
}