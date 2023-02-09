package com.example.project;

import com.example.project.controllers.PaymentController;
import com.example.project.controllers.RegistrationController;
import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/views/payments.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PaymentController controller = fxmlLoader.getController();

        var customer = new Customers("Luul", "Ahmed", "Jama",
                "4303924", "Female", "Morning", "Actober",
                null, 80, "jamko");

        Payments payments = new Payments(LocalDate.now().plusDays(30),
                12.0, "eDahab", 1, true, "4303924");
        customer.getPayments().add(payments);
        controller.setCustomer(customer);


        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}