package com.example.proyectofx.ClasesDAO;

import com.example.proyectofx.Clases.Alerta;
import com.example.proyectofx.Clases.Conectar;
import com.example.proyectofx.Clases.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PedidoDAO {
    public static void realizarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (ClienteID, ProductoID, Cantidad) VALUES (?,?,?)";
        try {
            Connection connection = Conectar.conectar();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, pedido.getClienteId());
            statement.setInt(2, pedido.getProductoId());
            statement.setInt(3, pedido.getCantidad());
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int idGenerado = resultSet.getInt(1);
                pedido.setPedidoId(idGenerado);
            }
            int colAfectadas = statement.executeUpdate();
            if(colAfectadas>0){
                Alerta.Info("Pedido realizado","ÉXITO!!!");
            } else {
                Alerta.Error("No se ha realizado el pedido");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
