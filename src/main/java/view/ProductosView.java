package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.DropShadow;
import model.Producto;

public class ProductosView extends VBox {
    private TableView<Producto> tablaProductos;
    private Button btnConsultar;
    private TextField txtNombre;
    private TextField txtPrecio;
    private TextField txtUbicacion;
    private ComboBox<String> comboBoxConsultas;

    public ProductosView() {
        inicializarComponentes();
        configurarEstilos();
        organizarComponentes();
    }

    private void inicializarComponentes() {
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        txtUbicacion = new TextField();
        txtUbicacion.setPromptText("Ubicación");
        btnConsultar = new Button("Consultar Productos");
        tablaProductos = new TableView<>();
        comboBoxConsultas = new ComboBox<>();
        comboBoxConsultas.getItems().addAll(
                "Listar todos los productos, ordenados alfabéticamente por nombre",
                "Mostrar los productos que tienen un precio superior a $10.000",
                "Obtener los productos que pertenecen a la categoría 'Lácteos'",
                "Listar los productos que se encuentran en el pasillo 2",
                "Mostrar los 5 primeros productos de la lista",
                "Consultar todos  los productos que el nombre comienza con la letra 'A'",
                "Buscar los productos que contienen la palabra 'Arroz' en su nombre",
                "Buscar los productos que no tienen  ubicación específica",
                "Listar los clientes ordenados por fecha de nacimiento de menor a mayor",
                "Mostrar los clientes que nacieron en el año 1990 o posterior"
        );
        comboBoxConsultas.setValue("Seleccionar consulta");
    }

    private void configurarEstilos() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: linear-gradient(to right, #ff9a9e, #fad0c4);");

        String fieldStyle = "-fx-background-color: transparent; -fx-border-color: #d3d3d3; " +
                "-fx-border-width: 0 0 2 0; -fx-text-fill: #555555; " +
                "-fx-prompt-text-fill: #aaaaaa;";
        txtNombre.setStyle(fieldStyle);
        txtPrecio.setStyle(fieldStyle);
        txtUbicacion.setStyle(fieldStyle);

        btnConsultar.setStyle("-fx-background-color: #b3e5fc; -fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; -fx-background-radius: 25;");

        txtNombre.setPrefHeight(40);
        txtPrecio.setPrefHeight(40);
        txtUbicacion.setPrefHeight(40);
        btnConsultar.setPrefHeight(50);

        txtNombre.setMaxWidth(250);
        txtPrecio.setMaxWidth(250);
        txtUbicacion.setMaxWidth(250);
        btnConsultar.setMaxWidth(350);

        comboBoxConsultas.setPrefWidth(350);
        comboBoxConsultas.setStyle("-fx-background-color: transparent; -fx-border-color: #d3d3d3; " +
                "-fx-border-width: 0 0 2 0; -fx-text-fill: #555555;");

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.3));
        btnConsultar.setEffect(shadow);

        tablaProductos.setStyle("-fx-background-color: rgba(211, 211, 211, 0.1); -fx-text-fill: #555555;");
    }

    private void organizarComponentes() {
        Label titleLabel = new Label(" Busqueda");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        titleLabel.setTextFill(Color.WHITE);

        HBox searchBox = new HBox(20);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.getChildren().addAll(txtNombre, txtPrecio, txtUbicacion);

        HBox comboBoxBox = new HBox(20);
        comboBoxBox.setAlignment(Pos.CENTER);
        comboBoxBox.getChildren().addAll(new Label("Consulta:"), comboBoxConsultas);

        configurarTabla();

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().addAll(comboBoxBox, searchBox, btnConsultar, tablaProductos);

        this.getChildren().addAll(titleLabel, contentBox);
    }

    private void configurarTabla() {
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Producto, Number> colId = new TableColumn<>("ID");
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");
        TableColumn<Producto, String> colTipo = new TableColumn<>("Tipo");
        TableColumn<Producto, String> colUbicacion = new TableColumn<>("Ubicación");

        colId.setCellValueFactory(cellData -> cellData.getValue().idProductoProperty());
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        colTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        colUbicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());

        tablaProductos.getColumns().addAll(colId, colNombre, colPrecio, colTipo, colUbicacion);

        // Estilo para las columnas
        String columnStyle = "-fx-text-fill: #555555;";
        colId.setStyle(columnStyle);
        colNombre.setStyle(columnStyle);
        colPrecio.setStyle(columnStyle);
        colTipo.setStyle(columnStyle);
        colUbicacion.setStyle(columnStyle);
    }

    // Getters
    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtPrecio() {
        return txtPrecio;
    }

    public TextField getTxtUbicacion() {
        return txtUbicacion;
    }

    public TableView<Producto> getTablaProductos() {
        return tablaProductos;
    }

    public Button getBtnConsultar() {
        return btnConsultar;
    }

    public ComboBox<String> getComboBoxConsultas() {
        return comboBoxConsultas;
    }
}
