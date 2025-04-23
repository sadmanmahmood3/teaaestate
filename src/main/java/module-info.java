module com.examplecclass.teaaestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.logging;

    opens com.examplecclass.teaaestate to javafx.fxml;
    opens com.examplecclass.teaaestate.controllers to javafx.fxml;
    opens com.examplecclass.teaaestate.models to javafx.base;

    exports com.examplecclass.teaaestate;
    exports com.examplecclass.teaaestate.controllers;
    exports com.examplecclass.teaaestate.models;
}
