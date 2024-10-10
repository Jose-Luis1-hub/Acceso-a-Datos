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

public class CerrarSesionController {
        @FXML
        private Button no;

        @FXML
        private Button si;

        @FXML
        void onCerrarSesionClick(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Registrar.fxml"));
                Parent root = fxmlLoader.load();
                RegistrarController controller = fxmlLoader.getController();

                Scene scene = new Scene(root);
                Stage stage = (Stage) si.getScene().getWindow();
                stage.setScene(scene);
        }

        @FXML
        void onInicioClick(ActionEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PPrincipal.fxml"));
                Parent root = fxmlLoader.load();
                PPrincipalController controller = fxmlLoader.getController();

                Scene scene = new Scene(root);
                Stage stage = (Stage) no.getScene().getWindow();
                stage.setScene(scene);
        }

    }

