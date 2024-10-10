package com.example.proyectofx.Controller;


import com.example.proyectofx.App;
import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Cliente;
import com.example.proyectofx.ClasesDAO.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;

public class RegistrarController {
        @FXML
        private PasswordField contrsenaID;

        @FXML
        private Button iniciarSesionIDBoton;

        @FXML
        private Button registrarIDBoton;

        @FXML
        private TextField usuarioID;

        @FXML
        void onIniciarSesionClick(ActionEvent event) {
                try {
                        if (usuarioID.getText().isEmpty() || contrsenaID.getText().isEmpty()) {
                                Alerta.Error("No se han completado todos los campos");
                        } else {
                                String correo = usuarioID.getText();
                                String contrasena = contrsenaID.getText();
                                String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena);
                                Cliente cliente = new Cliente(correo, contrasenaEncriptada);

                                if(ClienteDAO.comprobarUsuario(cliente)) {
                                        int idCliente = cliente.getClienteId();
                                        RealizarPedidoController.obtenerClienteIniciaSesion(idCliente);
                                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PPrincipal.fxml"));
                                        Parent root = fxmlLoader.load();
                                        PPrincipalController controller = fxmlLoader.getController();

                                        Scene scene = new Scene(root);
                                        Stage stage = (Stage) iniciarSesionIDBoton.getScene().getWindow();
                                        stage.setScene(scene);
                                } else {
                                        Alerta.Error("Debes registrar el usuario");
                                }
                        }

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @FXML
        void onRegistrarClick(ActionEvent event) {
                try {
                        if (usuarioID.getText().isEmpty() || contrsenaID.getText().isEmpty()) {
                                Alerta.Error("No se han completado todos los campos");
                        } else {
                                String correo = usuarioID.getText();
                                String contrasena = contrsenaID.getText();
                                String contrasenaEncriptada = DigestUtils.sha256Hex(contrasena);
                                Cliente cliente = new Cliente(correo, contrasenaEncriptada);
                                if(!ClienteDAO.comprobarUsuario(cliente)) {
                                        int idCliente = cliente.getClienteId();
                                        RealizarPedidoController.obtenerClienteIniciaSesion(idCliente);
                                        ClienteDAO.insertarCliente(cliente);
                                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PPrincipal.fxml"));
                                        Parent root = fxmlLoader.load();
                                        PPrincipalController controller = fxmlLoader.getController();

                                        Scene scene = new Scene(root);
                                        Stage stage = (Stage) registrarIDBoton.getScene().getWindow();
                                        stage.setScene(scene);

                                } else {
                                        Alerta.Error("El usuario ya existe. Inicie sesión");
                                }
                        }
                } catch (IOException e) {
                        System.out.println(e.getMessage());
                }
        }
}
