package com.example.proyectofx.Clases;

public class Pedido {
    int clienteId;
    int productoId;
    int pedidoId;
    int cantidad;

    public Pedido(int clienteId, int productoId, int pedidoId, int cantidad) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.pedidoId = pedidoId;
        this.cantidad = cantidad;
    }

    public Pedido(int clienteId, int productoId, int cantidad) {
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Pedido() {
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPedidoId(int idGenerado) {
        return pedidoId;
    }



    @Override
    public String toString() {
        return "Pedido{" +
                "clienteId=" + clienteId +
                ", productoId=" + productoId +
                ", pedidoId=" + pedidoId +
                ", cantidad=" + cantidad +
                '}';
    }
}
