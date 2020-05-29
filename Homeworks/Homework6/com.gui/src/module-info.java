module com.gui {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires com.services;
    requires com.providers;

    opens gui to javafx.fxml;
    exports gui;

}