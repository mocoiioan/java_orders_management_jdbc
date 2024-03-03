module com.example.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.assignment3 to javafx.fxml;
    exports com.example.assignment3;
}