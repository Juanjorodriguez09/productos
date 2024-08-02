package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RegistroView extends VBox {
    private TextField nombreField;
    private TextField fechaNacimientoField;
    private Button registerButton;
    private Button backButton;

    public RegistroView() {
        inicializarComponentes();
        configurarEstilos();
        organizarComponentes();
    }

    private void inicializarComponentes() {
        nombreField = new TextField();
        fechaNacimientoField = new TextField();
        registerButton = new Button("📝 REGISTRARSE");
        backButton = new Button("🔙 ATRÁS");
    }

    private void configurarEstilos() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: linear-gradient(to right, #ff9a9e, #fad0c4);");

        String fieldStyle = "-fx-background-color: transparent; -fx-border-color: #d3d3d3; " +
                "-fx-border-width: 0 0 2 0; -fx-text-fill: #555555; " +
                "-fx-prompt-text-fill: #aaaaaa;";
        nombreField.setStyle(fieldStyle);
        fechaNacimientoField.setStyle(fieldStyle);
        nombreField.setPromptText("👤 Ingrese su Nombre");
        fechaNacimientoField.setPromptText("📅 Ingrese su Fecha de Nacimiento (YYYY-MM-DD)");

        registerButton.setStyle("-fx-background-color: #b3e5fc; -fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");
        backButton.setStyle("-fx-background-color: #b3e5fc; -fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");

        nombreField.setPrefHeight(40);
        fechaNacimientoField.setPrefHeight(40);
        registerButton.setPrefHeight(50);
        backButton.setPrefHeight(50);

        nombreField.setMaxWidth(300);
        fechaNacimientoField.setMaxWidth(300);
        registerButton.setMaxWidth(300);
        backButton.setMaxWidth(300);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        registerButton.setEffect(shadow);
        backButton.setEffect(shadow);
    }

    private void organizarComponentes() {
        Label titleLabel = new Label("🔑 REGISTRARSE");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleLabel.setTextFill(Color.WHITE);

        VBox formBox = new VBox(20);
        formBox.setAlignment(Pos.CENTER);
        formBox.getChildren().addAll(nombreField, fechaNacimientoField, registerButton, backButton);

        VBox container = new VBox(20);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20));
        container.setStyle("-fx-background-color: rgba(255, 255, 255, 0.2); -fx-background-radius: 10;");
        container.getChildren().addAll(titleLabel, formBox);

        this.getChildren().add(container);
    }

    // Getters
    public TextField getNombreField() {
        return nombreField;
    }

    public TextField getFechaNacimientoField() {
        return fechaNacimientoField;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}
