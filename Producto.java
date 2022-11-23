/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones_arias_acosta;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Producto {
    
    private String nombre;
    private double precio;
    private int cantidad;
    private ArrayList<String> categoria;
    private int vendidos;
    private final Proveedor VENDEDOR;

    public Producto(String nombre, double precio, int cantidad, Proveedor vendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        vendidos = 0;
        categoria = new ArrayList();
        VENDEDOR = vendedor;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    /**
     * @return the categoria
     */
    public ArrayList<String> getCategoria() {
        return categoria;
    }
    
    /**
     * @return the VENDEDOR
     */
    public Proveedor getVENDEDOR() {
        return VENDEDOR;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append("Precio: ").append(precio);
        sb.append("Cantidad: ").append(cantidad);
        sb.append("Categorias: ").append(categoria);
        return sb.toString();
    }


      
    
}
