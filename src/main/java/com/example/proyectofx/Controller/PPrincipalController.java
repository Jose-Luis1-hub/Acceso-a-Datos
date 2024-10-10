package com.example.proyectofx.Controller;
import com.example.proyectofx.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PPrincipalController {

        @FXML
        private Button cerrarSesionId;

        @FXML
        private Button hacerPedidoId;

        @FXML
        private Button introducirId;

        @FXML
        private Button verStockId;

        @FXML
        void onCerrarSesionClick(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CerrarSesion.fxml"));
                        Parent root = fxmlLoader.load();
                        CerrarSesionController controller = fxmlLoader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) cerrarSesionId.getScene().getWindow();
                        stage.setScene(scene);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void onIntroducirClick(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("IntroducirProducto.fxml"));
                        Parent root = fxmlLoader.load();
                        IntroducirProductoController controller = fxmlLoader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) introducirId.getScene().getWindow();
                        stage.setScene(scene);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void onRealizarPedidoClick(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("RealizarPedido.fxml"));
                        Parent root = fxmlLoader.load();
                        RealizarPedidoController controller = fxmlLoader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) hacerPedidoId.getScene().getWindow();
                        stage.setScene(scene);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void onVisualizarStockClick(ActionEvent event) {
                try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VisualizarStock.fxml"));
                        Parent root = fxmlLoader.load();
                        VisualizarStockController controller = fxmlLoader.getController();

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) verStockId.getScene().getWindow();
                        stage.setScene(scene);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

    }


