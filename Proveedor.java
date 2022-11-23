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
public class Proveedor extends Persona{
    
    private CatalogoProductos productos;
    private BuscarProducto busq;
    
    public Proveedor(String nombre, String id, String direccion, int telefono){
        super(nombre, id, direccion, telefono);
        productos = CatalogoProductos.instance();
    }
        
    public void retirarProducto(Producto producto){
        productos.eliminarProducto(producto);
    }
    
    public void actualizarProducto(Producto productoAnt, Producto productoNue){
        productos.actualizarProducto(productoAnt, productoNue);
    }
    
    public void adicionarProducto(Producto producto){
        productos.adicionarProducto(producto);
    }
    
    public String consultarEstadiscticas(Producto producto){
        String salida="";
        salida += "Vendidos: "+producto.getVendidos() +"\n"
                + "Ganancias: "+producto.getVendidos()*producto.getPrecio()+"\n"
                + "Porcentaje de ventas: "+producto.getCantidad()/producto.getVendidos()+"";
        return salida;
    }
    
    public ArrayList<Producto> buscarProductosNombre(String nombre){
        busq = new BuscarProducto();
        return busq.buscar(nombre, 1, productos);
    }
    
    public ArrayList<Producto> buscarProductosCategoria(String categoria){
        busq = new BuscarProducto();
        return busq.buscar(categoria, 2, productos);
    }
    
    @Override
    public void actualizar(){
        System.out.println("PARA EL PROVEEDOR: EL CLIENTE HA COMPRADO UN PRODUCTO");
    } 

    @Override
    public boolean pagar(double saldo, double total) {
        return false;
    }
    
}
