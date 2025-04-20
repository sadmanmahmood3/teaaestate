module com.examplecclass.teaaestate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.examplecclass.teaaestate to javafx.fxml;
    exports com.examplecclass.teaaestate;
}