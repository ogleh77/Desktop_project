package com.example.project;

import com.example.project.controllers.RegistrationController;
import com.example.project.entities.Customers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/views/registrations.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        RegistrationController controller = fxmlLoader.getController();

        var customer = new Customers(1, "Luul", "Ahmed", "Jama",
                "4303924", "Female", "Morning", "Actober",
                null, 80, "jamko");
       // controller.setCustomer(customer);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}