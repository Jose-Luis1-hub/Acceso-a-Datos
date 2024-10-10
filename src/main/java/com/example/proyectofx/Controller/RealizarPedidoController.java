package com.example.proyectofx.Controller;

import com.example.proyectofx.App;
import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Pedido;
import com.example.proyectofx.ClasesDAO.PedidoDAO;
import com.example.proyectofx.ClasesDAO.ProductoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RealizarPedidoController {


    @FXML
    private Button CancelarIDBoton;

    @FXML
    private ComboBox<String> escogerProductoId;

    @FXML
    private Button realizarPedidoId;

    @FXML
    private TextField stockId;
    static int id2;

    @FXML
    void onRealizarPedidoClick(ActionEvent event) {
        if (escogerProductoId.getValue().isEmpty() || stockId.getText().isEmpty()) {
            Alerta.Error("Completa todos los campos");
        } else {
            String producto = escogerProductoId.getValue();
            int idProducto = ProductoDAO.obtenerIDProducto(producto);
            int stock = Integer.parseInt(stockId.getText());
            Pedido pedido = new Pedido(id2, stock, idProducto);
            PedidoDAO.realizarPedido(pedido);
        }
    }

    public static void obtenerClienteIniciaSesion(int id) {
        id2= id;
    }

    public static void obtenerClienteRegistrar(int id) {
        id2= id;

    }


    @FXML
    void onCancelarButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("PPrincipal.fxml"));
        Parent root = fxmlLoader.load();
        PPrincipalController controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        Stage stage = (Stage) CancelarIDBoton.getScene().getWindow();
        stage.setScene(scene);
    }

    public void initialize(){ //combobox
        ObservableList<String> productoCombobox = FXCollections.observableArrayList(ProductoDAO.obtenerProductos());
        escogerProductoId.setItems(productoCombobox);
    }

}
