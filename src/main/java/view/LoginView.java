package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.DropShadow;

public class LoginView extends VBox {
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button registerButton;

    public LoginView() {
        inicializarComponentes();
        configurarEstilos();
        organizarComponentes();
    }

    private void inicializarComponentes() {
        usernameField = new TextField();
        passwordField = new PasswordField();
        loginButton = new Button("🚪 INGRESAR");
        registerButton = new Button("📝 REGISTRARSE");
    }

    private void configurarEstilos() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: linear-gradient(to right, #ff9a9e, #fad0c4);");

        String fieldStyle = "-fx-background-color: transparent; -fx-border-color: #d3d3d3; " +
                "-fx-border-width: 0 0 2 0; -fx-text-fill: #555555; " +
                "-fx-prompt-text-fill: #aaaaaa;";
        usernameField.setStyle(fieldStyle);
        passwordField.setStyle(fieldStyle);
        usernameField.setPromptText("👤 Ingrese su Usuario");
        passwordField.setPromptText("🔒 Ingrese su Contraseña");

        loginButton.setStyle("-fx-background-color: #b3e5fc; -fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");
        registerButton.setStyle("-fx-background-color: #b3e5fc; -fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");

        usernameField.setPrefHeight(40);
        passwordField.setPrefHeight(40);
        loginButton.setPrefHeight(50);
        registerButton.setPrefHeight(50);

        usernameField.setMaxWidth(300);
        passwordField.setMaxWidth(300);
        loginButton.setMaxWidth(300);
        registerButton.setMaxWidth(300);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        loginButton.setEffect(shadow);
        registerButton.setEffect(shadow);
    }

    private void organizarComponentes() {
        Label titleLabel = new Label("🔑 INICIAR SESIÓN");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleLabel.setTextFill(Color.WHITE);

        VBox formBox = new VBox(20);
        formBox.setAlignment(Pos.CENTER);
        formBox.getChildren().addAll(usernameField, passwordField, registerButton, loginButton);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20));
        container.setStyle("-fx-background-color: rgba(255, 255, 255, 0.2); -fx-background-radius: 10;");
        container.getChildren().addAll(titleLabel, formBox);

        this.getChildren().add(container);
    }

    // Métodos para obtener los componentes
    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getRegisterButton() {
        return registerButton;
    }
}

