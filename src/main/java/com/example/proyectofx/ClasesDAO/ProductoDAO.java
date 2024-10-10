package com.example.proyectofx.ClasesDAO;

import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Conectar;
import com.example.proyectofx.Clases.Producto;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ProductoDAO {
    public static void introducirProducto(Producto producto) { //introducir un producto
        String sql = "INSERT INTO productos (nombre,precio,stock,categoria) VALUES (?,?,?,?)";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,producto.getNombre());
            statement.setDouble(2,producto.getPrecio());
            statement.setInt(3,producto.getStock());
            statement.setString(4, producto.getCategoria());
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    int idGenerado = resultSet.getInt(1);
                    producto.setProductoID(idGenerado);
                }
            }
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                Alerta.Info("Producto creado", "ÉXITO!!!");
            } else {
                Alerta.Error("Producto no creado");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> obtenerProductos() { //metodo para guardar en el combobox
        ArrayList<String> listaProductos = new ArrayList<>();
        String sql = "SELECT nombre FROM productos";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                listaProductos.add(nombre);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaProductos;
    }

    public static ArrayList<Producto> obtenerStockProducto() { //obtener el stock del producto para insertar en tabla
        Producto producto;
        ArrayList<Producto> listadoProductos = new ArrayList<>();
        String sql = "SELECT nombre, stock FROM productos";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                int stock = resultSet.getInt("Stock");
                producto = new Producto(nombre,stock);
                listadoProductos.add(producto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listadoProductos;
    }

    public static int obtenerIDProducto(String producto) {
        int id = -1;
        String sql = "SELECT ProductoID FROM productos WHERE nombre = ?";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, producto);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("ProductoID");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
