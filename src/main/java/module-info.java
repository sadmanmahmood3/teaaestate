module com.examplecclass.teaaestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.examplecclass.teaaestate to javafx.fxml;
    exports com.examplecclass.teaaestate;
}