module f71863.test1.view {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.controls;
    requires f71863.test1.model;

    opens f71863.test1.view to javafx.fxml;
    exports f71863.test1.view;
}