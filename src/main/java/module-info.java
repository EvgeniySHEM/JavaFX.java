module com.example.projectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.example.projectjavafx to javafx.fxml;
    exports com.example.projectjavafx;
}