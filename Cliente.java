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
public class Cliente extends Persona{
    
    private CarritoCompras carrito;  
    private CatalogoProductos productos;
    private double saldo;
    private ProxyPagos proxy;
    private BuscarProducto busq;
    private BuscarProductoAdaptador bAdap;
    
    public Cliente(String nombre, String id, String direccion, int telefono, double saldo){
        super(nombre, id, direccion, telefono);
        productos = CatalogoProductos.instance();
        carrito = new CarritoCompras();
        this.saldo = saldo;
                
    }
    
    public ArrayList<Producto> buscarProductosCategoria(String categoria){
        bAdap = new BuscarProductoAdaptador();
        return bAdap.buscar(categoria, 2, productos);
    }
    
    public ArrayList<Producto> buscarProductoNombre(String nombre){
        busq = new BuscarProducto();
        return busq.buscar(nombre, 1, productos);
    }
    
    public void agregarProductos(Producto producto){
        if(producto != null){    
            if(carrito.getListaProductos() == null){
                ArrayList<Producto> temp = new ArrayList();
                for (int i = 0; i < producto.getCantidad(); i++) {
                    temp.add(producto);
                }
                carrito.setListaProductos(temp);
            }
            else{
                carrito.getListaProductos().add(producto);
            }
            producto.setCantidad(producto.getCantidad()+1);
        }
    }
    
    public void retirarProductos(Producto producto){
        if(producto != null){    
            for (int i = 0; i < producto.getCantidad(); i++)
               carrito.getListaProductos().remove(producto); 

            producto.setCantidad(0);
        }
    }
    
    public double precioTotal(){
        return carrito.getValorTotal();
    }
    
    public void cambiarCantidad(Producto producto, int cantidad){
        if(producto != null){
            int retirar = producto.getCantidad() - cantidad;
            for (int i = 0; i < retirar; i++) 
               carrito.getListaProductos().remove(producto); 

            producto.setCantidad(cantidad);
        }
    }
    
    @Override
    public boolean pagar(double saldo, double total){
        if(proxy.pagar(saldo, total)){
            saldo = saldo - carrito.getValorTotal();
            for(int i=0; i < carrito.getListaProductos().size(); i++){
                notificarPago(carrito.getListaProductos().get(i).getVENDEDOR());
            }
            carrito.setCantidadProductos(0);
            carrito.setValorTotal(0);
            carrito.setListaProductos(null);
            return true;
        }
        return false;
    }
      
    

    public CarritoCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompras carrito) {
        this.carrito = carrito;
    }

    public double getSaldo() {
        return saldo;
    }

    public CatalogoProductos getProductos() {
        return productos;
    }
    
    
    public void notificarPago(Proveedor proveedor){
        proveedor.actualizar();
        actualizar();
    }
    
    @Override
    public void actualizar(){
        System.out.println("PARA EL CLIENTE: SU PAGO HA SIDO EXITOSO Y EL PROVEEDOR FUE INFORMADO");
    }
    
}
