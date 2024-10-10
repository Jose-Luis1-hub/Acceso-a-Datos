package com.example.proyectofx.Controller;
import com.example.proyectofx.App;
import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Producto;
import com.example.proyectofx.ClasesDAO.ProductoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroducirProductoController {

        @FXML
        private Button cancelarIDBoton;

        @FXML
        private TextField categoriaId;

        @FXML
        private Button introducirId;

        @FXML
        private TextField nombreId;

        @FXML
        private TextField precioId;

        @FXML
        private TextField stockId;

        @FXML
        void onIntroducirClick(ActionEvent event) {
                if(nombreId.getText().isEmpty() || stockId.getText().isEmpty() || precioId.getText().isEmpty() || categoriaId.getText().isEmpty()) {
                        Alerta.Error("No se han completado todos los campos");
                } else {
                        String nombreProducto = nombreId.getText();
                        int stockProducto = Integer.parseInt((stockId.getText().trim()));
                        double precioProducto = Integer.parseInt(precioId.getText());
                        String categoriaProducto = categoriaId.getText();
                        Producto producto = new Producto(nombreProducto, stockProducto,precioProducto,categoriaProducto);
                        ProductoDAO.introducirProducto(producto);
                        categoriaId.clear();
                        nombreId.clear();
                        precioId.clear();
                        stockId.clear();
                }
        }

        @FXML
        void onCancelarButtonClick(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PPrincipal.fxml"));
                Parent root = fxmlLoader.load();
                PPrincipalController controller = fxmlLoader.getController();

                Scene scene = new Scene(root);
                Stage stage = (Stage) cancelarIDBoton.getScene().getWindow();
                stage.setScene(scene);

        }

    }

