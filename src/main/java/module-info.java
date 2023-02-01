module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.testng;
    requires com.jfoenix;

    opens com.example.project to javafx.fxml;
    opens com.example.project.controllers to javafx.fxml;
    exports com.example.project;
}