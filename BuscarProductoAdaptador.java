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
public class BuscarProductoAdaptador {
    
    BuscarProducto busq;
    
      public ArrayList<Producto> buscar(String palabra, int opcion, CatalogoProductos catalogo){
          
          busq = new BuscarProducto();
          return busq.buscar(palabra, 2, catalogo);
      }
}
