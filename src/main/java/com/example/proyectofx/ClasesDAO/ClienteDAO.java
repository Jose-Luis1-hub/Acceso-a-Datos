package com.example.proyectofx.ClasesDAO;

import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Cliente;
import com.example.proyectofx.Clases.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    public static ArrayList<Cliente> obtenerClientes() {
        Cliente cliente;
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT correo, contraseña FROM CLIENTES";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String correo = resultSet.getString("correo");
                String contrasena = resultSet.getString("contraseña");
                cliente = new Cliente(correo, contrasena);
                clientes.add(cliente);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public static boolean comprobarUsuario(Cliente cliente) {
        boolean comprobar = false;
        ArrayList<Cliente> clientes;
        clientes = obtenerClientes();
        for (Cliente cliente1 : clientes) {
            if (cliente1.getUsuario().equals(cliente.getUsuario())) {
                if(cliente1.getContrasena().equals(cliente.getContrasena())) {
                    comprobar = true;
                }
            }
        }
        return comprobar;
    }

    public static void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (Correo, Contraseña) VALUES (?, ?)";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,cliente.getUsuario());
            statement.setString(2,cliente.getContrasena());
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int idGenerado = resultSet.getInt(1);
                cliente.setClienteId(idGenerado);
            }
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                Alerta.Info("El usuario se ha creado correctamente", "ÉXITO!!!");
            } else {
                Alerta.Error("El usuario no se ha creado");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
