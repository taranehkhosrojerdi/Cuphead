module com.example.graphictest {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.graphictest to javafx.fxml;
    exports com.example.graphictest;
    exports com.example.graphictest.View;
    opens com.example.graphictest.View to javafx.fxml;
    exports com.example.graphictest.Controller;
    opens com.example.graphictest.Controller to javafx.fxml;
    exports com.example.graphictest.Model.Components;
}