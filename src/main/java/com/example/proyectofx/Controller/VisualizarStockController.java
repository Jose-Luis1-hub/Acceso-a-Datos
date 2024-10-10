package com.example.proyectofx.Controller;
import com.example.proyectofx.App;
import com.example.proyectofx.Clases.Producto;
import com.example.proyectofx.ClasesDAO.ProductoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class VisualizarStockController {
        @FXML
        private Button CancelarIDBoton;

        @FXML
        private TableColumn<Producto, String> ProductoIdTabla;

        @FXML
        private TableColumn<Producto, Integer> StockIdTabla;

        @FXML
        private TextArea stockId;

        @FXML
        private TableView<Producto> tablaId;

        public void initialize() {
                ProductoIdTabla.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
                StockIdTabla.setCellValueFactory(new PropertyValueFactory<>("Stock"));
                ObservableList<Producto> productos = FXCollections.observableArrayList(ProductoDAO.obtenerStockProducto());
                tablaId.setItems(productos);
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


    }


