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

//APLICAR EL SINGLETON PARA INSTANCIAR SOLO UN CATÁLOGO
public class CatalogoProductos {
    
    private ArrayList<Producto> productos;
    
    private static CatalogoProductos instance;
    private CatalogoProductos(){
        productos = new ArrayList();
    }
    
    public static CatalogoProductos instance(){
        if(instance == null)
            instance = new CatalogoProductos();
        return instance;
    }
    
    public void adicionarProducto(Producto producto){
        productos.add(producto);
    }
    public void retirarProducto(Producto producto){
        productos.remove(producto);
    }
    
    public String mostraDetallesProducto(Producto producto){
        return producto.toString();
    }
    
    public Producto buscarProductoNombre(String nombre){
        for (Producto p : productos){
            if(p.getNombre().equalsIgnoreCase(nombre))
                return p;
        }
        return null;
    }
    
    public ArrayList<Producto> buscarProductosCategoria(String categoria){
        ArrayList<Producto> temp = new ArrayList<>();
        for(Producto p : productos){
            for(String s : p.getCategoria()){
                if(s.equalsIgnoreCase(categoria))
                    temp.add(p);
            }
        }
        if(!temp.isEmpty()) return temp;
        else return null;
    }
    
    public void actualizarProducto(Producto ant, Producto nue){
        productos.set(productos.indexOf(ant), nue);
    }
    
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    
}
