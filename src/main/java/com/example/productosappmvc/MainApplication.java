package com.example.productosappmvc;

import controller.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginView;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
        // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            LoginView loginView = new LoginView();
            LoginController loginController = new LoginController(loginView);
            Scene scene = new Scene(loginView, 520, 400);
            primaryStage.setTitle("Iniciar  Sesión");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Mostrar un mensaje de error al usuario
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
