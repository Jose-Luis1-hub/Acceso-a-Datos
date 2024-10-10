package com.example.proyectofx.Clases;

import java.time.LocalDate;

public class Producto {
    int productoID;
    String nombre;
    double precio;
    int stock;
    String categoria;

    public Producto(int productoID, String nombre, double precio, int stock, String categoria) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public Producto(String nombre, int stock, double precioProducto, String categoriaProducto) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(int productoId, int stock, LocalDate fecha) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getProductoID() {
        return productoID;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productoID=" + productoID +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
