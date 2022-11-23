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
public class CarritoCompras {
    
    private double valorTotal;
    private int cantidadProductos;
    private ArrayList<Producto> listaProductos;

    public CarritoCompras() {
        listaProductos = new ArrayList();
        valorTotal = 0;
        cantidadProductos = 0;
    }

    public double getValorTotal() {
        double valor = 0;
        for (int i = 0; i < listaProductos.size()-1; i++) {
            valor += listaProductos.get(i).getPrecio();
        }
        return valor;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCantidadProductos() {
        return listaProductos.size()-1;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
}
