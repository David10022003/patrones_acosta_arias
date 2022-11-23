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
public class BuscarProducto {
    
       
    public ArrayList<Producto> buscar(String palabra, int opcion, CatalogoProductos catalogo){
        ArrayList<Producto> busqueda = new ArrayList();
        if(opcion == 1)
            busqueda.add(catalogo.buscarProductoNombre(palabra));    
        if(opcion == 2)
            busqueda = catalogo.buscarProductosCategoria(palabra);
        return busqueda;
    }    
}
